package com.tp.androiddata.ui

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.*
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.tp.androiddata.R
import java.text.AttributedString
import java.time.format.TextStyle


class MainFragment : Fragment() {

    private lateinit var txtView: TextView
    private lateinit var txtView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        txtView = view.findViewById(R.id.tv)
        txtView2 = view.findViewById(R.id.tv2)
        textSpan()
        textTwoSpan()
        return view
    }

    fun textSpan() {

        val spannableStringBuilder = SpannableStringBuilder("Hi Premila Ramalingam")

        val fColor = ForegroundColorSpan(Color.RED)

        val bgColor = BackgroundColorSpan(Color.YELLOW)

        spannableStringBuilder.setSpan(fColor, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        spannableStringBuilder.setSpan(bgColor, 3, 10, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        txtView.setText(spannableStringBuilder)

    }

    fun textTwoSpan() {

        val spannableString = SpannableString("Hello there!")

        val sizespan = RelativeSizeSpan(2f)

        spannableString.setSpan(sizespan, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        if (Build.VERSION.SDK_INT >=
            Build.VERSION_CODES.N
        ) {
            txtView2.setText(
                Html.fromHtml(
                    getString(R.string.htmlDemo),
                    Html.FROM_HTML_MODE_COMPACT
                )
            )
        } else {

            txtView2.setText(Html.fromHtml(getString(R.string.htmlDemo)))
        }
    }

}