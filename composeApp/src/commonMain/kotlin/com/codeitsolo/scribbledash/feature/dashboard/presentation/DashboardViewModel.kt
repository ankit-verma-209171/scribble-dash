package com.codeitsolo.scribbledash.feature.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeitsolo.scribbledash.core.presentation.utils.getWhileSubscribedOrRetailed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class DashboardViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(getDefaultUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = getWhileSubscribedOrRetailed(),
        initialValue = _uiState.value
    )

    fun onTabClick(tab: DashboardTab) {
        _uiState.update {
            it.copy(selectedTab = tab)
        }
    }

    private fun getDefaultUiState() = DashboardUiState()
}