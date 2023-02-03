package com.seytkalievm.tinkoffjunlab.data.model

data class Response(
    val films: List<FilmPreview>,
    val pagesCount: Int
)