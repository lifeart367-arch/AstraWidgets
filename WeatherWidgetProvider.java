package com.astrawidgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
        for (int id : ids) updateWidget(context, manager, id);
    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager manager,
                                          int appWidgetId, Bundle newOptions) {
        updateWidget(context, manager, appWidgetId);
    }

    private void updateWidget(Context context, AppWidgetManager manager, int id) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_widget);

        Date now = new Date();
        int hour = Integer.parseInt(new SimpleDateFormat("H", Locale.getDefault()).format(now));
        boolean night = hour < 6 || hour >= 19;

        String time = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(now);
        String date = new SimpleDateFormat("EEE, d MMM", Locale.getDefault()).format(now);

        views.setTextViewText(R.id.widget_time, time);
        views.setTextViewText(R.id.widget_date, date);
        views.setTextViewText(R.id.widget_location, "Your location");
        views.setTextViewText(R.id.widget_temp, "27°");
        views.setTextViewText(R.id.widget_condition, night ? "Clear night" : "Sunny");

        views.setImageViewResource(R.id.widget_icon,
                night ? R.drawable.ic_moon : R.drawable.ic_sun);

        views.setInt(R.id.widget_card, "setBackgroundResource",
                night ? R.drawable.bg_night : R.drawable.bg_sunny);

        manager.updateAppWidget(id, views);
    }
}
