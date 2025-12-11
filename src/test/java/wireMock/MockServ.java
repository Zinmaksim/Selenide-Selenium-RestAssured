package wireMock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockServ {

    public static void main(String[] args) {
        // Создаем сервер WireMock
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();


        try {
            String wireMockUrl = "http://localhost:8080/api/users"; // Замените на ваш URL
            URL url = new URL(wireMockUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Используйте getInputStream() для успешных ответов
            // И getErrorStream() для ошибок
            BufferedReader in;
            if (responseCode >= 200 && responseCode < 300) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

            }

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Преобразуем StringBuilder в строку
            String responseBody = response.toString();
            System.out.println("Response Body: " + responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

