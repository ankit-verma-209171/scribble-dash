package com.codeitsolo.scribbledash.app

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination

@Serializable
data object Dashboard : Destination
