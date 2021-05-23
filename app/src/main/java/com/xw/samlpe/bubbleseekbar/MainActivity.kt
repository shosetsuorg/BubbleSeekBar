package com.xw.samlpe.bubbleseekbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xw.samlpe.bubbleseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
	private var mTag: String? = null

	private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		setSupportActionBar(binding.toolbar)
		binding.mainTabBtn1.setOnClickListener(this)
		binding.mainTabBtn2.setOnClickListener(this)
		binding.mainTabBtn3.setOnClickListener(this)
		binding.mainTabBtn4.setOnClickListener(this)

		if (savedInstanceState == null) {
			val ft = supportFragmentManager.beginTransaction()
			ft.add(R.id.container, DemoFragment1.newInstance(), "demo1")
			ft.commit()
			mTag = "demo1"
		}
	}

	override fun onClick(v: View) {
		when (v.id) {
			R.id.main_tab_btn_1 -> switchContent("demo1")
			R.id.main_tab_btn_2 -> switchContent("demo2")
			R.id.main_tab_btn_3 -> switchContent("demo3")
			R.id.main_tab_btn_4 -> switchContent("demo4")
		}
	}

	private fun switchContent(toTag: String) {
		if (mTag == toTag) return
		val fm = supportFragmentManager
		val from = fm.findFragmentByTag(mTag)
		var to = fm.findFragmentByTag(toTag)
		val ft = fm.beginTransaction()
		if (to == null) {
			to = when (toTag) {
				"demo1" -> {
					DemoFragment1.newInstance()
				}
				"demo2" -> {
					DemoFragment2.newInstance()
				}
				"demo3" -> {
					DemoFragment3.newInstance()
				}
				else -> {
					DemoFragment4.newInstance()
				}
			}
		}
		if (!to.isAdded) {
			ft.hide(from!!).add(R.id.container, to, toTag)
		} else {
			ft.hide(from!!).show(to)
		}
		ft.commit()
		mTag = toTag
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		val id = item.itemId
		return if (id == R.id.action_settings) {
			true
		} else super.onOptionsItemSelected(item)
	}
}