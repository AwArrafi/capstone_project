package com.capstoneproject.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View

class OverlayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private var boundingBoxes: List<BoundingBox> = emptyList()

    /**
     * Update the bounding boxes and redraw the overlay.
     * @param boxes The list of bounding boxes with labels.
     */
    fun updateBoxes(boxes: List<BoundingBox>) {
        boundingBoxes = boxes
        invalidate()
    }

    override fun onDraw(canvas: android.graphics.Canvas) {
    }

    data class BoundingBox(
        val left: Float,
        val top: Float,
        val right: Float,
        val bottom: Float,
        val label: String
    )
}
