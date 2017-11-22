package model.megogo

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonNaming
import groovy.transform.Canonical

@Canonical
@JsonDeserialize
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy)
class Category {
    Long id
    Long externalId
    String title
}
