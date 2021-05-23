package com.xw.samlpe.bubbleseekbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.xw.repo.BubbleSeekBar
import com.xw.samlpe.bubbleseekbar.databinding.FragmentDemo1Binding
import java.util.*

/**
 * DemoFragment1
 *
 *
 * Created by woxingxiao on 2017-03-11.
 */
class DemoFragment1 : Fragment(R.layout.fragment_demo_1) {

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val binding = FragmentDemo1Binding.bind(view)

		val bubbleSeekBar: BubbleSeekBar = binding.demo1SeekBar
		bubbleSeekBar.setProgress(20f)

		val button = binding.demo1Button

		button.setOnClickListener { v ->
			val progress = Random().nextInt(bubbleSeekBar.max.toInt())
			bubbleSeekBar.setProgress(progress.toFloat())
			Snackbar.make(v, "set random progress = $progress", Snackbar.LENGTH_SHORT).show()
		}
	}

	companion object {
		fun newInstance(): DemoFragment1 = DemoFragment1()
	}
}