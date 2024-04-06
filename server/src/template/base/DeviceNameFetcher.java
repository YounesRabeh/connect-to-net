package template.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeviceNameFetcher {

    public static String getDeviceName(String ipAddress) {
        String urlStr = "http://" + ipAddress; // Construct URL using the provided IP address

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Get the device name from the response headers
                String serverName = connection.getHeaderField("Server");

                // Alternatively, read the HTML content and search for the device name
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    // Search for the device name in the HTML content
                    // Example: If the device name is in a <title> tag
                    if (line.contains("<title>")) {
                        String deviceName = line.substring(line.indexOf("<title>") + 7, line.indexOf("</title>"));
                        reader.close();
                        return deviceName;
                    }
                }
                reader.close();

                // Return the server name if device name is not found in HTML
                return serverName;
            } else {
                System.out.println("Failed to fetch device information. Response code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return null if unable to fetch device name
        return null;
    }
}
