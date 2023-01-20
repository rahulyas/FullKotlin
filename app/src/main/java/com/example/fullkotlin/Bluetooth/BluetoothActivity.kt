package com.example.fullkotlin.Bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fullkotlin.R


class BluetoothActivity : AppCompatActivity() {

    private var lstvw: ListView? = null
    private var aAdapter: ArrayAdapter<*>? = null
    private val bAdapter = BluetoothAdapter.getDefaultAdapter()

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        val bluetoothbutton = findViewById<Button>(R.id.btnGet)

        bluetoothbutton.setOnClickListener {
            if (bAdapter == null) {
                Toast.makeText(applicationContext, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show()
            } else {
                // Get paired devices.
                val pairedDevices = bAdapter.bondedDevices
                val list = ArrayList<Any>()
                if (pairedDevices.size > 0) {
                    // There are paired devices. Get the name and address of each paired device.
                    for (device in pairedDevices) {
                        val devicename = device.name
                        val macAddress = device.address // MAC address
                        list.add("Name: " + devicename + "MAC Address: " + macAddress)
                    }
                    lstvw = findViewById<ListView>(R.id.deviceList)
                    aAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, list)
                    lstvw!!.setAdapter(aAdapter)
                }
            }
        }


    }
}