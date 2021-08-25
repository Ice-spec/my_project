package com.joelson.delgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joelson.delgram.databinding.ActivityMainBinding
import com.joelson.delgram.fragments.ChatFragment
import com.joelson.delgram.fragments.HomeFragment
import com.joelson.delgram.fragments.ProfileFragment
import com.joelson.delgram.fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {

                    R.id.nav_home -> {
                        moveToFragment(HomeFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_search -> {
                        moveToFragment(SearchFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_add -> {
                        item.isChecked = false
                        startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_send -> {
                        moveToFragment(ChatFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.nav_profile -> {
                        moveToFragment(ProfileFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        if (inCreate) {
            moveToFragment(ProfileFragment())
            inCreate = false
        } else {
            moveToFragment(HomeFragment())
        }
        mBinding.bottomNavView.setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)
    }

    private fun moveToFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(mBinding.fragmentContainer.id, fragment)
        fragmentTrans.commit()
    }

    companion object {
        var inCreate = false
        var moveTo = false
    }
}