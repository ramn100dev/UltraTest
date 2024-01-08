package com.example.ultrakill

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ultrakill.databinding.DeathBinding

class DeathScreen: AppCompatActivity() {

    private lateinit var binding: DeathBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DeathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.die)
        mediaPlayer?.start()

        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.death)
        mediaPlayer?.start()

        binding.reset.setOnClickListener {
            mediaPlayer?.stop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        /* Para que el gif sea reconocido hay que copiar este codigo en el xml, ya se le puede editar como se quiera

        <pl.droidsonroids.gif.GifImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#fff"
        android:src="@drawable/android" />
        */
    }
}