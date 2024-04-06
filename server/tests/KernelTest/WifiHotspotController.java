package KernelTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WifiHotspotController {

    public static void main(String[] args) {
        try {
            // Execute nmcli command to turn on WiFi hotspot
            Process process = new ProcessBuilder("nmcli", "device", "wifi", "hotspot", "ssid", "MyHotspot", "password", "MyPassword").start();

            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for process to complete
            process.waitFor();

            System.out.println("WiFi hotspot turned on successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
