package com.withcodeplays.common

import android.content.Context
import android.content.pm.PackageManager
import timber.log.Timber


object Common {
    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        var hasAllPermissions = true
        for (permission in permissions) {
            //you can return false instead of assigning, but by assigning you can log all permission values
            if (!hasPermission(context!!, permission!!)) {
                hasAllPermissions = false
            }
        }
        return hasAllPermissions
    }


    fun hasPermission(context: Context, permission: String): Boolean {
        val res = context.checkCallingOrSelfPermission(permission)
        Timber.v("permission: " + permission + " = \t\t" +
                    if (res == PackageManager.PERMISSION_GRANTED) "GRANTED" else "DENIED"
        )
        return res == PackageManager.PERMISSION_GRANTED
    }

}