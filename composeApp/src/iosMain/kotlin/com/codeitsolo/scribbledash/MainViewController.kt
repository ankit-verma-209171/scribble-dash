package com.codeitsolo.scribbledash

import androidx.compose.ui.window.ComposeUIViewController
import com.codeitsolo.scribbledash.app.App
import com.codeitsolo.scribbledash.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }