package com.cylit.swapp.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.cylit.swapp.R
import com.cylit.swapp.databinding.FragmentSuccessBinding

class SuccessFragment : DialogFragment() {

    lateinit var binding: FragmentSuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_success, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val toastCountDown: CountDownTimer
        toastCountDown = object : CountDownTimer(1500, 500 /*Tick duration*/) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                try {
                    val navController = Navigation.findNavController(binding.root)
                    navController.navigate(R.id.actionSuccess)
                    dismiss()
                } catch (e: Exception) {
                }
            }
        }
        toastCountDown.start()
    }

    private fun iniciaAnimacion() {
        val animation = AnimationUtils.loadAnimation(activity, R.anim.arriba_abajo)
        binding.imgFragmentOk.startAnimation(animation)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                val toastCountDown: CountDownTimer
                toastCountDown = object : CountDownTimer(1500, 500 /*Tick duration*/) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        try {
                            val navController = Navigation.findNavController(binding.root)
                            navController.navigate(R.id.actionSuccess)
                            dismiss()
                        } catch (e: Exception) {
                        }
                    }
                }
                toastCountDown.start()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null && dialog.window != null) {
            dialog.window!!.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

}