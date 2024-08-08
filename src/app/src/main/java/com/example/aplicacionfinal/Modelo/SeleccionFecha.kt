package com.example.aplicacionfinal.Modelo

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class SeleccionFecha (val listener: (day: Int, month: Int, year: Int) -> Unit):
                        DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onDateSet(p0: DatePicker?, a: Int, m: Int, d: Int) {
        listener(d, m, a)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        return picker
    }




}