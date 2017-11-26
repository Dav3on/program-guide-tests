package com.megogo.model.vsetv

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import groovy.transform.Canonical

@Canonical
class VseTvProgram {
    @JacksonXmlProperty(isAttribute = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z")
    Date start
    @JacksonXmlProperty(isAttribute = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z")
    Date stop
    @JacksonXmlProperty(localName = "channel", isAttribute = true)
    Long channelId
    @JacksonXmlProperty(localName = "programme_id", isAttribute = true)
    Long programId
    @JacksonXmlProperty(localName = "genre_id", isAttribute = true)
    Long genreId
    @JacksonXmlProperty(localName = "category_id", isAttribute = true)
    Long categoryId
    Long id
    Date date
    Title title
    Category category
    Genre genre
    @JacksonXmlProperty(localName = "desc")
    Description description
    @JacksonXmlProperty(localName = "longdesc")
    Description longDescription
    @JacksonXmlProperty(localName = "season-num")
    Long seasonNum
    @JacksonXmlProperty(localName = "episode-num")
    String episodeNum   //Don't switch to Long! Sometimes value might be something like "5 и 6"
    @JacksonXmlProperty(localName = "production_year")
    String productionYear
    String parental
    String image
    @JacksonXmlProperty(localName = "megogo_id")
    Long megogoId
    @JacksonXmlProperty(localName = "kinopoisk_id")
    Long kinopoiskId
}
