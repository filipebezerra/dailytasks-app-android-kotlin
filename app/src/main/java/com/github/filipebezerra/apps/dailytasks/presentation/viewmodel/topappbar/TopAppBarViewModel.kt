package com.github.filipebezerra.apps.dailytasks.presentation.viewmodel.topappbar

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TopAppBarViewModel : ViewModel() {

    private val _isSearchBarVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSearchBarVisible = _isSearchBarVisible.asStateFlow()

    private val _searchedText: MutableStateFlow<String> = MutableStateFlow("")
    val searchedText = _searchedText.asStateFlow()

    fun toggleSearchAppBar() {
        _isSearchBarVisible.update { !_isSearchBarVisible.value }
    }

    fun handleSearchedTextChange(searchedText: String) {
        _searchedText.update { searchedText }
    }
}
