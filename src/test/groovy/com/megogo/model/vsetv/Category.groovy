package com.megogo.model.vsetv

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText
import groovy.transform.Canonical

@Canonical
class Category {
    @JacksonXmlProperty(isAttribute = true)
    String lang
    @JacksonXmlText
    String text
}
