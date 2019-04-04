package com.vathna.saaavy


import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_onboard.*


class OnboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboard, container, false)
    }

    companion object {
        fun newInstance(model: OnBoardModel): OnboardFragment {
            val fragment = OnboardFragment()
            val args = Bundle()
            args.putParcelable("data", model)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = arguments!!.getParcelable("data") as OnBoardModel
        ivOnBoard.setImageResource(model.imageId)
        tvTitle.text = model.title
        tvDescription.text = model.description
    }

}

@Parcelize
data class OnBoardModel(val imageId: Int, val title: String, val description: String) : Parcelable
