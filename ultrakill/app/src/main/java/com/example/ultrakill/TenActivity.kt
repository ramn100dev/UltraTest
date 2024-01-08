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

class TenActivity :  AppCompatActivity(){

    private lateinit var binding: NineBinding

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val b = intent.extras
        val user = b!!.getString("user")
        val finalHp = b!!.getString("finalHp")

        val style = Preferences(this)
        var point = style.cargarStyle()

        binding.style.setText("$user style:")
        binding.hp.text = "$finalHp"

        Utils.check(point, binding.StyleRank)

        binding.op1.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val hp = binding.hp.text.toString().toInt() - 20
            binding.hp.setText("$hp")
            if (hp <= 0) {
                val intent = Intent(this, DeathScreen::class.java)
                startActivity(intent)
                finish()
            }
            if (point > 0) {
                point = style.restarStyle(point)
            }
            Utils.check(point, binding.StyleRank)
        }

        binding.op2.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val hp = binding.hp.text.toString().toInt() - 20
            binding.hp.setText("$hp")
            if (hp <= 0) {
                val intent = Intent(this, DeathScreen::class.java)
                startActivity(intent)
                finish()
            }
            if (point > 0) {
                point = style.restarStyle(point)
            }
            Utils.check(point, binding.StyleRank)
        }

        binding.op3.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.dmg)
            mediaPlayer?.start()
            val hp = binding.hp.text.toString().toInt() - 20
            binding.hp.setText("$hp")
            if (hp <= 0) {
                val intent = Intent(this, DeathScreen::class.java)
                startActivity(intent)
                finish()
            }
            if (point > 0) {
                point = style.restarStyle(point)
            }
            Utils.check(point, binding.StyleRank)
        }

        binding.op4.setOnClickListener {
            mediaPlayer = MediaPlayer.create(this, R.raw.lastatt)
            mediaPlayer?.start()
            if (point >= 8){
                val intent = Intent(this, SecretActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, FinishActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                finish()
            }
        }
    }

}