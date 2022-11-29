package com.ahmed.crm.util

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}