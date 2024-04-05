package db;


import java.io.IOException;

import static explorer.FileManager.createEmptyFileIfNotExists;
import static explorer.PathResolver.createDirectory;

public abstract class Database<R extends Record> implements DbSetup {
    private static Integer idPool = 0;

    private final String USERNAME;
    private final String PASSWORD;


    public Database(String username, String password) {
        this.USERNAME = username;
        this.PASSWORD = password;

        dbInit();
    }

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
        createDirectory(CLIENTS_DB_DIR);
        createDirectory(ROUTING_DB_DIR);
        createDirectory(BLACKLIST_DB_DIR);
    }

    private void filesInit() {
        try {
            createEmptyFileIfNotExists(ALL_CLIENTS);
            createEmptyFileIfNotExists(BASIC_CLIENTS);
            createEmptyFileIfNotExists(SUPER_CLIENTS);
            createEmptyFileIfNotExists(ADMIN_CLIENTS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
