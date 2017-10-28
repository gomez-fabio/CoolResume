package es.fabiogomez.coolresume

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.workHistory)

        workHistory.setOnClickListener {
            println("Button pressed")

            var moveToWorkHistory = Intent(getApplicationContext(),WorkHistoryActivity::class.java)
            startActivity(moveToWorkHistory)
        }


        var callBtn = findViewById<Button>(R.id.callBtn)

        callBtn.setOnClickListener {
            println("Call Button pressed!")

            var phoneUri = Uri.parse("tel:555 555 555")
            var callIntent = Intent(Intent.ACTION_DIAL,phoneUri)
            startActivity(callIntent)
        }


        var emailBtn = findViewById<Button>(R.id.emailBtn)

        emailBtn.setOnClickListener {
            println("Email Button pressed!")

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "fabio@fakedomain.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Nice resume")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I really enjoy your resume...")
            startActivity(emailIntent)
        }
    }
}
