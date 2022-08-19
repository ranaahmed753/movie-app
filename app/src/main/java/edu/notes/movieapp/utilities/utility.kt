package edu.notes.movieapp.utilities

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.AnimationUtils
import edu.notes.movieapp.R

object AnimationController{
    fun fadeInAnimation(widget : View,context : Context){
        widget.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))
    }
    fun fadeOutAnimation(widget : View,context : Context){
        widget.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_out))
    }
}


object Navigation{
    fun navigate(currentContext : Context,targetContext : Context){
        val intent = Intent(currentContext,targetContext::class.java)
        currentContext.startActivity(intent)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    }
}