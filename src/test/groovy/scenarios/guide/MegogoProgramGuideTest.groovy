package scenarios.guide

import common.BaseTest
import model.megogo.ProgramGuideResponse
import org.junit.Test


class MegogoProgramGuideTest extends BaseTest {

    @Test
    void "should return same program guide as vseTv returns"() {
        long vseTvChanelId = 3
        long megogoChanelId = 295

        ProgramGuideResponse megogoProgramGuideResponse = megogoEpgOperations.getProgramGuideByChanelId(megogoChanelId)
        assert megogoProgramGuideResponse
    }
}
