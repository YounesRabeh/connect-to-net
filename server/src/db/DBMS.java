package db;


import db.records.ClientRecord;

import java.io.IOException;

import static db.DbTools.*;
import static explorer.CsvTools.addToCsvFile;

public final class DBMS implements DbInfo {
    private DBMS(){}

    private static Clients CLIENTS;

    public static void init(){
        //TODO: create for the rest
        CLIENTS = Clients.get();

    }


    public static void add(ClientRecord record) {
        try {
            String[] tuple = record.toTuple();
            addToCsvFile(ALL_CLIENTS, tuple);
            addToCsvFile(getClientDbDestination(record), tuple);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
