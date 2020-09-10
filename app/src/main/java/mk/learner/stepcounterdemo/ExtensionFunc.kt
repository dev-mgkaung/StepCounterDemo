package mk.learner.stepcounterdemo

import android.content.Context
import android.widget.Toast

// Extension function to show toast message
fun Context.toast(message:String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
}