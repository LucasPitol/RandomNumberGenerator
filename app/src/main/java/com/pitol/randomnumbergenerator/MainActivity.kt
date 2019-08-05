package com.pitol.randomnumbergenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mViewHolder: ViewHolder = ViewHolder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        this.mViewHolder.from = findViewById(R.id.from)
        this.mViewHolder.to = findViewById(R.id.to)
        this.mViewHolder.answer = findViewById(R.id.answer)
        this.mViewHolder.shuffleIcon = findViewById(R.id.shuffle_icon)

        this.mViewHolder.shuffleIcon.setOnClickListener {
            shuffle(this.mViewHolder)
        }
    }

    private fun shuffle(viewHolder: ViewHolder) {

        var from: Int = viewHolder.from.text.toString().toInt()

        var to: Int = viewHolder.to.text.toString().toInt()

        var answer: String

        if (from > to) {

            answer = getString(R.string.from_greater_than_to_text)

        } else {

            answer = ((from..to).random()).toString()
        }

        this.mViewHolder.answer.text = answer
    }
}

private class ViewHolder {
    lateinit var from: EditText
    lateinit var to: EditText
    lateinit var answer: TextView
    lateinit var shuffleIcon: ImageView
}
