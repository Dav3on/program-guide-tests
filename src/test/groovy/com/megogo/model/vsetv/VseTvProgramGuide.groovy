package com.megogo.model.vsetv

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import groovy.transform.Canonical

@Canonical
@JacksonXmlRootElement(localName = "tv")
class VseTvProgramGuide {
    @JacksonXmlProperty(localName = "source-info-url", isAttribute = true)
    String sourceInfoUrl
    @JacksonXmlProperty(localName = "source-info-name", isAttribute = true)
    String sourceInfoName
    @JacksonXmlProperty(localName = "generator-info-url", isAttribute = true)
    String generatorInfoUrl
    Channel channel
    @JacksonXmlProperty(localName = "programme")
    List<VseTvProgram> programs

    List<VseTvProgram> findProgramsInTimerange(Date start, Date end) {
        this.programs.findAll { program ->
            program.start >= start  && program.start <= end }
    }
}
