package com.example.ca3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ModuleActivity : AppCompatActivity() {
    private lateinit var topicsAdapter: ArrayAdapter<String>
    private val topics = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_module)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val level = intent.getStringExtra("level")
        findViewById<TextView>(R.id.tvModuleTitle).text = "$level Topics"
        topics.addAll(getTopicsForLevel(level))
        topicsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, topics)
        findViewById<ListView>(R.id.lvTopics).adapter = topicsAdapter
        findViewById<ListView>(R.id.lvTopics).setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, TopicActivity::class.java)
            intent.putExtra("topic", topics[position])
            startActivity(intent)
        }
    }

    private fun getTopicsForLevel(level: String?): List<String> {
        return when (level) {
            "Beginner" -> listOf("Investment Basics", "Securities", "Primary Market")
            "Intermediate" -> listOf("IPO Basics", "Secondary Market", "Products in Secondary Market")
            "Advanced" -> listOf("Derivatives", "Depositories", "Mutual Funds")
            else -> emptyList()
        }
    }

}