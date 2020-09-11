package mk.learner.stepcounterdemo

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews


class PedoMeterWidget : AppWidgetProvider() {

    private var service: PendingIntent? = null
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = loadTitlePref(context, appWidgetId)
    context.toast("widget Text= $widgetText")
    val pendingIntent = PendingIntent.getActivity(context, appWidgetId, Intent(context, MainActivity::class.java), 0)
    val views = RemoteViews(context.packageName, R.layout.pedo_meter_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)
    views.setOnClickPendingIntent(R.id.pedowidget, pendingIntent)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}