package com.megogo

import com.megogo.configuration.CloudConfiguration
import com.megogo.configuration.OperationsConfiguration
import com.megogo.operations.common.SessionAttributes
import com.megogo.operations.epg.MegogoEpgOperations
import com.megogo.operations.epg.VseTvEpgOperations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [
        CloudConfiguration,
        OperationsConfiguration
])
class BaseTest extends Specification {

    @Autowired
    private SessionAttributes sessionAttributes

    @Autowired
    MegogoEpgOperations megogoEpgOperations

    @Autowired
    VseTvEpgOperations vseTvEpgOperations

    void cleanup() {
        sessionAttributes.clearAllAttributes()
    }
}
