package com.example.aplicacionfinal.Modelo

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class SeleccionHora(val listener: (hora: Int, minutos: Int) -> Unit):
                            DialogFragment(), TimePickerDialog.OnTimeSetListener{

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        listener(p1,p2)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val picker = TimePickerDialog(activity as Context, this, 8, 0,true)
        return picker
    }



}