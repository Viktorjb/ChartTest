package com.example.graphandcharttest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the xml chart
        val chart = findViewById<View>(R.id.chart) as LineChart
        //This is a LineChart. There are also BarChart, ScatterChart, CandleStickChart, PieChart,
        // BubbleChart and RadarChart

        //Make a list of "entries"
        val entries : MutableList<Entry> = ArrayList() // imported mikephil Entry

        //Add "entries" to the list
        entries.add(Entry(1.0f,2.7f))
        entries.add(Entry(2.0f,2.6f))
        entries.add(Entry(3.0f,3.4f))
        entries.add(Entry(4.0f,3.0f))
        entries.add(Entry(5.0f,4.3f))

        //Make a dataset using the entries list (you can also label it)
        val dataSet = LineDataSet(entries, "A Great LineChart") // add entries to dataset

        //dataSet.setColor(122,70) // This can be used to change colour and alpha

        //Just changing some style settings
        chart.setDrawGridBackground(false) //Many styling functions exist for the View as well
        chart.setDrawBorders(true)
        chart.setBorderWidth(1f)

        //Make a lineData object with the dataset
        val lineData = LineData(dataSet)

        //Feed that lineData to the chart view
        chart.data = lineData

        chart.invalidate() // This refreshes the chart view, updating the data


    }
}

/*

Two lines need to be added in the gradle files to import the MPAndroidChart library,
where to add them apparently depends on your version of Android Studio and Gradle, but
it appears to have worked to add:

implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
to build.gradle (:app) under dependencies

and

maven{url "https://jitpack.io"}
to settings.gradle under dependencyResolutionManagement -> repositories
*/

/* How to make a simple line chart
1. Create a an xml clause in the xml file for the chart, a line chart would be:

<com.github.mikephil.charting.charts.LineChart
android:id="@+id/chart"
android:layout_width="match_parent"
android:layout_height="match_parent" />

2. Access the chart view in the code, i.e: val chart = findViewById<View>(R.id.chart) as LineChart

3. Make a list of "Entry", you'll need to import Entry into the project as you do.
               (The com.github.mikephil one, not any android or google versions of Entry)

4. Create or convert data into Entry objects to add to the list, i.e:
        entries.add(Entry( /* X Value */ , /* Y Value */ ))

5. Create a dataset, in this case a LineDataSet, using the entries list:
        val dataSet = LineDataSet(entries, "A Label for the Chart")

6. Add, in this case, the dataset to a LineData object, then assign that to the view:
        val lineData = LineData(dataSet)
        chart.data = lineData

7. To refresh the chart and get the right data displayed, you may also need to use:
        chart.invalidate()


https://weeklycoding.com/mpandroidchart-documentation/
 */








