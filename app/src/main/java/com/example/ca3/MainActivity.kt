package com.example.ca3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnBeginnerLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Beginner")
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.ivBeginnerLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Beginner")
            startActivity(intent)
        }

        // Handling clicks for Intermediate Level
        findViewById<Button>(R.id.btnIntermediateLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Intermediate")
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.ivIntermediateLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Intermediate")
            startActivity(intent)
        }

        // Handling clicks for Advanced Level
        findViewById<Button>(R.id.btnAdvancedLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Advanced")
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.ivAdvancedLevel).setOnClickListener {
            val intent = Intent(this, ModuleActivity::class.java)
            intent.putExtra("level", "Advanced")
            startActivity(intent)
        }
    }
}