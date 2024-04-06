package db;

import db.types.records.ClientRecord;

import java.util.NoSuchElementException;

public final class DbTools implements DbInfo {
    private DbTools(){}

    static String getClientDbDestination(ClientRecord record){
        for (String destination: CLIENTS_DATABASES){
            String recordName =  record.client().getClass().getName();
            int startIndex = destination.indexOf(CLIENTS_DB_DIR + "/") + CLIENTS_DB_DIR.length();
            if (destination.substring(startIndex, recordName.indexOf(DB_FILE_SEPARATOR)).equalsIgnoreCase(recordName)){
                return CLIENTS_DATABASES.get(CLIENT_TYPES.indexOf(destination));
            }
        }
        throw new NoSuchElementException("No database for " + record.getClass().getName() + " in " + CLIENTS_DB_DIR);
    }






}
