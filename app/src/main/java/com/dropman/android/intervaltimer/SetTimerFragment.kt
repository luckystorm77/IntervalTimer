package com.dropman.android.intervaltimer

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.fragment.app.DialogFragment
import java.util.*

class SetTimerFragment : DialogFragment() {

    fun onCreateDialog(context: Context) {
        val layout = LinearLayout(context)
        val minute = NumberPicker(context)
        val second = NumberPicker(context)

        minute.maxValue = 99
        minute.minValue = 0
        second.maxValue = 59
        second.minValue = 0

        val splitter = TextView(context)
        splitter.text = ":"

        layout.addView(minute)
        layout.addView(splitter)
        layout.addView(second)
        layout.gravity = Gravity.CENTER

        AlertDialog.Builder(context).apply {
            setTitle("Set Timer")
            setView(layout)
            setPositiveButton("OK") { _, _ ->
                //値自体は取れて　Intentを使う
                //view?.findViewById<Button>(R.id.timerStart)?.text ?: "${minute.value}:${second.value}"
                if (minute.value >= 0 && second.value >= 0) {
                    newSetTimerFragment("$minute:$second")
                }
            }
            setNegativeButton("CANCEL", null)
            show()
        }
    }

    private fun newSetTimerFragment(value: String) {
        val fragment = targetFragment ?: return

        val args = Intent()
        args.putExtra(Intent.EXTRA_TEXT, value)
        fragment.onActivityResult(targetRequestCode, Activity.RESULT_OK, args)
    }
}


