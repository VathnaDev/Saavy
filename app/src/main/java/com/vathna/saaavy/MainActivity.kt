package com.vathna.saaavy

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toggle.*

class MainActivity : AppCompatActivity() {

    private var isShowHistory = false

    private val fadeInAnim = AlphaAnimation(0f, 1f)
    private val fadeOutAnim = AlphaAnimation(1f, 0f)
    private val historyFragment = HistoryFragment()
    private val addExpenseFragment = AddExpenseFragment()
    private val addCardFragment = AddCardFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        view.setOnClickListener {
            toggleHistoryView()
            if (isShowHistory) {
                tvTitle.text = "Dashboard"
                tvYourCard.startAnimation(fadeInAnim)
                btnAddCard.startAnimation(fadeInAnim)
                btnAddExpense.startAnimation(fadeInAnim)
                ivCreditCard.startAnimation(fadeInAnim)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.toggledContent, historyFragment)
                    .commit()
            } else {
                tvTitle.text = if (tvTitle.text == "Dashboard") "History" else tvTitle.text
                tvYourCard.startAnimation(fadeOutAnim)
                btnAddCard.startAnimation(fadeOutAnim)
                btnAddExpense.startAnimation(fadeOutAnim)
                ivCreditCard.startAnimation(fadeOutAnim)
            }
            isShowHistory = !isShowHistory
        }

        fabDispose.setOnClickListener {
            view.performClick()
        }
        btnAddCard.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.toggledContent, addCardFragment)
                .commit()
            tvTitle.text = "Add Card"
            view.performClick()
        }
        fabAddEpense.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.toggledContent, addExpenseFragment)
                .commit()
            tvTitle.text = "Add Expense"
            view.performClick()
        }

        btnAddExpense.setOnClickListener {
            fabAddEpense.performClick()
        }

        btnMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    private fun init() {
        //Fragments
        supportFragmentManager.beginTransaction()
            .replace(R.id.toggledContent, historyFragment)
            .commit()

        //Animations
        fadeInAnim.duration = 1000
        fadeInAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                tvYourCard.visibility = View.VISIBLE
                btnAddCard.visibility = View.VISIBLE
                btnAddExpense.visibility = View.VISIBLE
                ivCreditCard.visibility = View.VISIBLE
                fabAddEpense.show()
                fabDispose.hide()
            }
        })

        fadeOutAnim.duration = 1000
        fadeOutAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                tvYourCard.visibility = View.INVISIBLE
                btnAddCard.visibility = View.INVISIBLE
                btnAddExpense.visibility = View.INVISIBLE
                ivCreditCard.visibility = View.INVISIBLE
                fabAddEpense.hide()
                fabDispose.show()
            }

        })


    }

    private fun toggleHistoryView() {
        val params: ConstraintLayout.LayoutParams = rootHistoryDetail.layoutParams as ConstraintLayout.LayoutParams
        var marginTop =
            if (isShowHistory) MetricsUtil.convertDpToPixel(450f, this) else MetricsUtil.convertDpToPixel(
                100f,
                this
            )
        val anim = ValueAnimator.ofInt(params.topMargin, marginTop.toInt())
        anim.duration = 1000
        anim.addUpdateListener {
            params.topMargin = it.animatedValue as Int
            rootHistoryDetail.layoutParams = params
        }
        anim.start()

        val detailParams: ConstraintLayout.LayoutParams = layoutDetail.layoutParams as ConstraintLayout.LayoutParams
        val marginTop2 =
            if (isShowHistory) MetricsUtil.convertDpToPixel(230f, this) else MetricsUtil.convertDpToPixel(
                140f,
                this
            )
        val anim2 = ValueAnimator.ofInt(detailParams.topMargin, marginTop2.toInt())
        anim2.duration = 1000
        anim2.addUpdateListener {
            detailParams.topMargin = it.animatedValue as Int
            layoutDetail.layoutParams = detailParams
        }
        anim2.start()

    }

}


