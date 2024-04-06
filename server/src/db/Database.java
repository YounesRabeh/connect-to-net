package db;



import java.io.IOException;

import static explorer.FileManager.createEmptyFileIfNotExists;
import static explorer.PathResolver.createDirectory;

abstract class Database<R extends Record> implements DbInfo {
    private static Integer idPool = 0;

    private final String USERNAME;
    private final String PASSWORD;


    public Database(String username, String password) {
        this.USERNAME = username;
        this.PASSWORD = password;

        dbInit();
    }


    protected abstract void addRecord(R record);
    protected abstract void removeRecord(R record);

    public void createDatabase() {
        createTables();
    }

    // Abstract method to create tables and define constraints
    protected abstract void createTables();

    public Integer assignID() {
        return idPool++;
    }

    public void dbInit(){
       dirInit();
       filesInit();
    }

    private void dirInit(){
        for (String s : DATABASES_DIR) {createDirectory(s);}
    }

    private void filesInit() {
        try {
            for (String s : CLIENTS_DATABASES) {createEmptyFileIfNotExists(s);}
        } catch (IOException e) {throw new RuntimeException(e);}
    }

}
