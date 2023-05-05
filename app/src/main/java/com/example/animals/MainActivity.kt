package com.example.animals

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animals.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val fragList = listOf(
        BlankFragment.newInstance(),
        BlankFragment2.newInstance(),
        BlankFragment3.newInstance(),
        BlankFragment4.newInstance()

    )

    private val fragText = listOf(
        "Слон",
        "Лемур",
        "Рысь",
        "Медведь"
    )

    /*private val fragIcon = listOf(
        R.drawable.slon_icon
    )*/





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)


        val adapter = Viewpageraddapter(this, fragList)
        bind.idvp.adapter = adapter
        TabLayoutMediator(bind.idtabl, bind.idvp){
            tab, pos ->
            tab.text = fragText[pos]
            //tab.icon = ContextCompat.getDrawable(this, fragIcon[pos])
        }.attach()
    }
}