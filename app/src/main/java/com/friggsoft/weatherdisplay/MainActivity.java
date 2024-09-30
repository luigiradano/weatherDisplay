package com.friggsoft.weatherdisplay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.github.AAChartModel.AAChartCore.AAChartCreator.AAChartModel;
import com.github.AAChartModel.AAChartCore.AAChartCreator.AAChartView;
import com.github.AAChartModel.AAChartCore.AAChartCreator.AASeriesElement;
import com.github.AAChartModel.AAChartCore.AAChartEnum.AAChartType;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        AAChartView aaChartView = findViewById(R.id.AAChartView);

        AAChartModel aaChartModel = new AAChartModel()
                .chartType(AAChartType.Column)
                //.subtitle("Virtual Data")
                .backgroundColor("#" + Integer.toString(getColor(R.color.black)))
                .dataLabelsEnabled(true)
                .series(new AASeriesElement[]{
                        new AASeriesElement()
                                .data(new Object[]{7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6})
                                .showInLegend(false)
                                .allowPointSelect(false)
                                .enableMouseTracking(false)
                                .name("Pressure (hPa)"),
                });

        aaChartView.aa_drawChartWithChartModel(aaChartModel);

    }
}