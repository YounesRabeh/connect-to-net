package db;

import db.records.ClientRecord;


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
    protected void addRecord(ClientRecord record) {
        DBMS.add(record);
    }

    @Override
    protected void removeRecord(ClientRecord record) {

    }

    @Override
    protected void createTables() {

    }
}


