package com.example.solutionx

sealed class LoggerType(val tag: String, val message: String) {

    data class D(val DTag: String, val DMessage: String) : LoggerType(DTag, DMessage)
    data class I(val ITag: String, val IMessage: String) : LoggerType(ITag, IMessage)
    data class W(val WTag: String, val WMessage: String) : LoggerType(WTag, WMessage)
    data class E(val ETag: String, val EMessage: String) : LoggerType(ETag, EMessage)
}
