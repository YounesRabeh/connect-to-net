package db.types;

import db.DBMS;
import db.Database;
import db.types.records.ClientRecord;

import java.io.IOException;


final class Clients extends Database<ClientRecord> {

    private static final class InstanceHolder {
        private static final Clients instance = new Clients();
    }

    static Clients get() {
        return InstanceHolder.instance;
    }

    private Clients() {
        super("admin", "password");
        createDatabase();
    }

    @Override
    public void addRecord(ClientRecord record) {
        try {
            DBMS.add(record);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeRecord(ClientRecord record) {

    }

    @Override
    protected void createTables() {

    }
}


