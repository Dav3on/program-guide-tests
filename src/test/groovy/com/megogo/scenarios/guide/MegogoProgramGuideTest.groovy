package com.megogo.scenarios.guide

import com.megogo.BaseTest

class MegogoProgramGuideTest extends BaseTest {

     void "should return same program guide as vseTv returns"() {
        given:
        long vseTvChanelId = 3
        long megogoChanelId = 295

        when:
        vseTvEpgOperations.getProgramGuideByChanelId(vseTvChanelId)
        megogoEpgOperations.getProgramGuideByChanelId(megogoChanelId)

        then:
        megogoEpgOperations.verifyMegogoProgramsAreEqualToVseTv()
    }
}
