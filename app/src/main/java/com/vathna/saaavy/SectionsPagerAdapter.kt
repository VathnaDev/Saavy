package com.vathna.saaavy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> OnboardFragment.newInstance(
                OnBoardModel(
                    R.drawable.ic_undraw_investing, "Track your expenses", "Gather all your debts, morgages and\n" +
                            "spendings in one place. "
                )
            )
            1 -> OnboardFragment.newInstance(
                OnBoardModel(
                    R.drawable.ic_setup,
                    "Easy to setup",
                    "Forget about complicated and time consuming \n setup. Manage your budget in seconds."
                )
            )
            2 -> OnboardFragment.newInstance(
                OnBoardModel(
                    R.drawable.ic_ready, "Are you ready?", "Add your first expenses, set up dates\n" +
                            "and alerts."
                )
            )
            else -> Fragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

}