package com.dropman.android.intervaltimer

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val setTimerFragment = SetTimerFragment()
    var minute = 0
    var second = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.intervalList)
        val adapter = IntarvalAdapter(this, ArrayList<String>())

        recyclerView.adapter = adapter
    }

    fun onClickDelete(view: View) {
        //TODO:add Delete Action
    }

    fun onClickAddInterval(view: View) {
        //TODO:add Add Interval Action
    }

    fun onClickTimerStart(view: View) {

    }

    fun onClickSetTimer(view: View) {
        setTimerFragment.onCreateDialog(this)
    }

    fun setTimer(minute: Int, second: Int) {
        this.minute = minute
        this.second = second
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //if (resultCode != Activity.RESULT_OK) return

        val buttonLabel = findViewById<Button>(R.id.timerStart)
        buttonLabel.text = data.toString()
        super.onActivityResult(requestCode, resultCode, data)
    }
}
