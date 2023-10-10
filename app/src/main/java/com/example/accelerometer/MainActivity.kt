package com.example.accelerometer

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService
import org.xml.sax.XMLFilter
import kotlin.math.abs
import kotlin.math.sqrt


class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var Sbar: SeekBar
    private lateinit var SCounting: TextView
    private lateinit var sensorManager: SensorManager
    private lateinit var accelerometerSensor: Sensor
    private lateinit var Xfi: TextView
    private lateinit var Yfi: TextView
    private lateinit var Zfi: TextView
    private lateinit var axis: String


    private var Signif: Float = 10.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Sbar = findViewById<SeekBar>(R.id.SBar)
        SCounting = findViewById<TextView>(R.id.SCount)
        Xfi = findViewById<TextView>(R.id.Xfind)
        Yfi = findViewById<TextView>(R.id.Yfind)
        Zfi = findViewById<TextView>(R.id.Zfind)



        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

        updateCounting()

        Sbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean){
                Signif = progress.toFloat()
                updateCounting()
            }
            override fun onStartTrackingTouch(seek: SeekBar) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
    override fun onResume(){
        super.onResume()
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onPause(){
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION){
            val x = abs(event.values[0])
            val y = abs(event.values[1])
            val z = abs(event.values[2])

            val roundX = String.format("%.2f", x)
            val roundY = String.format("%.2f", y)
            val roundZ = String.format("%.2f", z)


            Xfi.text = roundX
            Yfi.text = roundY
            Zfi.text = roundZ
            val MaxTime = maxOf(x, y, z)
            if (x > Signif || y > Signif || z > Signif){
                if (x > Signif) {
                    axis = "X"
                    report(axis)
                 } else if (y > Signif){
                    axis = "Y"
                    report(axis)
                 }else if (z > Signif){
                     axis = "Z"
                     report(axis)
                 }
            }
        }
    }
    private fun report(axis: String){
        Log.d(this.toString(), "You moved significantly on the $axis-Axis")
        Toast.makeText(this, "You moved significantly on the $axis-Axis", Toast.LENGTH_SHORT).show()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
    private fun updateCounting(){
        SCounting.text = "$Signif"
    }
}