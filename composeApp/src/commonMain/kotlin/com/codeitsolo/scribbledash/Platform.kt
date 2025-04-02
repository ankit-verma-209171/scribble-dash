package com.codeitsolo.scribbledash

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform