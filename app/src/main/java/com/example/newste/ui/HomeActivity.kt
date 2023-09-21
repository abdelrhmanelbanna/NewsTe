package com.example.newste.ui

import android.os.Bundle
import android.view.View

import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newste.R

class HomeActivity : AppCompatActivity() {


    lateinit var drawerLayout: DrawerLayout
    lateinit var buttonMenu: ImageView

    lateinit var category: View
    lateinit var settings: View

    val categoriesFragment = CategoriesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()

        // by default
        pushFragment(categoriesFragment)

    }

    fun initView() {

        drawerLayout = findViewById(R.id.drawer_layout)
        buttonMenu = findViewById(R.id.menu_button)

        category = findViewById(R.id.category)
        settings = findViewById(R.id.settings)

        buttonMenu.setOnClickListener {
            drawerLayout.open()
        }

        category.setOnClickListener {
            pushFragment(categoriesFragment)
        }

        settings.setOnClickListener {
            pushFragment(SettingsFragment())
        }


    }


    fun pushFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_countainer, fragment)
            .commit()

    }


}