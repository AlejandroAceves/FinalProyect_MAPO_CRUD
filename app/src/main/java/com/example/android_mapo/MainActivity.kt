package com.example.android_mapo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement
import java.sql.SQLException

//Variables for Inputs
lateinit var boxId: EditText
lateinit var boxName:EditText
lateinit var boxType: EditText
lateinit var boxDate:EditText
lateinit var boxLocation: EditText
lateinit var boxDescription:EditText

//Variables for buttons
lateinit var Addbtn: Button
lateinit var Deletebtn: Button
lateinit var Updatebtn: Button
lateinit var Searchbtn:Button


class MainActivity : AppCompatActivity() {
    private var connectSQL = ConnectSQL()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Variables for user input  (EventId, eventNames, eventType, eventDate, EventLocation, eventDescription)
        boxId = findViewById(R.id.editTextID)
        boxName = findViewById(R.id.editTextName)
        boxType = findViewById(R.id.editTextType)
        boxDate = findViewById(R.id.editTextDate)
        boxLocation = findViewById(R.id.editTextLocation)
        boxDescription = findViewById(R.id.editTextDesc)


        //Variables for Buttons (Add, Delete, Update, and Search)
        Addbtn = findViewById(R.id.btnAdd)
        Deletebtn = findViewById(R.id.btnDelete)
        Updatebtn = findViewById(R.id.btnUpdate)
        Searchbtn = findViewById(R.id.btnSearch)

        //Add a New Event to the Data Base
        Addbtn.setOnClickListener{
            val connection = connectSQL.dbConn()
            if(connection!=null) {
                try {
                    //SQL validation
                    val AddEvent: PreparedStatement = connectSQL.dbConn()?.prepareStatement("Insert into EVENTSINFO values (?,?) ")!!

                    //Content to be added
                    AddEvent.setString(2, boxName.text.toString())
                    AddEvent.setString(3, boxType.text.toString())
                    AddEvent.setString(4, boxDate.text.toString())
                    AddEvent.setString(5, boxLocation.text.toString())
                    AddEvent.setString(6, boxDescription.text.toString())
                    AddEvent.executeUpdate()

                    Toast.makeText(this, "Event Has been added successfully", Toast.LENGTH_SHORT)
                        .show()
                } catch (ex: SQLException) {
                    Toast.makeText(this, "Insertion Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        Deletebtn.setOnClickListener{
            val connection = connectSQL.dbConn()
            if (connection!=null) {
                try {
                    val deleteEvent: PreparedStatement = connectSQL.dbConn()?.prepareStatement("delete ")!!!
                } catch (ex:SQLException){
                    Toast.makeText(this ,"Values could not be deleted",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}