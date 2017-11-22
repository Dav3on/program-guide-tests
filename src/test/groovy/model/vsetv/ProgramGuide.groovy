package model.vsetv

import groovy.transform.Canonical

@Canonical
class ProgramGuide {
    Channel channel
    List<Program> programList
}
