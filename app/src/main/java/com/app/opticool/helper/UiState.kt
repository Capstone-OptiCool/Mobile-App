package com.app.opticool.helper

sealed class UiState<out T: Any?> {
    object Idle: UiState<Nothing>()
    object Loading: UiState<Nothing>()
    data class Success<out T: Any>(val data: T): UiState<T>()
    data class Error(val errorMessage: String): UiState<Nothing>()
}