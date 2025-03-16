package com.example.movies.controllers

import com.example.movies.dto.Actor
import com.example.movies.services.ActorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actors")
class ActorController(
    val actorService: ActorService,
) {
    @PostMapping
    fun createActor(
        @RequestBody request: Actor,
    ): Int = actorService.createActor(request)

    @GetMapping
    fun getActors(): List<Actor> = actorService.getActors()

    @GetMapping("/{id}")
    fun getActor(
        @PathVariable id: Int,
    ) = actorService.getActor(id)

    @DeleteMapping("/{id}")
    fun deleteActor(
        @PathVariable id: Int,
    ) = actorService.deleteActor(id)
}
