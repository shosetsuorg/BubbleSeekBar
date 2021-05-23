package com.xw.samlpe.bubbleseekbar

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.xw.repo.BubbleSeekBar
import com.xw.samlpe.bubbleseekbar.databinding.FragmentDemo3Binding

/**
 * DemoFragment3
 *
 *
 * Created by woxingxiao on 2017-03-11.
 */
class DemoFragment3 : Fragment(R.layout.fragment_demo_3) {
	private val mActivity: Activity by lazy { context as Activity }

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		FragmentDemo3Binding.bind(view).apply {
			demo3SeekBar1.apply {
				configBuilder.apply {
					min = 0f
					max = 5f
					progress = 2f
					sectionCount = 5
					trackColor = ContextCompat.getColor(mActivity, R.color.color_gray)
					secondTrackColor = ContextCompat.getColor(mActivity, R.color.color_blue)
					thumbColor = ContextCompat.getColor(mActivity, R.color.color_blue)
					sectionTextColor = ContextCompat.getColor(mActivity, R.color.colorPrimary)
					sectionTextSize = 18
					showThumbText()
					thumbTextColor = ContextCompat.getColor(mActivity, R.color.color_red)
					thumbTextSize(18)
					bubbleTextSize(18)
					bubbleColor = ContextCompat.getColor(mActivity, R.color.color_red)
					showSectionMark()
					seekStepSection()
					touchToSeek()
					sectionTextPosition = BubbleSeekBar.TextPosition.BELOW_SECTION_MARK
				}.build()
			}
			demo3SeekBar2.apply {
				configBuilder
					.min(0f)
					.max(5f)
					.progress(2f)
					.sectionCount(5)
					.trackColor(ContextCompat.getColor(mActivity, R.color.color_gray))
					.secondTrackColor(ContextCompat.getColor(mActivity, R.color.color_blue))
					.thumbColor(ContextCompat.getColor(mActivity, R.color.color_blue))
					.showSectionText()
					.sectionTextColor(ContextCompat.getColor(mActivity, R.color.colorPrimary))
					.sectionTextSize(18)
					.showThumbText()
					.touchToSeek()
					.thumbTextColor(ContextCompat.getColor(mActivity, R.color.color_red))
					.thumbTextSize(18)
					.bubbleColor(ContextCompat.getColor(mActivity, R.color.color_red))
					.bubbleTextSize(18)
					.showSectionMark()
					.seekBySection()
					.autoAdjustSectionMark()
					.sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
					.build()
			}
			demo3SeekBar3.apply {
				configBuilder
					.min(-50f)
					.max(50f)
					.sectionCount(10)
					.sectionTextInterval(2)
					.trackColor(ContextCompat.getColor(mActivity, R.color.color_red_light))
					.secondTrackColor(ContextCompat.getColor(mActivity, R.color.color_red))
					.seekBySection()
					.showSectionText()
					.sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
					.build()
			}
			demo3SeekBar4.apply {
				configBuilder
					.min(1f)
					.max(1.5f)
					.floatType()
					.sectionCount(10)
					.secondTrackColor(ContextCompat.getColor(mActivity, R.color.color_green))
					.showSectionText()
					.showThumbText()
					.build()
			}
			demo3SeekBar5.apply {
				configBuilder
					.min(-0.4f)
					.max(0.4f)
					.progress(0f)
					.floatType()
					.sectionCount(10)
					.sectionTextInterval(2)
					.showSectionText()
					.sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
					.autoAdjustSectionMark()
					.build()
			}
		}
	}

	companion object {
		fun newInstance(): DemoFragment3 {
			return DemoFragment3()
		}
	}
}