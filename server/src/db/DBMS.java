package db;


import db.types.records.ClientRecord;
import db.types.records.RouteRecord;

import java.io.IOException;

import static db.DbTools.*;
import static explorer.CsvTools.addToCsvFile;

public class DBMS implements DbInfo {

    public static void add(ClientRecord record) throws IOException {
        addToCsvFile(getClientDbDestination(record), record.toTuple());
    }


}
