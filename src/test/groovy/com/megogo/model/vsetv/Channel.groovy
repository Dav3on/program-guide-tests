package com.megogo.model.vsetv

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import groovy.transform.Canonical

@Canonical
class Channel {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    Long id
    @JacksonXmlProperty(localName = "display-name")
    String displayName
}
