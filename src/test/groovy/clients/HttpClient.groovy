package clients


interface HttpClient {

    def doGet(String url)

    def doPost(String url, Map<String, String> params, Map<String, String> headers)

}