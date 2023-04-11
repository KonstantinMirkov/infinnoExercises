package serversExamples.httpPost;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPost {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        String json = """
                {
                "email": example3@example.com",
                "firstName": "John3",
                lastName": "Doe3",
                "phone": "+359883123454",
                "password": "mypassworh"
                }
                """;

        HttpRequest request = HttpRequest
                .newBuilder(URI.create("https://d.infn.dev/irispay-app/api/user/register"))
                .POST(HttpRequest.BodyPublishers.ofString(json)).header("Content-Type", "application/json").build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode() + " : " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
