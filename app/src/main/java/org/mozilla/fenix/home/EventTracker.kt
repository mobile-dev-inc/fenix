/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log

class EventTracker private constructor(private val context: Context) {

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: EventTracker? = null

        fun getInstance(context: Context): EventTracker =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: EventTracker(context).also { INSTANCE = it }
            }
    }

    fun log(message: String) {
        val className = context.applicationInfo.className
        Log.d("EventTracker", "$message from $className")
    }
}