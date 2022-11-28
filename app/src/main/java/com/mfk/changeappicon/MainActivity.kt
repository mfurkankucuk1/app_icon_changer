package com.mfk.changeappicon

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnFirst: Button
    private lateinit var btnSecond: Button
    private lateinit var btnThird: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        handleClickEvents()
    }

    private fun handleClickEvents() {
        btnFirst.setOnClickListener {
        setIcon(ICON_COLOUR.BLUE)
        }
        btnSecond.setOnClickListener {
            setIcon(ICON_COLOUR.RED)
        }
        btnThird.setOnClickListener {
            setIcon(ICON_COLOUR.GREEN)
        }
    }

    enum class ICON_COLOUR { RED, GREEN, BLUE }

    private fun setIcon(targetColour: ICON_COLOUR) {
        for (value in ICON_COLOUR.values()) {
            val action = if (value == targetColour) {
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED
            } else {
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            }
            packageManager.setComponentEnabledSetting(
                ComponentName(BuildConfig.APPLICATION_ID, "${BuildConfig.APPLICATION_ID}.${value.name}"),
                action, PackageManager.DONT_KILL_APP
            )
        }
    }

    private fun initialize() {
        btnFirst = findViewById(R.id.btnFirst)
        btnSecond = findViewById(R.id.btnSecond)
        btnThird = findViewById(R.id.btnThird)
    }


}