package com.megogo.scenarios.guide

import com.megogo.BaseTest
import com.megogo.enums.MegogoChannel
import com.megogo.enums.VseTvChannel
import spock.lang.Unroll

class MegogoProgramGuideTest extends BaseTest {

    @Unroll
    void "should return same programs for Megogo channelId: #megogoChannelId and VseTv channelId: #vseTvChannelId"() {
        when:
        vseTvEpgOperations.getProgramGuideByChannelId(vseTvChannelId)
        megogoEpgOperations.getProgramGuideByChannelId(megogoChannelId)

        then:
        megogoEpgOperations.verifyMegogoProgramsAreEqualToVseTv()

        where:
        megogoChannelId               | vseTvChannelId
        MegogoChannel.ONE_PLUS_ONE.id | VseTvChannel.ONE_PLUS_ONE.id
    }

    void "should support integration with other provider"() {
        when:
        boolean placeholder = true

        then:
        placeholder
    }
}
