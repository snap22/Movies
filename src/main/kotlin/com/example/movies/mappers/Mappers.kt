package com.example.movies.mappers

import com.example.generated.tables.Actor.ACTOR
import com.example.movies.dto.Actor
import org.jooq.Record as TableRecord

fun tableToDto(table: TableRecord): Actor =
    Actor(
        table.get(ACTOR.ACTOR_ID),
        table.get(ACTOR.FIRST_NAME),
        table.get(ACTOR.LAST_NAME),
    )
