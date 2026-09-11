package com.astrawidgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                          int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {

            RemoteViews views =
                    new RemoteViews(context.getPackageName(),
                            R.layout.weather_widget);

            String time = new SimpleDateFormat(
                    "hh:mm a", Locale.getDefault()).format(new Date());

            String date = new SimpleDateFormat(
                    "EEE, dd MMM", Locale.getDefault()).format(new Date());

            views.setTextViewText(R.id.temperature, "27°");
            views.setTextViewText(R.id.location, "Your location");
            views.setTextViewText(R.id.time, time);
            views.setTextViewText(R.id.date, date);
            views.setTextViewText(R.id.condition, "Sunny");

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
