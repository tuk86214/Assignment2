package edu.temple.baseassignment

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var displayMessageTextView: TextView
    lateinit var nameEditText: EditText
    lateinit var editTextEmailAddress: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextPassword2: EditText
    lateinit var myButton: Button
    lateinit var spinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayMessageTextView = findViewById(R.id.displayMessageTextView)
        nameEditText = findViewById(R.id.nameEditText)
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)
        editTextPassword2 = findViewById(R.id.editTextTextPassword2)
        myButton = findViewById(R.id.saveInfo)
        spinner = findViewById(R.id.programField)

        val program = arrayOf("Please select your program", "Information Science", "Computer Science", "Math and CS", "Data Science", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, program)

        spinner.adapter = adapter

        myButton.setOnClickListener {
            validateInput()
        }
    }

    private fun validateInput(){  // validate the user input
        var isValid = true

        nameEditText.setError(null)
        editTextEmailAddress.setError(null)
        editTextPassword.setError(null)
        editTextPassword2.setError(null)

        if (nameEditText.text.toString().isEmpty()) {
            nameEditText.setError("Name not entered")
            isValid = false
        }

        if (editTextEmailAddress.text.toString().isEmpty()) {
            editTextEmailAddress.setError("Email not entered")
            isValid = false
        }

        if (editTextPassword.text.toString().isEmpty()) {
            editTextPassword.setError("Password not entered")
            isValid = false
        }


        if (editTextPassword.text.toString() != editTextPassword2.text.toString()) {
            editTextPassword.setError("Passwords do not match")
            editTextPassword2.setError("Passwords do not match")
            isValid = false
        }

        if (spinner.selectedItem.toString() == "Please select your program") {
            Toast.makeText(this, "Please select a valid program", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        if (isValid) {
            displayMessageTextView.text = "Welcome To The App, ${nameEditText.text}."
        }

    }
}
