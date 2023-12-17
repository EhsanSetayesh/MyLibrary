package com.parstasmim.mylibrary.extensions

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.navOptions
import com.parstasmim.mylibrary.R

fun NavController.safeNavigate(direction: NavDirections , bundle: Bundle? = null) {
    Handler(Looper.getMainLooper()).postDelayed({
        currentDestination?.getAction(direction.actionId)?.run {
            if(bundle != null) {
                navigate(
                    direction.actionId,
                    bundle,
                    navOptions { // Use the Kotlin DSL for building NavOptions
                        anim {
                            enter = R.anim.slide_in_left
                            exit = R.anim.slide_out_right
                            popEnter = R.anim.fade_in
                            popExit = R.anim.slide_out_left
                        }
                    }
                )
            }else {
                navigate(
                    direction,
                    navOptions { // Use the Kotlin DSL for building NavOptions
                        anim {
                            enter = R.anim.slide_in_left
                            exit = R.anim.slide_out_right
                            popEnter = R.anim.fade_in
                            popExit = R.anim.slide_out_left
                        }
                    }
                )
            }

        }
    },200)
}

fun NavController.safeNavigate(
    @IdRes currentDestinationId: Int,
    @IdRes id: Int,
    args: Bundle? = null
) {
    if (currentDestinationId == currentDestination?.id && currentDestination?.id != id) {
        navigate(
            id,
            args,
            navOptions { // Use the Kotlin DSL for building NavOptions
                anim {
                    enter = R.anim.slide_in_left
                    exit = R.anim.slide_out_right
                    popEnter = R.anim.fade_in
                    popExit = R.anim.slide_out_left
                }
        })
    }
}


fun NavController.safeNavigate(
    @IdRes destinationNavId: Int,
    args: Bundle? = null
) {
    if (currentDestination?.parent?.id != destinationNavId) {
        navigate(
            destinationNavId,
            args,
            navOptions { // Use the Kotlin DSL for building NavOptions
                anim {
                    enter = R.anim.slide_in_left
                    exit = R.anim.slide_out_right
                    popEnter = R.anim.fade_in
                    popExit = R.anim.slide_out_left
                }
                popUpTo(destinationNavId) {
                    inclusive = true
                }
            })
    }
}