package com.example.movies.services

import com.example.generated.tables.Actor.ACTOR
import com.example.movies.dto.Actor
import com.example.movies.mappers.tableToDto
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import java.lang.IllegalStateException

@Service
class ActorService(
    val context: DSLContext,
) {
    fun getActors(): List<Actor> =
        context
            .selectFrom(ACTOR)
            .fetch()
            .map(::tableToDto)

    fun getActor(actorId: Int): Actor =
        context
            .selectFrom(ACTOR)
            .where(ACTOR.ACTOR_ID.eq(actorId))
            .fetchOne()
            ?.map(::tableToDto) ?: throw IllegalStateException("Actor with id $actorId not found")

    fun createActor(actor: Actor): Int =
        context
            .insertInto(ACTOR)
            .set(ACTOR.FIRST_NAME, actor.firstName)
            .set(ACTOR.LAST_NAME, actor.lastName)
            .returning(ACTOR.ACTOR_ID)
            .fetchOne()
            ?.actorId ?: throw IllegalStateException("Error inserting new actor")

    fun deleteActor(actorId: Int) {
        context
            .deleteFrom(ACTOR)
            .where(ACTOR.ACTOR_ID.eq(actorId))
            .execute()
    }
}
