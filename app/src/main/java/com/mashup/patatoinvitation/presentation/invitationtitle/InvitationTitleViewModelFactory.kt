package com.mashup.patatoinvitation.presentation.invitationtitle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mashup.patatoinvitation.data.repository.InvitationRepository

class InvitationTitleViewModelFactory(
    private val repository: InvitationRepository,
    private val templateId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(InvitationTitleViewModel::class.java)) {
            InvitationTitleViewModel(repository, templateId) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}