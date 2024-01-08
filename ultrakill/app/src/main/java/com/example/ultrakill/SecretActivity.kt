package com.example.ultrakill

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ultrakill.databinding.EightBinding
import com.example.ultrakill.databinding.FifthBinding
import com.example.ultrakill.databinding.FourthBinding
import com.example.ultrakill.databinding.NineBinding
import com.example.ultrakill.databinding.SevenBinding
import com.example.ultrakill.databinding.SixBinding
import com.example.ultrakill.databinding.ThridBinding
import com.example.ultrakill.databinding.UltimaBinding

class SecretActivity :  AppCompatActivity(){

    private lateinit var binding: UltimaBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UltimaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras
        val user = b!!.getString("user")

        val style = Preferences(this)
        var point = style.cargarStyle()
        val challenge = true

        binding.style.setText("$user style:")
        binding.hp.text = "1"

        Utils.check(point, binding.StyleRank)

        binding.op1.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val intent = Intent(this, DeathScreen::class.java)
            startActivity(intent)
            finish()

            point = style.restarStyle(point)
            Utils.check(point, binding.StyleRank)
        }

        binding.op2.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val intent = Intent(this, DeathScreen::class.java)
            startActivity(intent)
            finish()

            point = style.restarStyle(point)
            Utils.check(point, binding.StyleRank)
        }

        binding.op3.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.fk)
            mediaPlayer?.start()
            val finalHp = binding.hp.text.toString()
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("user", user)
            intent.putExtra("challenge", challenge)
            startActivity(intent)
            finish()
        }

        binding.op4.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val intent = Intent(this, DeathScreen::class.java)
            startActivity(intent)
            finish()

            point = style.restarStyle(point)
            Utils.check(point, binding.StyleRank)
        }
    }

}