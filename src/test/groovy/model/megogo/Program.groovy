package model.megogo

import groovy.transform.Canonical

@Canonical
class Program {
    Long externalid
    Long objectId
    Date year
    String title
    String description
    String schedule
    Genre genre
    Category category
    Map<String, String> pictures
    String virtualObjectId
    Date start
    Long startTs
    Date end
    Long endTs
    def groupedPrograms     //what is this?
    String scheduleType     //enum?
}
