package explorer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PathResolver {
    private PathResolver() {}

    public static String getJarDirectory() {
        Path jarPath = null;
        try {
            // Get the path of the JAR file being executed
            String jarFilePath = PathResolver.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath();
            jarPath = Paths.get(jarFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If JAR path is null or empty, return current directory
        if (jarPath == null || jarPath.toString().isEmpty()) {
            return Paths.get("").toAbsolutePath().toString();
        }
        // Return the directory of the JAR file
        return jarPath.getParent().toString();
    }

    public static String getFilePath(String fileName, String directory) {
        return Paths.get(directory, fileName).toString();
    }

    public static boolean pathExists(String path) {
        return Files.exists(Paths.get(path));
    }

    public static boolean createDirectory(String directoryPath) {
        try {
            Path directory = Paths.get(directoryPath);
            if (Files.exists(directory)) {
                return true; // Directory already exists
            }
            Files.createDirectory(directory);
            return true; // Directory created successfully
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Failed to create directory
        }
    }

}
