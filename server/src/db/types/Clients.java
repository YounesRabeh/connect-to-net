package db.types;

import db.DBMS;
import db.Database;
import db.types.records.ClientRecord;


public final class Clients extends Database<ClientRecord> {

    private static final class InstanceHolder {
        private static final Clients instance = new Clients();
    }

    public static Clients get() {
        return InstanceHolder.instance;
    }
    private Clients() {
        super("admin", "password");
        createDatabase();
    }

    @Override
    public void addRecord(ClientRecord record) {
        DBMS.add(record);
    }

    @Override
    public void removeRecord(ClientRecord record) {

    }

    @Override
    protected void createTables() {

    }
}


