package com.example.firstkotlinapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var incButton: MaterialButton
    private lateinit var incTextView: TextView
    private var value: Int = 0
    private lateinit var surnameTextView: TextView
    private lateinit var disciplineTextView: TextView
    private lateinit var markTextView: TextView
    private lateinit var studentsCountTextView: TextView
    private lateinit var disciplinesCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button and listener
        incButton = findViewById(R.id.inc_button)
        incTextView = findViewById(R.id.inc_text_view)
        incTextView.text = value.toString()

        incButton.setOnClickListener {
            value++
            incTextView.text = value.toString()
        }

        //data class
        surnameTextView = findViewById(R.id.surname_text_view)
        disciplineTextView = findViewById(R.id.discipline_text_view)
        markTextView = findViewById(R.id.mark_text_view)
        setValuesWithDataClass()

        //object
        studentsCountTextView = findViewById(R.id.students_count_text_view)
        disciplinesCountTextView = findViewById(R.id.discipline_count_text_view)
        setValuesWithObject()

        //for
        printDisciplines()
    }

    private fun setValuesWithDataClass() {
        val studentMarks = StudentMarks("Ivanov", "english", "B")
        surnameTextView.text = studentMarks.surname
        disciplineTextView.text = studentMarks.discipline
        markTextView.text = studentMarks.mark
    }

    private fun setValuesWithObject() {
        studentsCountTextView.text = Repo.studentsCount.toString()
        disciplinesCountTextView.text = Repo.disciplinesCount.toString()
    }

    private fun printDisciplines() {
        for(discipline in Repo.disciplinesList) {
            println(discipline)
        }
        for(i in 1..Repo.disciplinesCount) {
            println(Repo.disciplinesList[i-1])
        }
        Repo.disciplinesList.forEach {
            println(it)
        }
    }
}