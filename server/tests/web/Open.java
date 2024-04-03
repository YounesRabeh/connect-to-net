package web;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Open{
    public static void main(String[] args) {
        String url = "http://localhost:8080"; // Replace this with your server URL

        try {
            // Check if the Desktop class is supported
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                // Open the specified URL in the default browser
                desktop.browse(new URI(url));
            } else {
                System.out.println("Desktop class is not supported on this platform.");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
