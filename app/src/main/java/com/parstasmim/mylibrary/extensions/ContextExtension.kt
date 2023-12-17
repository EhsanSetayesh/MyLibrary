package com.parstasmim.mylibrary.extensions

import android.app.Activity
import android.app.ActivityManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.PowerManager
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.*
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.parstasmim.mylibrary.R
import com.parstasmim.mylibrary.utils.Constants.Companion.DIALOG_WIDTH
import com.parstasmim.mylibrary.utils.state.MessageResponse
import com.parstasmim.mylibrary.utils.state.MessageType
import com.parstasmim.mylibrary.utils.state.Queue
import com.parstasmim.mylibrary.utils.state.StateMessage
import com.parstasmim.mylibrary.utils.state.StateMessageCallback
import com.parstasmim.mylibrary.utils.state.UIComponentType
import kotlin.math.max


private val TAG: String = "AppDebug"

fun Context.isInternetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}

fun Context.getCompatColor(@ColorRes colorId: Int) =
    ResourcesCompat.getColor(resources, colorId, null)

fun Context.getCompatDrawable(@DrawableRes drawableId: Int) =
    AppCompatResources.getDrawable(this, drawableId)!!

fun Context.copyToClipboard(content: String) {
    val clipboardManager = ContextCompat.getSystemService(this, ClipboardManager::class.java)!!
    val clip = ClipData.newPlainText("clipboard", content)
    clipboardManager.setPrimaryClip(clip)
}

fun Context.isActivityFinishing(): Boolean {
    return this is Activity && isFinishing
}

fun Context.isActivityDestroyed(): Boolean {
    return this is Activity && isDestroyed
}

fun Context.browse(url: String, newTask: Boolean = false) {
    try {
        val intent = Intent(ACTION_VIEW, Uri.parse(url)).apply {
            if (newTask) addFlags(FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.makeCall(number: String): Boolean {
    try {
        val intent = Intent(ACTION_CALL, Uri.parse("tel:$number"))
        startActivity(intent)
        return true
    } catch (e: Exception) {
        return false
    }
}

val Context.versionName: String?
    get() = try {
        val pInfo = packageManager.getPackageInfo(packageName, 0);
        pInfo?.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }

val Context.versionCode: Long?
    get() = try {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            pInfo?.longVersionCode
        } else {
            @Suppress("DEPRECATION")
            pInfo?.versionCode?.toLong()
        }
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }


fun Context.dpToPx(): Int {
    val minWidth = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        DIALOG_WIDTH.toFloat(),
        resources.displayMetrics
    ).toInt()

    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val metrics = DisplayMetrics()
    display.getMetrics(metrics)
    val screenWidth = (metrics.widthPixels * 0.9).toInt()
    return max(screenWidth, minWidth)
}

fun Context.isAppInForeground(): Boolean {
    return if (this == null) false else try {
        val appProcesses: List<ActivityManager.RunningAppProcessInfo> =
            (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
                ?: return false
        for (appProcess in appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                && appProcess.processName == this.packageName
            ) {
                return true
            }
        }
        false
    } catch (e: Exception) {
        false
    }
}

fun Context?.isScreenOn(): Boolean {
    if(this != null) {
        return (getSystemService(Context.POWER_SERVICE) as PowerManager).isInteractive
    }else {
        return false
    }
}

fun Context.isConnectToInternet(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    val networks = connectivityManager?.allNetworks
    networks?.let {
        var networkInfo: NetworkInfo
        for (mNetwork in networks) {
            networkInfo = connectivityManager.getNetworkInfo(mNetwork)!!
            if (networkInfo.state == NetworkInfo.State.CONNECTED)
                return true
        }
    }
    return false
}

fun processMessageQueue(
    context: Activity?,
    queue: Queue<StateMessage>,
    stateMessageCallback: StateMessageCallback
) {
    context?.let { ctx ->
        if (!queue.isEmpty()) {
            queue.peek()?.let { stateMessage ->
                ctx.onResponseReceived(
                    response = stateMessage.response,
                    stateMessageCallback = stateMessageCallback
                )
            }
        }
    }
}

private fun Activity.onResponseReceived(
    response: MessageResponse,
    stateMessageCallback: StateMessageCallback
) {
    when (response.uiComponentType) {
        is UIComponentType.Toast -> {

            when (response.messageType) {
                is MessageType.Success -> {
                    response.message?.let {
                        displayToast(
                            message = it,
                            backgroundColorId = R.color.green_500,
                            stateMessageCallback = stateMessageCallback
                        )
                    }
                }
                is MessageType.Error -> {
                    response.message?.let {
                        displayToast(
                            message = it,
                            backgroundColorId = R.color.red_300,
                            stateMessageCallback = stateMessageCallback
                        )
                    }

                }
                is MessageType.None -> {}
                else -> {}
            }


        }

        is UIComponentType.None -> {
            // This would be a good place to send to your Error Reporting
            // software of choice (ex: Firebase crash reporting)
            Log.i(TAG, "onResponseReceived: ${response.message}")
            stateMessageCallback.removeMessageFromStack()
        }

        else -> {}
    }
}

fun Context.displayToast(
    message: String,
    backgroundColorId: Int = R.color.green_500,
    stateMessageCallback: StateMessageCallback? = null
) {
//    MyToast().make(
//        this,
//        message,
//        Toast.LENGTH_SHORT,
//        backgroundColorId,     // Toast BackgroundColor
//        R.color.white_100,      // Toast TextColor
//        null   // Drawable Int
//    ).show()
//    stateMessageCallback?.removeMessageFromStack()
}


