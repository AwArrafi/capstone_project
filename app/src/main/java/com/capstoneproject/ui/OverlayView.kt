package com.capstoneproject.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class OverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = 0xFFFF0000.toInt() // Warna merah
        style = Paint.Style.STROKE
        strokeWidth = 8f // Ketebalan garis
    }

    private var boundingBoxes: List<BoundingBox> = emptyList()

    // Fungsi untuk mengupdate bounding box dari hasil model
    fun updateBoxes(boxes: List<BoundingBox>) {
        boundingBoxes = boxes
        invalidate() // Meminta View untuk digambar ulang
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Gambar setiap bounding box
        boundingBoxes.forEach { box ->
            canvas.drawRect(
                box.left,
                box.top,
                box.right,
                box.bottom,
                paint
            )
        }
    }

    data class BoundingBox(
        val left: Float,
        val top: Float,
        val right: Float,
        val bottom: Float
    )
}
