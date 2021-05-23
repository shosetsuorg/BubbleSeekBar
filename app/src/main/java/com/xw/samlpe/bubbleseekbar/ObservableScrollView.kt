package com.xw.samlpe.bubbleseekbar

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

class ObservableScrollView @JvmOverloads constructor(
	context: Context?,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0,
) : ScrollView(context, attrs, defStyleAttr) {
	private var mOnScrollChangedListener: OnScrollChangedListener? = null

	fun setOnScrollChangedListener(onScrollChangedListener: OnScrollChangedListener) {
		mOnScrollChangedListener = onScrollChangedListener
	}

	override fun onScrollChanged(x: Int, y: Int, oldx: Int, oldy: Int) {
		super.onScrollChanged(x, y, oldx, oldy)
		if (mOnScrollChangedListener != null)
			mOnScrollChangedListener!!(this, x, y, oldx, oldy)
	}

	override fun onInterceptTouchEvent(ev: MotionEvent): Boolean =
		false // 此处为了演示，阻止ScrollView拦截Touch事件
}

typealias OnScrollChangedListener = (
	@ParameterName("scrollView") ObservableScrollView?,
	@ParameterName("x") Int,
	@ParameterName("y") Int,
	@ParameterName("oldx") Int,
	@ParameterName("oldy") Int
) -> Unit