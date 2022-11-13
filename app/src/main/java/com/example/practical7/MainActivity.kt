package com.example.practical7

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonPressed(view:View){
        if (view.id == R.id.save_button){
            val data = findViewById<EditText>(R.id.personName).text.toString() //Get data from the edittext element

            //access the shared preferences file "my_data_file" (or whatever you want to call it).
            // MODE_PRIVATE says we don't want to share this with other apps.
            val datafile = getSharedPreferences("my_data_file", MODE_PRIVATE)
            val editor = datafile.edit()

            //put the contents of the edittext in a record called "name".
            editor.putString("name",data)
            editor.apply()
            Snackbar.make(findViewById(R.id.save_button),"Name saved!",Snackbar.LENGTH_SHORT).show()
        }

        if (view.id == R.id.load_button){
            //retrieve data from the data file. Note we have to load the same file
            val datafile = getSharedPreferences("my_data_file", MODE_PRIVATE)

            //get the actual string. If the string does not exist, instead it will return the second string here
            val name = datafile.getString("name","")

            //change the contents of the textview
            findViewById<TextView>(R.id.greeting_text).text = "Hello " + name + "!"
        }
    }
}