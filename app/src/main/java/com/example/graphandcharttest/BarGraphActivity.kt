package com.example.graphandcharttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.*

class BarGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_graph)

        val chart = findViewById<View>(R.id.chart) as BarChart


        //Make a list of "entries"
        val entries : MutableList<BarEntry> = ArrayList()

        //Add "entries" to the list
        entries.add(BarEntry(0.0f,178f))
        entries.add(BarEntry(1.0f,204f))
        entries.add(BarEntry(2.0f,200f))
        entries.add(BarEntry(3.0f,183f))
        entries.add(BarEntry(4.0f,194f))
        entries.add(BarEntry(5.0f,142f))

        //Make a dataset using the entries list
        val dataSet = BarDataSet(entries, "") // add entries to dataset

        val barData = BarData(dataSet)

        //This separate class-file is used to change the values on top of bars.
        barData.setValueFormatter(XAxisFormatter())



        chart.data = barData


        //Just changing some style settings
        chart.setDrawGridBackground(false) //Many styling functions exist for the View as well
        chart.setDrawBorders(true)
        chart.setBorderWidth(1f)

        chart.setAutoScaleMinMaxEnabled(true)

        //Remove small description in the corner
        chart.getDescription().setText("")
        //Remove X-axis grid lines and numbers (they're redundant)
        chart.getXAxis().setEnabled(false)


        chart.invalidate()

    }
}