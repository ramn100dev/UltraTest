package com.example.ultrakill

import android.widget.ImageView
import com.example.ultrakill.databinding.FirstBinding

class Utils {
    companion object{
        fun check(style:Int, imageView:ImageView) {

            if (style <= 0) {
                imageView.setImageResource(R.drawable.ic_launcher_background)
            } else if (style == 1) {
                imageView.setImageResource(R.drawable.d_rank)
            } else if (style == 2) {
                imageView.setImageResource(R.drawable.c_rank)
            } else if (style == 3) {
                imageView.setImageResource(R.drawable.b_rank)
            } else if (style == 4) {
                imageView.setImageResource(R.drawable.a_rank)
            } else if (style == 5) {
                imageView.setImageResource(R.drawable.s_rank)
            } else if (style == 6) {
                imageView.setImageResource(R.drawable.ss_rank)
            } else if (style == 7) {
                imageView.setImageResource(R.drawable.sss_rank)
            } else if (style == 8) {
                imageView.setImageResource(R.drawable.u_rank_629)
            }
        }
    }
}