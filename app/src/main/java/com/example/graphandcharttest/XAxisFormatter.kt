package com.example.graphandcharttest

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter

class XAxisFormatter : ValueFormatter() {

    // Right now an x value of 0 will return "Mo", 1 will return "Tu", etc.
    private val days = arrayOf("Mo", "Tu", "Wed", "Th", "Fr", "Sa", "Su")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return days.getOrNull(value.toInt()) ?: value.toString()
    }

    // override this for BarChart
    override fun getBarLabel(barEntry: BarEntry?): String {
        return days.getOrNull(barEntry?.x!!.toInt())!!
    }

}