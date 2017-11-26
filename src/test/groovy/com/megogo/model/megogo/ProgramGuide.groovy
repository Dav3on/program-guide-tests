package com.megogo.model.megogo

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming
import groovy.transform.Canonical

@Canonical
@JsonDeserialize
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy)
class ProgramGuide {
    Long id
    Long externalId
    String title
    List<MegogoProgram> programs
    Map<String, String> pictures
}
