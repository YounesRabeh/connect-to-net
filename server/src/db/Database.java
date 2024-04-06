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
        createDirectory(DB_DIR);
        for (final String DIR: DATABASES_DIR) {createDirectory(DIR);}
    }

    private void filesInit() {
        try {
            for (final String DB : CLIENTS_DATABASES) {createEmptyFileIfNotExists(DB);}
        } catch (IOException e) {throw new RuntimeException(e);}
    }

}
