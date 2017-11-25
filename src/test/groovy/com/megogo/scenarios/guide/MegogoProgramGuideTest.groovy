package com.megogo.scenarios.guide

import com.megogo.BaseTest
import org.junit.Test

class MegogoProgramGuideTest extends BaseTest {

    @Test
    void "should return same program guide as vseTv returns"() {
        //Given
        long vseTvChanelId = 3
        long megogoChanelId = 295

        //When
        vseTvEpgOperations.getProgramGuideByChanelId(vseTvChanelId)
        megogoEpgOperations.getProgramGuideByChanelId(megogoChanelId)

        //Then
        megogoEpgOperations.verifyAllProgramsPresentInVseTvResponse()
    }
}
