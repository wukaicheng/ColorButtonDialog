package com.example.aboutpage

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import cn.kaicity.library.colorbuttondialog.ColorButtonDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val colorButtonDialog=ColorButtonDialog(this)
        colorButtonDialog.setTitle("弹窗")
        colorButtonDialog.setIcon(R.mipmap.ic_launcher)
        colorButtonDialog.setOnPositiveButton("确定"){
            Toast.makeText(this, "this is from dialog", Toast.LENGTH_SHORT).show()
        }
        colorButtonDialog.setOnNegativeButton("取消")
        colorButtonDialog.setMessage("aihgongkdadnkfga")
        colorButtonDialog.setView(R.layout.activity_main)
        colorButtonDialog.show()
    }
}