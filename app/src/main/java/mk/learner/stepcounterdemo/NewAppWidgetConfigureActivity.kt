//package mk.learner.stepcounterdemo
//
//import android.app.Activity
//import android.appwidget.AppWidgetManager
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.EditText
//
///**
// * The configuration screen for the [NewAppWidget] AppWidget.
// */
//class NewAppWidgetConfigureActivity : Activity() {
//    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
//    private lateinit var appWidgetText: EditText
//    private var onClickListener = View.OnClickListener {
//        val context = this@NewAppWidgetConfigureActivity
//
//        // When the button is clicked, store the string locally
//        val widgetText = appWidgetText.text.toString()
//        saveTitlePref(context, appWidgetId, widgetText)
//
//        // It is the responsibility of the configuration activity to update the app widget
//        val appWidgetManager = AppWidgetManager.getInstance(context)
//        updateAppWidget(context, appWidgetManager, appWidgetId)
//
//        // Make sure we pass back the original appWidgetId
//        val resultValue = Intent()
//        resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
//        setResult(RESULT_OK, resultValue)
//        finish()
//    }
//
//    public override fun onCreate(icicle: Bundle?) {
//        super.onCreate(icicle)
//
//        // Set the result to CANCELED.  This will cause the widget host to cancel
//        // out of the widget placement if the user presses the back button.
//        setResult(RESULT_CANCELED)
//
//        setContentView(R.layout.new_app_widget_configure)
//        appWidgetText = findViewById<View>(R.id.appwidget_text) as EditText
//        findViewById<View>(R.id.add_button).setOnClickListener(onClickListener)
//
//        // Find the widget id from the intent.
//        val intent = intent
//        val extras = intent.extras
//        if (extras != null) {
//            appWidgetId = extras.getInt(
//                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID
//            )
//        }
//
//        // If this activity was started with an intent without an app widget ID, finish with an error.
//        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
//            finish()
//            return
//        }
//
//        appWidgetText.setText(loadTitlePref(this@NewAppWidgetConfigureActivity, appWidgetId))
//    }
//
//}
//
