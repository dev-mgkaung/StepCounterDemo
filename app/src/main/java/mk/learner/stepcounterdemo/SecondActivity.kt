package mk.learner.stepcounterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Button to start the service
        btn_start.setOnClickListener{
            StepSensorService.startService(this)
        }


        // Button to stop the service
        btn_stop.setOnClickListener{
            StepSensorService.stopService(this)
        }


    }

}