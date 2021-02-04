package com.elgobyte.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {

    private val ARG_COUNT = "param1"
    private var counter: Int? = null
    private lateinit var textViewCounter: TextView

    private var COLOR_MAP = arrayOf(
        R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700, R.color.blue_100,
        R.color.blue_300, R.color.blue_500, R.color.blue_700, R.color.green_100, R.color.green_300,
        R.color.green_500, R.color.green_700
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            counter = arguments?.getInt(ARG_COUNT)
            Log.e("myTag", "${arguments?.getInt(ARG_COUNT)}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewCounter = view.findViewById(R.id.tv_counter)
        //textViewCounter.setTextColor(resources.getColor(COLOR_MAP[counter!!]))
        textViewCounter.setBackgroundColor(
            ContextCompat.getColor(
                App.context,
                COLOR_MAP[counter!!]
            )
        )
        textViewCounter.text = "Hello blank fragment $counter"

    }


    companion object {
        @JvmStatic
        fun newInstance(counter: Int): HomeFragment {
            val args = Bundle()
            args.putInt("param1", counter)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}