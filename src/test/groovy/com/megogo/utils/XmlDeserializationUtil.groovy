package com.megogo.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper

//TODO remove this dirty hack after https://github.com/FasterXML/jackson-module-kotlin/issues/91 is done
class XmlDeserializationUtil {
    private static ObjectMapper objectMapper

    static {
        JacksonXmlModule xmlModule = new JacksonXmlModule()
        xmlModule.setDefaultUseWrapper(false)
        objectMapper = new XmlMapper(xmlModule)
    }

    static <T> T deserializeXml(String xml, Class<T> clazz) {
        objectMapper.readValue(xml, clazz)
    }

}
