import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager

fun View.handleButton(enable: Boolean) {
    this.isEnabled = enable
    this.isSelected = enable
}