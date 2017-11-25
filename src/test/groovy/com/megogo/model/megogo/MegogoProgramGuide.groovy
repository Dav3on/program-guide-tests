package com.megogo.model.megogo

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import groovy.transform.Canonical

@Canonical
@JsonDeserialize
class MegogoProgramGuide {
    String result
    @JsonProperty("data")
    List<ProgramGuide> programGuides
}
