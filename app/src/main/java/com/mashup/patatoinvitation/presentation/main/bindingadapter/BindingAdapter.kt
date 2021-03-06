package com.mashup.patatoinvitation.presentation.main.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mashup.patatoinvitation.R

@BindingAdapter("bind:isChecked")
fun ImageView.setCheck(isChecked: Boolean) {
    if (isChecked) {
        setImageResource(R.drawable.ic_invitation_chk_green)
    } else {
        setImageResource(R.drawable.ic_invitation_chk_gray)
    }
}