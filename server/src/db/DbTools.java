package db;

import db.records.ClientRecord;

import java.util.NoSuchElementException;

final class DbTools implements DbInfo {
    private DbTools(){}

    static String getClientDbDestination(ClientRecord record){
        int destinationIndex = 0;
        //FIXME: make it more efficient
        for (String destination: CLIENTS_DATABASES){
            int startIndex = destination.indexOf(CLIENTS_DB_DIR + "/") + CLIENTS_DB_DIR.length();
            String dbLocalDestination = destination.substring(startIndex);
            String dbLocalDestinationType = dbLocalDestination.substring(1, dbLocalDestination.indexOf(DB_FILE_SEPARATOR));
            String clientType = record.client().getClientType().toString();
            if (dbLocalDestinationType.contains(clientType)){
                return CLIENTS_DATABASES.get(CLIENT_TYPES.indexOf(destinationIndex));
            }
            destinationIndex += 1;
        }
        throw new NoSuchElementException("No database for " + record.getClass().getSimpleName() + " in " + CLIENTS_DB_DIR);
    }






}
