package com.example.videoinfo.testfragment


import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.videoinfo.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class TestFragment : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    val fm: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("activity", "onCreate: ")
        setContentView(R.layout.activity_test_fragment)

        val transaction = fm.beginTransaction()
        transaction.replace(R.id.container, OneFragment())
        fm.popBackStack("OneFragment",FragmentManager.POP_BACK_STACK_INCLUSIVE)
        transaction.addToBackStack("OneFragment")
        transaction.commit()

        /*bottomNav = findViewById(R.id.bottom_nv)
        loadFragment(OneFragment(), 0)
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(OneFragment(), 0)
                    true
                }

                R.id.headphone -> {
                    loadFragment(BlankFragment(), 1)
                    true
                }

                R.id.grope -> {
                    loadFragment(BlankFragmentC(), 1)
                    true
                }

                else ->
                    true
            }
        }*/

    }


    fun loadFragment(fragment: Fragment, flg: Int) {

        val transaction = fm.beginTransaction()
        if (flg == 0) {
            transaction.add(R.id.container, fragment)
            fm.popBackStack(fragment.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            transaction.addToBackStack(fragment.id.toString())
        } else {
            transaction.replace(R.id.container, fragment)
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.e("activity", "onStart: ")
    }

    fun getCurrentFragment(): Fragment? {
        return fm.findFragmentById(R.id.container)
    }


    override fun onResume() {
        super.onResume()
        Log.e("activity", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e("activity", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e("activity", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("activity", "onDestroy: ")
    }
}