package com.example.movies

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<MoviesApplication>().with(TestcontainersConfiguration::class).run(*args)
}
