package com.example.ultrakill

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ultrakill.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val style = Preferences(this)
        style.reiniciar()

        mediaPlayer = MediaPlayer.create(this, R.raw.takecare)
        mediaPlayer?.start()

        binding.ELIMINAR.setOnClickListener {
            binding.pass.setText("")
            binding.user.setText("")
        }

        binding.ACCEDER.setOnClickListener {
            val user = binding.user.text.toString()
            val pass = binding.pass.text.toString()

            if (user.isNotEmpty() && pass.isNotEmpty()){
                mediaPlayer?.stop()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                finish()
            } else if (user.isEmpty()){
                binding.user.error = "USUARIO NO ENCONTRADO"
            } else {
                binding.pass.error = "CONTRASEÑA DESCONOCIDA"
            }
        }

    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stop()
    }
}