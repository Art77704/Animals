package com.example.animals

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class BlankFragment3: Fragment() {
    var sPref: SharedPreferences? = null
    var player = false

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        sPref = requireContext().getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        val editor = sPref?.edit()
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        val bmusic = view.findViewById<Button>(R.id.startmusicBTN)

        var mediaPlayer = MediaPlayer.create(context, R.raw.lynx_audio)
        bmusic.setOnClickListener {
            if (!player) {
                mediaPlayer.start()
                player = true
            } else {
                mediaPlayer.stop()
                player = false
                mediaPlayer = MediaPlayer.create(context, R.raw.lynx_audio)
            }


        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment3()
    }
}