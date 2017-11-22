package operations.epg

import clients.HttpClient

class VseTvEpgOperations {
    HttpClient megogoHttpClient

    VseTvEpgOperations(HttpClient megogoHttpClient) {
        this.megogoHttpClient = megogoHttpClient
    }
}
