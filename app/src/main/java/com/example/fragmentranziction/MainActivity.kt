package com.example.fragmentranziction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmentranziction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var fragmentM = supportFragmentManager
    var fragmentB = BlankFragment()
    var fragment2 = BlankFragment2()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            fragmentM.beginTransaction().add(R.id.con, fragmentB).addToBackStack("fragment").commit()
            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
        }

        binding.remove.setOnClickListener {
            fragmentM.beginTransaction().remove(fragmentB).commit()
            fragmentM.beginTransaction().remove(fragment2).commit()
            Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
        }

        binding.replace.setOnClickListener {
            fragmentM.beginTransaction().replace(R.id.con, fragment2).addToBackStack("Aaa").commit()
            Toast.makeText(this, "Repleced", Toast.LENGTH_SHORT).show()
        }

        binding.hide.setOnClickListener {
            fragmentM.beginTransaction().hide(fragment2).commit()
            fragmentM.beginTransaction().hide(fragmentB).commit()
            Toast.makeText(this, "Hided", Toast.LENGTH_SHORT).show()
        }

        binding.show.setOnClickListener {
            fragmentM.beginTransaction().show(fragment2).commit()
            fragmentM.beginTransaction().show(fragmentB).commit()
            Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show()
        }

    }
}