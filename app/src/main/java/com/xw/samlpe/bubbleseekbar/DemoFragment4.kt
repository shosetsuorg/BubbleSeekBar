package com.xw.samlpe.bubbleseekbar

import android.app.Activity
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.xw.repo.BubbleSeekBar
import com.xw.repo.BubbleSeekBar.CustomSectionTextArray
import com.xw.repo.BubbleSeekBar.OnProgressChangedListenerAdapter
import com.xw.samlpe.bubbleseekbar.databinding.FragmentDemo4Binding
import java.util.*

/**
 * DemoFragment4
 *
 *
 * Created by woxingxiao on 2017-03-11.
 */
class DemoFragment4 : Fragment(R.layout.fragment_demo_4) {
	private val mActivity: Activity by lazy { context as Activity }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		FragmentDemo4Binding.bind(view).apply {
			demo4ObsScrollView.setOnScrollChangedListener { _, _, _, _, _ ->
				demo4SeekBar1.correctOffsetWhenContainerOnScrolling()
			}
			demo4SeekBar2.onProgressChangedListener = object : OnProgressChangedListenerAdapter() {
				override fun onProgressChanged(
					bubbleSeekBar: BubbleSeekBar?,
					progress: Int,
					progressFloat: Float,
					fromUser: Boolean
				) {
					val s = String.format(
						Locale.CHINA,
						"onChanged int:%d, float:%.1f",
						progress,
						progressFloat
					)
					demo4ProgressText1.text = s
				}

				override fun getProgressOnActionUp(
					bubbleSeekBar: BubbleSeekBar?,
					progress: Int,
					progressFloat: Float
				) {
					val s = String.format(
						Locale.CHINA,
						"onActionUp int:%d, float:%.1f",
						progress,
						progressFloat
					)
					demo4ProgressText2.text = s
				}

				override fun getProgressOnFinally(
					bubbleSeekBar: BubbleSeekBar?,
					progress: Int,
					progressFloat: Float,
					fromUser: Boolean
				) {
					val s = String.format(
						Locale.CHINA,
						"onFinally int:%d, float:%.1f",
						progress,
						progressFloat
					)
					demo4ProgressText3.text = s
				}
			}

			// trigger by set progress or seek by finger
			demo4SeekBar3.setProgress(demo4SeekBar3.max)

			// customize section texts
			demo4SeekBar4.apply {
				setCustomSectionTextArray(object : CustomSectionTextArray {
					override fun onCustomize(
						sectionCount: Int,
						array: SparseArray<String?>
					): SparseArray<String?> {
						array.clear()
						array[1] = "bad"
						array[4] = "ok"
						array[7] = "good"
						array[9] = "great"
						return array
					}
				})
				onProgressChangedListener = object : OnProgressChangedListenerAdapter() {
					override fun onProgressChanged(
						bubbleSeekBar: BubbleSeekBar?,
						progress: Int,
						progressFloat: Float,
						fromUser: Boolean
					) {
						val color: Int = when {
							progress <= 10 -> {
								ContextCompat.getColor(mActivity, R.color.color_red)
							}
							progress <= 40 -> {
								ContextCompat.getColor(mActivity, R.color.color_red_light)
							}
							progress <= 70 -> {
								ContextCompat.getColor(mActivity, R.color.colorAccent)
							}
							progress <= 90 -> {
								ContextCompat.getColor(mActivity, R.color.color_blue)
							}
							else -> {
								ContextCompat.getColor(mActivity, R.color.color_green)
							}
						}
						bubbleSeekBar!!.setSecondTrackColor(color)
						bubbleSeekBar.setThumbColor(color)
						bubbleSeekBar.setBubbleColor(color)
					}
				}
				setProgress(60f)
			}
		}
	}

	companion object {
		fun newInstance(): DemoFragment4 = DemoFragment4()
	}
	private operator fun <E> SparseArray<E>.set(i: Int, value: E) = put(i, value)

}


