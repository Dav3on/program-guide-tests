package clients.epg

import clients.AbstractHttpClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class VseTvHttpClient extends AbstractHttpClient {
    @Value('${vseTv.epg.baseUrl}')
    String vseTvBaseUrl

    String getProgramGuideByChanelId(long chanelId) {
        doGet("${vseTvBaseUrl}/export/megogo/epg/${chanelId}.xml")
    }
}
