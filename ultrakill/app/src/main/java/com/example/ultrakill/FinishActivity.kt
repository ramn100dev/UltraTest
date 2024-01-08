package com.example.ultrakill

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ultrakill.databinding.FinishBinding

class FinishActivity: AppCompatActivity() {

    private lateinit var binding: FinishBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.fire)
        mediaPlayer?.start()

        val b = intent.extras
        val user = b!!.getString("user")
        val challenge = b!!.getBoolean("challenge")

        binding.jugador.setText("-- $user --")

        if (challenge) {
            binding.Challenge.setCardBackgroundColor(Color.YELLOW)
        }

        binding.reset.setOnClickListener {
            mediaPlayer?.stop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}