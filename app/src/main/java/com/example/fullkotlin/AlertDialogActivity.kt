package com.example.fullkotlin

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class AlertDialogActivity : AppCompatActivity() {


    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }
    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
            "Maybe", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val basicAlert = findViewById<Button>(R.id.btnBasicAlert)
        val withIconAndCustomise = findViewById<Button>(R.id.btnAlertWithIconsAndCustomize)
        val withitem = findViewById<Button>(R.id.btnAlertWithItems)
        val withMultiChoiceList = findViewById<Button>(R.id.btnAlertWithMultiChoiceList)
        val withStyle = findViewById<Button>(R.id.btnAlertWithStyle)
        val withCustomStyle = findViewById<Button>(R.id.btnAlertWithCustomStyle)
        val withButtonCentered = findViewById<Button>(R.id.btnAlertWithButtonCentered)
        val withEditText = findViewById<Button>(R.id.btnAlertWithEditText)
        val useingcustomlayout = findViewById<Button>(R.id.btnAlertcustom)


        basicAlert.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("Androidly Alert")
                setMessage("We have a message")
                setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                setNegativeButton(android.R.string.no, negativeButtonClick)
                setNeutralButton("Maybe", neutralButtonClick)
                show()
            }
        }

        withIconAndCustomise.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("Icon and Button Color")
                setMessage("We have a message")
                setPositiveButton("OK", null)
                setNegativeButton("CANCEL", null)
                setNeutralButton("NEUTRAL", null)
            //    setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_menu_call, theme))
                setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))
            }
            val alertDialog = builder.create()
            alertDialog.show()

            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            with(button) {
                setBackgroundColor(Color.BLACK)
                setPadding(0, 0, 20, 0)
                setTextColor(Color.WHITE)
            }
        }

        withitem.setOnClickListener {
            val items = arrayOf("A", "B" , "C", "D", "E")
            val builder = AlertDialog.Builder(this)
            with(builder){
                setTitle("List of Items")
                setItems(items) { dialog, which ->
                    when (which) {
                        0 -> {
                            Toast.makeText(applicationContext, items[which] + " ok clicked", Toast.LENGTH_SHORT).show()
                        }
                        1 -> {
                            Toast.makeText(applicationContext, items[which] + " ok clicked", Toast.LENGTH_SHORT).show()
                        }
                        2 -> {
                            Toast.makeText(applicationContext, items[which] + " ok clicked", Toast.LENGTH_SHORT).show()
                        }
                        3 -> {
                            Toast.makeText(applicationContext, items[which] + " ok clicked", Toast.LENGTH_SHORT).show()
                        }
                    }
//                    Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT).show()
                }

                setPositiveButton("OK", positiveButtonClick)
                show()
            }
        }

        withMultiChoiceList.setOnClickListener {
            val items = arrayOf("Microsoft", "Apple", "Amazon", "Google")
            val selectedList = ArrayList<Int>()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("This is list choice dialog box")
            builder.setMultiChoiceItems(items, null){
                    dialog, which, isChecked ->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(Integer.valueOf(which))
                }
            }
            builder.setPositiveButton("DONE") { dialogInterface, i ->
                val selectedStrings = ArrayList<String>()

                for (j in selectedList.indices) {
                    selectedStrings.add(items[selectedList[j]])
                }

                Toast.makeText(applicationContext, "Items selected are: " + Arrays.toString(selectedStrings.toTypedArray()), Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

        withStyle.setOnClickListener {
            val builder = AlertDialog.Builder(ContextThemeWrapper(this, android.R.style.Holo_SegmentedButton))

            with(builder)
            {
                setTitle("Androidly Alert")
                setMessage("We have a message")
                setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                setNegativeButton(android.R.string.no, negativeButtonClick)
                setNeutralButton("Maybe", neutralButtonClick)
                show()
            }
        }

        withCustomStyle.setOnClickListener {
            val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))

            with(builder)
            {
                setTitle("Androidly Alert")
                setMessage("We have a message")
                setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
                setNegativeButton(android.R.string.no, negativeButtonClick)
                setNeutralButton("Maybe", neutralButtonClick)
                show()
            }

        }

        withButtonCentered.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Title")
            alertDialog.setMessage("Message")

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"
            ) { dialog, which -> dialog.dismiss() }

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"
            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()

            val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

            val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 10f
            btnPositive.layoutParams = layoutParams
            btnNegative.layoutParams = layoutParams
        }

        withEditText.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            builder.setTitle("With EditText")
            val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
            val editText  = dialogLayout.findViewById<EditText>(R.id.editText)
            builder.setView(dialogLayout)
            builder.setPositiveButton("OK") { dialogInterface, i -> Toast.makeText(applicationContext, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show() }
            builder.show()
        }


        useingcustomlayout.setOnClickListener {
            val builder = AlertDialog.Builder(this,R.style.CustomAlertDialog).create()
            val view = layoutInflater.inflate(R.layout.customview_layout,null)
            val  button = view.findViewById<Button>(R.id.dialogDismiss_button)
            builder.setView(view)
            button.setOnClickListener {
                builder.dismiss()
            }
            builder.setCanceledOnTouchOutside(false)
            builder.show()
        }


    }
}