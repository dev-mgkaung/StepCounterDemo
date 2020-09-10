package mk.learner.stepcounterdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SensorEventListener {

    private var running = false
    private lateinit  var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init sensor Manager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        btn_next.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(event: SensorEvent) {
        if (running)  stepsValue.text= "Today Step ${event.values[0]}"
    }

    override fun onAccuracyChanged(event: Sensor?, p1: Int) {}

    override fun onResume() {
        super.onResume()
        running = true
        val stepsSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepsSensor == null) {
            toast("No Step Counter Sensor !")
        } else {
            sensorManager.registerListener(this, stepsSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }



    override fun onPause() {
        super.onPause()
        running = false
        sensorManager.unregisterListener(this)
    }
}