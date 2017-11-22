package common

import configuration.CloudConfiguration
import configuration.OperationsConfiguration
import operations.epg.MegogoEpgOperations
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
    MegogoEpgOperations megogoEpgOperations
}
