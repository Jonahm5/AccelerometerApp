package com.example.accelerometer

import android.hardware.Sensor
import android.hardware.SensorManager
import android.widget.SeekBar
import android.widget.TextView
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var Signif: Float = 10.0F

    fun sigAxis(x: Float, y: Float, z: Float) : String {
        var axis = "X"
            if (x > Signif) {
                axis = "X"
            } else if (y > Signif){
                axis = "Y"
            }else if (z > Signif){
                axis = "Z"
            }
        return axis

    }

}