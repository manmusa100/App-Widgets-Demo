package com.demo.appwidgetsdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context ctx, AppWidgetManager widgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            CharSequence text = ctx.getString(R.string.widget_text);
            // Construct the RemoteViews object
            RemoteViews views = new RemoteViews(ctx.getPackageName(), R.layout.new_app_widget);
            views.setTextViewText(R.id.widget_text, text);
            // Launch MainActivity Intent
            Intent i = new Intent(ctx, MainActivity.class);
            PendingIntent penintent = PendingIntent.getActivity(ctx, 0, i, 0);
            // Attach an on-click listener to the button
            views.setOnClickPendingIntent(R.id.button1, penintent);

            // Update the widget from the widget manager
            widgetManager.updateAppWidget(appWidgetId, views);
        }
    }
    @Override
    public void onEnabled(Context ctx) {
        // Enter relevant functionality for when the first widget is created
        Log.i("tag1","App Widget Enabled");
    }
    @Override
    public void onDisabled(Context ctx) {
        // Enter relevant functionality for when the last widget is disabled
        Log.i("tag1","App Widget Disabled");
    }
    @Override
    public void onAppWidgetOptionsChanged(Context ctx, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(ctx, appWidgetManager, appWidgetId, newOptions);
        Log.i("tag1","Widget Resized");
    }
}