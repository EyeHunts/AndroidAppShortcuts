package com.eyehunts.androidappshortcuts

import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appContext = applicationContext

        val shortcutManager = getSystemService<ShortcutManager>(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(appContext, "id1")
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(Icon.createWithResource(appContext, R.drawable.baseline_open_in_browser_black_18dp))
            .setIntent(
                Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.tutorial.eyehunts.com/"))
            )
            .build()

        shortcutManager!!.dynamicShortcuts = Arrays.asList(shortcut)
    }
}
