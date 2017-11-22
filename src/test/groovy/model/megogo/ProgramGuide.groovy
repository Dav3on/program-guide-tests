package model.megogo

import groovy.transform.Canonical

@Canonical
class ProgramGuide {
    Long id
    Long externalId
    String title
    List<Program> programList
    Map<String, String> pictures
}
