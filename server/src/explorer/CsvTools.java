package explorer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CsvTools {
    private CsvTools() {}

    public static void addToCsvFile(String filePath, String[] rowData) throws IOException {
        FileManager.addToFile(filePath, String.join(",", rowData) + "\n");
    }

    public static List<String[]> readCsv(String filePath) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        String fileContent = FileManager.readFile(filePath);
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            csvData.add(line.split(","));
        }
        return csvData;
    }

    public static String[] getRow(String filePath, int index) throws IOException {
        String fileContent = FileManager.getLine(filePath, index);
        if (fileContent != null) {
            return fileContent.split(",");
        }
        return null; // Index out of bounds
    }

    public static List<String[]> getRowsBelow(String filePath, int index) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        List<String> lines = FileManager.getLinesBelow(filePath, index);
        for (String line : lines) {
            csvData.add(line.split(","));
        }
        return csvData;
    }

    public static List<String[]> getRowsAbove(String filePath, int index) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        List<String> lines = FileManager.getLinesAbove(filePath, index);
        for (String line : lines) {
            csvData.add(line.split(","));
        }
        return csvData;
    }

    public static boolean createEmptyCsvFile(String filePath) throws IOException {
        return FileManager.createEmptyFile(filePath);
    }

    public static boolean createEmptyCsvFileIfNotExists(String filePath) throws IOException {
        return FileManager.createEmptyFileIfNotExists(filePath);
    }

    public static List<String> getColumn(String filePath, int columnIndex) throws IOException {
        List<String[]> csvData = readCsv(filePath);
        List<String> columnData = new ArrayList<>();
        for (String[] row : csvData) {
            if (row.length > columnIndex) {
                columnData.add(row[columnIndex]);
            } else {
                columnData.add(""); // Fill with empty string if column doesn't exist in the row
            }
        }
        return columnData;
    }

    public static List<List<String>> getColumns(String filePath, int... columnIndices) throws IOException {
        List<List<String>> columnsData = new ArrayList<>();
        List<String[]> csvData = readCsv(filePath);
        for (int columnIndex : columnIndices) {
            List<String> columnData = new ArrayList<>();
            for (String[] row : csvData) {
                if (row.length > columnIndex) {
                    columnData.add(row[columnIndex]);
                } else {
                    columnData.add(""); // Fill with empty string if column doesn't exist in the row
                }
            }
            columnsData.add(columnData);
        }
        return columnsData;
    }

    public static void appendRow(String filePath, String[] rowData) throws IOException {
        StringBuilder rowString = new StringBuilder();
        for (String data : rowData) {
            rowString.append(data).append(",");
        }
        // Remove the trailing comma
        rowString.deleteCharAt(rowString.length() - 1);
        rowString.append("\n");
        FileManager.addToFile(filePath, rowString.toString());
    }

    public static void insertRow(String filePath, int index, String[] rowData) throws IOException {
        List<String> lines = new ArrayList<>(List.of(FileManager.readFile(filePath).split("\n")));
        if (index < 0 || index > lines.size()) {
            throw new IllegalArgumentException("Invalid index for inserting row");
        }
        StringBuilder rowString = new StringBuilder();
        for (String data : rowData) {
            rowString.append(data).append(",");
        }
        // Remove the trailing comma
        rowString.deleteCharAt(rowString.length() - 1);
        rowString.append("\n");
        lines.add(index, rowString.toString());
        FileManager.overrideFile(filePath, String.join("", lines));
    }

    public static void deleteRow(String filePath, int index) throws IOException {
        List<String> lines = new ArrayList<>(Arrays.asList(FileManager.readFile(filePath).split("\n")));
        if (index < 0 || index >= lines.size()) {
            throw new IllegalArgumentException("Invalid index for deleting row");
        }
        lines.remove(index);
        FileManager.overrideFile(filePath, String.join("\n", lines));
        FileManager.addToFile(filePath, "\n");
    }

    public static void appendColumn(String filePath, String[] columnData) throws IOException {
        List<String[]> csvData = readCsv(filePath);
        if (csvData.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }
        if (columnData.length != csvData.size()) {
            throw new IllegalArgumentException("Number of rows in column data must match number of rows in CSV file");
        }
        StringBuilder fileContent = new StringBuilder();
        for (int i = 0; i < csvData.size(); i++) {
            csvData.get(i)[csvData.get(i).length - 1] += "," + columnData[i];
            fileContent.append(String.join(",", csvData.get(i))).append("\n");
        }
        FileManager.overrideFile(filePath, fileContent.toString());
    }

    public static void insertColumn(String filePath, int index, String[] columnData) throws IOException {
        List<String[]> csvData = readCsv(filePath);
        if (csvData.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }
        if (index < 0 || index >= csvData.getFirst().length) {
            throw new IllegalArgumentException("Invalid index for inserting column");
        }
        if (columnData.length != csvData.size()) {
            throw new IllegalArgumentException("Number of rows in column data must match number of rows in CSV file");
        }
        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            String[] newRow = new String[row.length + 1];
            System.arraycopy(row, 0, newRow, 0, index);
            System.arraycopy(row, index, newRow, index + 1, row.length - index);
            newRow[index] = columnData[i];
            csvData.set(i, newRow);
        }
        StringBuilder fileContent = new StringBuilder();
        for (String[] row : csvData) {
            fileContent.append(String.join(",", row)).append("\n");
        }
        FileManager.overrideFile(filePath, fileContent.toString());
    }

    public static void deleteColumn(String filePath, int index) throws IOException {
        List<String[]> csvData = readCsv(filePath);
        if (csvData.isEmpty()) {
            throw new IllegalArgumentException("CSV file is empty");
        }
        if (index < 0 || index >= csvData.getFirst().length) {
            throw new IllegalArgumentException("Invalid index for deleting column");
        }
        for (String[] row : csvData) {
            List<String> rowData = new ArrayList<>(Arrays.asList(row));
            rowData.remove(index);
            row = rowData.toArray(new String[0]);
        }
        StringBuilder fileContent = new StringBuilder();
        for (String[] row : csvData) {
            fileContent.append(String.join(",", row)).append("\n");
        }
        FileManager.overrideFile(filePath, fileContent.toString());
    }
}
