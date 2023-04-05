package serversExamples.UrlConnectionExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://d.infn.dev/wink/user/123456");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            for (int i = 0; ; i++) {
                String headerKey = urlConnection.getHeaderFieldKey(i);
                String headerValue = urlConnection.getHeaderField(i);

                if (headerKey == null && headerValue == null) {
                    break;
                }

                System.out.println(headerKey + " : " + headerValue);
            }

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
