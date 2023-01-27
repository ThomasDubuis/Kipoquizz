package com.ynov.kipoquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findMostBeautiful = findViewById<Spinner>(R.id.findMostBeautiful)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.people,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            findMostBeautiful.adapter = adapter
        }

        val findScoreProject = findViewById<SeekBar>(R.id.findScoreProject)
        findScoreProject?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seek: SeekBar) {}

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                Toast.makeText(this@MainActivity,
                    "Note: " + seek.progress + "/20", Toast.LENGTH_SHORT).show()
            }
        })

        val submitBtn = findViewById<Button>(R.id.sendQuizzBtn)
        val findAgePeople = findViewById<TextInputEditText>(R.id.findAgePeople)
        val findStartDateDevMobile = findViewById<DatePicker>(R.id.findStartDateDevMobile)
        val findFavoriteSentence = findViewById<TextInputEditText>(R.id.findFavoriteSentence)

        submitBtn.setOnClickListener {
            println("Quel age : " + findAgePeople.text.toString())
            println("Start dev mobile : " + findStartDateDevMobile.dayOfMonth
                    + "/" + findStartDateDevMobile.month + 1
                    + "/" + findStartDateDevMobile.year)
            println("Le plus beau : " + findMostBeautiful.selectedItem.toString())
            println("Phrase préférée : " + findFavoriteSentence.text.toString())
            println("Score project : " + findScoreProject.progress)
        }
    }
}