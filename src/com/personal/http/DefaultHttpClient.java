package com.personal.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class DefaultHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> data) {
        try {
            final URI uri = new URI(url);
            final HttpClient client = HttpClient.newHttpClient();

            // Aqui pode usar GSON ou Jackson para converter Map para String Json
            final String body = """
                    {
                        "quote":"123",
                        "value":99.99,
                        "quantity":2
                    }
                    """;

            final HttpRequest request = HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(body)).build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
