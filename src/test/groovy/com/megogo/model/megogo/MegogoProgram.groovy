package com.megogo.model.megogo

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming
import groovy.transform.Canonical

@Canonical
@JsonDeserialize
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy)
class MegogoProgram {
    Long externalId
    Long objectId
    String year
    String title
    String description
    @JsonProperty("schedule_string")
    String schedule
    Genre genre
    Category category
    Map<String, String> pictures
    String virtualObjectId
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy h:mm:ss a")
    Date start
    Long startTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd, yyyy h:mm:ss a")
    Date end
    Long endTimestamp
    //TODO define type
    def groupedPrograms
    //TODO probably enum
    String scheduleType
}
