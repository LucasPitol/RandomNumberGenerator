package com.pitol.randomnumbergenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var mViewHolder: ViewHolder = ViewHolder()

    private val fromEmptyClaims: Array<String> = arrayOf("Alright, but where do I start?", "I swear there's something missing", "From?")
    private val toEmptyClaims: Array<String> = arrayOf("Don't know where this is going...", "To infinity, r u sure?", "I swear there's something missing")

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

    private fun getARandomClaim(claims: Array<String>): String {

        var arrayLimit = (claims.count() - 1)

        var i = (0..arrayLimit).random()

       return claims[i]
    }

    private fun shuffle(viewHolder: ViewHolder) {

        var fromStr: String = viewHolder.from.text.toString()

        var toStr: String = viewHolder.to.text.toString()

        var answer: String

        if (fromStr.isNullOrEmpty()) {

            answer = getARandomClaim(fromEmptyClaims)

        } else {

            if (toStr.isNullOrEmpty()) {

                answer = getARandomClaim(toEmptyClaims)

            } else {

                var from: Int = fromStr.toInt()
                var to: Int = toStr.toInt()

                answer = if (from >= to) {

                    getString(R.string.from_greater_than_to_text)

                } else {

                    ((from..to).random()).toString()
                }
            }
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
