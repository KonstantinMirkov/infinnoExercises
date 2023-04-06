package serversExamples.HTTPClientExample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HTTPClientExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://d.infn.dev/irispay-app/api/user/register");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            String json = "{"
                    + "\"email\":\"example2@example.com\","
                    + "\"firstName\":\"John2\","
                    + "\"lastName\":\"Doe2\","
                    + "\"phone\":\"+359887123457\","
                    + "\"password\":\"mypasswort\""
                    + "}";

            try (OutputStream outputStream = httpURLConnection.getOutputStream();
                 OutputStreamWriter outputStreamWriter =
                         new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
                outputStreamWriter.write(json);
            }

            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);

            try (BufferedReader bufferedReader =
                         new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
