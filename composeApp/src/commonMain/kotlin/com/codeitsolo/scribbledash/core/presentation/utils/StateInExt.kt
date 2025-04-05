package com.codeitsolo.scribbledash.core.presentation.utils

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlin.time.Duration.Companion.seconds

fun getWhileSubscribedOrRetailed() = SharingStarted.WhileSubscribed(stopTimeout = 5.seconds)