package com.example.videoinfo.testfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.videoinfo.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("onAttach", "onAttach: " )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.e("onCreate", "onCreate: " )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.e("onCreateView", "onCreateView: ", )
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("onViewCreated", "onViewCreated: " )

    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: " )
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "onResume: " )
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause: " )
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop: " )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("onDestroyView", "onDestroyView: " )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onDestroy: " )
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("onDetach", "onDetach: ", )
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}