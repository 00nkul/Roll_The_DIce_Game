package com.example.rollthedicegame

import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnRoll :Button = findViewById(R.id.btnRoll)
        var btnRoll2 :Button = findViewById(R.id.btnRoll2)
        var ivDice1 :ImageView = findViewById(R.id.ivDice1)
        var ivDice2 :ImageView = findViewById(R.id.ivDice2)
        var tvScore :TextView = findViewById(R.id.tvScore)

        var mediaPlayer = MediaPlayer.create(this, R.raw.roll)
        var num:Int =0;
        btnRoll.setOnClickListener {

            var randomNumber :Int = (1..6).random()
            num = randomNumber
            val anim = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.interpolator = LinearInterpolator()
            anim.repeatCount = 1
            anim.duration = 300

                ivDice1.animation = anim
                mediaPlayer.start()
                when(randomNumber){
                    1->ivDice1.setImageResource(R.drawable.dice1)
                    2->ivDice1.setImageResource(R.drawable.dice2)
                    3->ivDice1.setImageResource(R.drawable.dice3)
                    4->ivDice1.setImageResource(R.drawable.dice4)
                    5->ivDice1.setImageResource(R.drawable.dice5)
                    6->ivDice1.setImageResource(R.drawable.dice6)
                }
                tvScore.text = "Player 1 score is $randomNumber ! \n Player 2 Turn"
        }

        btnRoll2.setOnClickListener {

            var randomNumber :Int = (1..6).random()

            val anim = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.interpolator = LinearInterpolator()
            anim.repeatCount = 1
            anim.duration = 300

            ivDice2.animation = anim
            mediaPlayer.start()
            when(randomNumber){
                1->ivDice2.setImageResource(R.drawable.dice1)
                2->ivDice2.setImageResource(R.drawable.dice2)
                3->ivDice2.setImageResource(R.drawable.dice3)
                4->ivDice2.setImageResource(R.drawable.dice4)
                5->ivDice2.setImageResource(R.drawable.dice5)
                6->ivDice2.setImageResource(R.drawable.dice6)
            }

            if (num>randomNumber){
                tvScore.text = "Player 2 score is $randomNumber !\n Player 1 Won"
            }else{
                tvScore.text = "Player 2 score is $randomNumber !\nPlayer 2 won"
            }
        }
    }
}