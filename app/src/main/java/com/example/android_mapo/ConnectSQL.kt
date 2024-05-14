package com.example.android_mapo
//libraries
import android.os.StrictMode
import android.util.Log
import java.lang.Exception
import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

class ConnectSQL{
    //requisites for
    private val ip = "192.168.100.7:49682"
    private val db = "FoxGuard"
    private val username = "Android_ADMIN"
    private val password = "1234"

    //connection string
    fun dbConn():Connection?{
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        val connString : String
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance()
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$username;password=$password"
            conn = DriverManager.getConnection(connString)
        }catch (ex:SQLException){
            Log.e("Error", ex.message!!)
        }catch(ex1:ClassNotFoundException){
            Log.e("Error",ex1.message!!)
        }catch (ex2: Exception){
            Log.e("Error",ex2.message!!)
        }
    return conn
    }
}