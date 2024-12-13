package com.capstoneproject.helper

import android.content.Context
import android.graphics.Bitmap
import android.os.SystemClock
import android.util.Log
import androidx.camera.core.ImageProxy
import com.capstoneproject.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class ImageClassifierHelper(
    val context: Context,
    val classifierListener: ClassifierListener?
) {

    private var model: Model? = null
    private val THRESHOLD = 0.2f
    init {
        setupModel()
    }

    private fun setupModel() {
        try {
            model = Model.newInstance(context)
        } catch (e: Exception) {
            classifierListener?.onError("Failed to initialize model: ${e.message}")
            Log.e(TAG, "setupModel: ${e.message}")
        }
    }

    fun classifyImage(image: ImageProxy) {
        if (model == null) {
            setupModel()
        }

        try {

            val bitmap = toBitmap(image)
            val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)


            val tensorImage = TensorImage(DataType.FLOAT32)
            tensorImage.load(resizedBitmap)

            Log.d("Preprocessing", "TensorImage buffer size: ${tensorImage.buffer.remaining()} bytes")
            Log.d("Preprocessing", "Expected size: 270000 bytes")

            val inputFeature0 = TensorBuffer.createFixedSize(
                intArrayOf(1, 224, 224, 3), DataType.FLOAT32
            )
            inputFeature0.loadBuffer(tensorImage.buffer)


            var inferenceTime = SystemClock.uptimeMillis()
            val outputs = model?.process(inputFeature0)
            inferenceTime = SystemClock.uptimeMillis() - inferenceTime

            val outputFeature0 = outputs?.outputFeature0AsTensorBuffer
            val probabilities = outputFeature0?.floatArray

            if (probabilities != null) {
                val labels = listOf("Cabbage", "Carrot", "Papaya","Cauliflower","Unknown")
                val results = probabilities.mapIndexed { index, prob ->
                    Category(labels.getOrElse(index) { "Unknown" }, prob)
                }.sortedByDescending { it.score }

                classifierListener?.onResults(results, inferenceTime)
            } else {
                classifierListener?.onError("Failed to process image.")
            }
        } catch (e: Exception) {
            classifierListener?.onError("Error processing image: ${e.message}")
            Log.e(TAG, e.message.toString())
        } finally {
            image.close()
        }
    }

    private fun toBitmap(image: ImageProxy): Bitmap {
        val bitmapBuffer = Bitmap.createBitmap(
            image.width,
            image.height,
            Bitmap.Config.ARGB_8888
        )
        image.use { bitmapBuffer.copyPixelsFromBuffer(image.planes[0].buffer) }
        return bitmapBuffer
    }

    interface ClassifierListener {
        fun onError(error: String)
        fun onResults(
            results: List<Category>?,
            inferenceTime: Long
        )
    }

    data class Category(
        val label: String,
        val score: Float
    )

    companion object {
        private const val TAG = "ImageClassifierHelper"
    }
}
