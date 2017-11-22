package clients

import javax.naming.OperationNotSupportedException


abstract class AbstractHttpClient implements HttpClient {

    @Override
    def doGet(String url) {
        new URL(url).getText()
    }

    @Override
    def doPost(String url, Map<String, String> params, Map<String, String> headers) {
        throw new OperationNotSupportedException("Not implemented yet")
    }
}
