package com.megogo

import com.megogo.configuration.CloudConfiguration
import com.megogo.configuration.OperationsConfiguration
import com.megogo.operations.epg.MegogoEpgOperations
import com.megogo.operations.common.SessionAttributes
import com.megogo.operations.epg.VseTvEpgOperations
import org.junit.After
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = [
    CloudConfiguration,
    OperationsConfiguration
])
class BaseTest {

    @Autowired
    private SessionAttributes sessionAttributes

    @Autowired
    MegogoEpgOperations megogoEpgOperations

    @Autowired
    VseTvEpgOperations vseTvEpgOperations

    @After
    void cleanup() {
        sessionAttributes.clearAllAttributes()
    }
}
