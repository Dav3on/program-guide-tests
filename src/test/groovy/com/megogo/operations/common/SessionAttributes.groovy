package com.megogo.operations.common

import com.megogo.model.megogo.MegogoProgramGuide
import com.megogo.model.vsetv.VseTvProgramGuide
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
class SessionAttributes {
    private Map SESSION_ATTRIBUTES = [:]

    private static final String MEGOGO_EPG_KEY = "megogo_epg"
    private static final String VSETV_EPG_KEY = "vsetv_epg"

    void addMegogoEpg(MegogoProgramGuide programGuide) {
        addAttribute(MEGOGO_EPG_KEY, programGuide)
    }

    void addVseTvEpg(VseTvProgramGuide programGuide) {
        addAttribute(VSETV_EPG_KEY, programGuide)
    }

    MegogoProgramGuide getMegogoEpg() {
        getAttribute(MEGOGO_EPG_KEY) as MegogoProgramGuide
    }

    VseTvProgramGuide getVseTvEpg() {
        getAttribute(VSETV_EPG_KEY) as VseTvProgramGuide
    }

    void clearAllAttributes() {
        SESSION_ATTRIBUTES.clear()
        log.info("SESSION_ATTRIBUTES is cleared")
    }

    private void addAttribute(String key, def value) {
        assert key : "Key is empty!"
        assert value!=null : "Received object by key: $key has null value!"
        SESSION_ATTRIBUTES.put(key, value)
        log.info(">> Attribute by key: $key is added to SESSION_ATTRIBUTES with value: $value")
    }

    private def getAttribute(String key) {
        assert key : "Key is empty!"
        def value = SESSION_ATTRIBUTES.get(key)
        log.info("<< Attribute by key: $key is got from SESSION_ATTRIBUTES with value: $value")
        value
    }
}
