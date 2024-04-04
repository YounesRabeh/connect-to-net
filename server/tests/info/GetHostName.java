package info;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetHostName {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            System.out.println("Host Name: " + hostName);
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine local host name: " + e.getMessage());
        }
    }
}

