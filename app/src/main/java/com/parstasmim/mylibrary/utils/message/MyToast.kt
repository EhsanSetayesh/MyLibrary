package com.parstasmim.mylibrary.utils.message


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

//class MyToast {
//    @SuppressLint("InflateParams")
//    fun make(
//        context: Context,
//        text: CharSequence?,
//        duration: Int,
//        backgroundColor: Int?,
//        textColor: Int?,
//        toastIconRes: Int?
//    ): Toast {
//        val toast = Toast(context)
//        val inflate = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val v = inflate.inflate(R.layout.customview_toast, null)
//        val toastText = v.findViewById(R.id.text) as TextView
//        val linear = v.findViewById(R.id.clToastContainer) as ConstraintLayout
//        val toastIcon = v.findViewById(R.id.toasticon) as ImageView
//
//        backgroundColor?.let {
//            linear.background.setTint(ContextCompat.getColor(context , it))
//            linear.setBackgroundTintColor(context,it)
//        } ?: run {
//            linear.background.setTint(ContextCompat.getColor(context, context.getBackgroundFromAttribute(R.attr.primaryColor)))
//            linear.setBackgroundTintColor(context,context.getBackgroundFromAttribute(R.attr.primaryColor))
//        }
//
//        textColor?.let {
//            toastText.setTextColor(ContextCompat.getColor(context , it))
//        } ?: toastText.setTextColor(Color.parseColor("#ffffff"))
//
//        toastIconRes?.let {
//            toastIcon.setBackgroundResource(it)
//        } ?: toastIcon.makeGone()
//
//        toastText.text = text
//        toast.duration = duration
//        toast.view = v
//
//        return toast
//    }
//
//    private fun toastBackground(color: String): LayerDrawable {
//        val outerRadii = floatArrayOf(75f, 75f, 75f, 75f, 75f, 75f, 75f, 75f)
//        val shapeDrawable = ShapeDrawable()
//        shapeDrawable.shape = RoundRectShape(outerRadii, null, null)
//        shapeDrawable.paint.color = Color.parseColor(color)
//        shapeDrawable.paint.style = Paint.Style.FILL
//        shapeDrawable.paint.isAntiAlias = true
//        val drawables = arrayOf<Drawable>(shapeDrawable)
//        return LayerDrawable(drawables)
//    }
//
//}