package com.example.fullkotlin

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class ReadAndWriteFile : AppCompatActivity() {

    private val WRITE_EXTERNAL_STORAGE_CODE = 1
    private val PERMISSION_REQUEST_STORAGE = 1000
    private val PICK_TEXT = 101
    var fileuri: Uri? = null
    var TextPath: TextView? = null
    var point_list = ArrayList<ArrayList<String>>()
    var textsb = StringBuilder()
    var textAsb = StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_and_write_file)

        val browse = findViewById<Button>(R.id.buttonload)
        val save = findViewById<Button>(R.id.buttonsave)
        TextPath = findViewById(R.id.textView)

        requestpermission()

        browse.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            startActivityForResult(Intent.createChooser(intent, "Select CSV file"), PICK_TEXT)
        })

        save.setOnClickListener(View.OnClickListener {
            Savetotext(readText(getFilePath(fileuri!!)))
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_TEXT && data != null) {
 // this is the part for multiple files
            if (null != data.clipData) {
                var text: String? = ""
                for (i in 0 until data.clipData!!.itemCount) {
                    fileuri = data.clipData!!.getItemAt(i).uri
//                    text +=fileuri.getPath() +"\n";
                    text += fileuri!!.getPath()
                    textsb.append(readText(getFilePath(fileuri!!)))
                }
                TextPath!!.text = text
            } else {
 // this is the part for single files
                fileuri = data.data
                TextPath!!.text = readText(getFilePath(fileuri!!))
                //or
//                TextPath!!.text = textsb.append(readText(getFilePath(fileuri!!)))
                val path = getFilePath(fileuri!!)
                val spilitdata = path.split("\\.").toTypedArray()
                if (spilitdata.size > 1) {
                    if (spilitdata[1].contains("txt")) {
                        readText(getFilePath(fileuri!!))
                    } else if (spilitdata[1].contains("csv")) {
                        readCSVFile(getFilePath(fileuri!!))
                    }
                }
            }
        }
    }

/// this method is used for getting file path from uri
    fun getFilePath(uri: Uri): String {
        val filename1: Array<String>
        val fn: String
        val filepath = uri.path
        val filePath1 = filepath!!.split(":").toTypedArray()
        filename1 = filepath.split("/").toTypedArray()
        fn = filename1[filename1.size - 1]
        return Environment.getExternalStorageDirectory().path + "/" + filePath1[1]
    }
/// reading file data
    fun readCSVFile(path: String?): String? {
        val filepath: String? = null
        val file = File(path)
        try {
            val scanner = Scanner(file)
            var temp_rows = scanner.nextLine()
            var splited_temp_rows = temp_rows.split(",").toTypedArray()
            val index_name = Arrays.asList(*splited_temp_rows).indexOf("Name")
            val index_class = Arrays.asList(*splited_temp_rows).indexOf("Class")
            val index_rollno = Arrays.asList(*splited_temp_rows).indexOf("Rollno")
            val index_date = Arrays.asList(*splited_temp_rows).indexOf("Date")
            while (scanner.hasNextLine()) {
                temp_rows = scanner.nextLine()
                splited_temp_rows = temp_rows.split(",").toTypedArray()
                val temp_data = java.util.ArrayList<String>()
                temp_data.add(splited_temp_rows[index_name])
                temp_data.add(splited_temp_rows[index_class])
                temp_data.add(splited_temp_rows[index_rollno])
                temp_data.add(splited_temp_rows[index_date])
                point_list.add(temp_data)

            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
        return filepath
    }
/// reading the Text file
    fun readText(input: String?): String? {
        val file = File(input)
        val text = java.lang.StringBuilder()
        try {
            val br = BufferedReader(FileReader(file))
            var line: String?
            while (br.readLine().also { line = it } != null) {
                text.append(line)
                text.append("\n")
            }
            br.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return text.toString()
    }
/// writing the Text file
    fun Savetotext(s: String?) {
        val timeStamp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(
            System.currentTimeMillis()
        )
        try {
 // this is for read from assets files
//            var tempA: String? = ""
//            try {
//                val inputStream = assets.open("a.txt")
//                val size = inputStream.available()
//                val buffer = ByteArray(size)
//                inputStream.read(buffer)
//                tempA = String(buffer)
//            } catch (e: Exception) {
//                Log.d(TAG, "onActivityResult: ")
//            }
//            textAsb.delete(0, textAsb.length)
//            textAsb.append(tempA)
//            textAsb.append("\n")

            val path = Environment.getExternalStorageDirectory()
//            val path = File("/storage/emulated/0/Android/data/com.example.demo/files/")
            val dir = File(path, "Rahul")
            if (!dir.exists()) {
                dir.mkdir()
            }
//            val filename = "MyFile_$timeStamp.dxf"
            val filename = "MyFile_$timeStamp.txt"
            val file = File(dir, filename)
            Log.d(TAG, "onActivityResult  MyFile_: " + file.absolutePath)
            val writer = FileWriter(file.absolutePath)
            val fw = BufferedWriter(writer)
            fw.write(s)
           fw.append(textsb.toString())

            fw.close()
            //display file saved message
            Toast.makeText(
                baseContext, filename + "Saved \n" + path,
                Toast.LENGTH_SHORT
            ).show()
            Log.i("Save", "File saved successfully!$path")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("TAG", "Error")
        }
    }
/// Runtime RequestPermission
    fun requestpermission() {
        //request permission for Read
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_STORAGE
            )
        }
        //request permission for Write
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_STORAGE
            )
        }
    }

}