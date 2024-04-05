package explorer;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public final class FileManager {
    private FileManager() {}

    public static void addToFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        }
    }

    public static void overrideFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static String getLine(String filePath, int index) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (currentIndex == index) {
                    return line;
                }
                currentIndex++;
            }
        }
        return null; // Index out of bounds
    }

    public static List<String> getLinesBelow(String filePath, int index) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentIndex = 0;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (currentIndex == index) {
                    found = true;
                }
                if (found) {
                    lines.add(line);
                }
                currentIndex++;
            }
        }
        return lines;
    }

    public static List<String> getLinesAbove(String filePath, int index) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentIndex = 0;
            while ((line = reader.readLine()) != null) {
                if (currentIndex < index) {
                    lines.add(line);
                } else {
                    break;
                }
                currentIndex++;
            }
        }
        return lines;
    }

    public static boolean createEmptyFile(String filePath) throws IOException {
        File file = new File(filePath);
        return file.createNewFile();
    }
    public static boolean createEmptyFileIfNotExists(String filePath) throws IOException {
        if (!isFilePresent(filePath)) {
            return createEmptyFile(filePath);
        }
        return false; // File already exists
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public static boolean isFilePresent(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static void cloneFile(String filePath) throws IOException {
        File file = new File(filePath);
        String fileName = file.getName();
        String parentDir = file.getParent();

        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        int index = 1;
        File cloneFile;
        do {
            cloneFile = new File(parentDir, baseName + "Clone" + index + "." + extension);
            index++;
        } while (cloneFile.exists());

        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(cloneFile);
             FileChannel inChannel = fis.getChannel();
             FileChannel outChannel = fos.getChannel()) {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
    }

    public static void cloneFile(String filePath, int times) throws IOException {
        for (int i = 0; i < times; i++) {
            cloneFile(filePath);
        }
    }

    public static String getFileExtension(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex == -1) {
            return ""; // No file extension found
        }
        return fileName.substring(lastIndex + 1);
    }
}
