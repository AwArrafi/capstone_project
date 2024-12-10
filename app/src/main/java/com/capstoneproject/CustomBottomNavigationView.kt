package com.capstoneproject

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomBottomNavigationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BottomNavigationView(context, attrs) {

    private val customTypeface: Typeface? = ResourcesCompat.getFont(context, R.font.poppins_regular)

    init {
        setCustomFont()
    }

    private fun setCustomFont() {
        // Ambil ViewGroup dari BottomNavigationView untuk mengakses setiap item
        val menuView = getChildAt(0) as? ViewGroup
        menuView?.let {
            for (i in 0 until it.childCount) {
                val item = it.getChildAt(i) as? ViewGroup
                item?.let { applyFontToMenuItem(it) }
            }
        }
    }

    private fun applyFontToMenuItem(viewGroup: ViewGroup) {
        // Cari TextView dalam setiap item untuk mengubah font
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is TextView) {
                child.typeface = customTypeface
            } else if (child is ViewGroup) {
                applyFontToMenuItem(child) // Rekursif jika terdapat nested ViewGroup
            }
        }
    }
}
