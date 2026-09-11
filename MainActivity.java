package com.astrawidgets;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 60, 28, 28);
        root.setGravity(Gravity.CENTER_HORIZONTAL);
        root.setBackgroundColor(Color.rgb(248, 248, 250));

        TextView title = new TextView(this);
        title.setText("AstraWidgets V0.1");
        title.setTextSize(30);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView info = new TextView(this);
        info.setText("\nAdd the “Astra Weather” widget from your home-screen widget picker.\n\n"
                + "V0.1 includes:\n"
                + "• Resizable native Android widget\n"
                + "• Celsius temperature\n"
                + "• Location\n"
                + "• Time and date\n"
                + "• Sunny / cloudy / rain / mist / night presentation\n"
                + "• iOS-inspired rounded card\n\n"
                + "Weather data is currently demo data; the architecture is ready for a real weather API.");
        info.setTextSize(17);
        info.setTextColor(Color.DKGRAY);
        info.setPadding(0, 35, 0, 0);
        root.addView(info);

        setContentView(root);
    }
}
