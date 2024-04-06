package KernelTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WifiHotspotController {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        try {
            if (osName.contains("windows")) {
                // Execute netsh command to turn on WiFi hotspot on Windows
                Process process = new ProcessBuilder("netsh", "wlan", "set", "hostednetwork", "mode=allow", "ssid=MyHotspot", "key=MyPassword").start();

                // Read output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for process to complete
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("WiFi hotspot turned on successfully.");
                } else {
                    System.out.println("Failed to turn on WiFi hotspot. Exit code: " + exitCode);
                }
            } else if (osName.contains("linux") || osName.contains("unix")) {
                // Execute nmcli command to turn on WiFi hotspot on Linux
                Process process = new ProcessBuilder("nmcli", "device", "wifi", "hotspot", "ssid", "MyHotspot", "password", "MyPassword").start();

                // Read output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for process to complete
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("WiFi hotspot turned on successfully.");
                } else {
                    System.out.println("Failed to turn on WiFi hotspot. Exit code: " + exitCode);
                }
            } else {
                System.out.println("Unsupported operating system: " + osName);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
