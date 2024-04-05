package db.types;

import db.Database;
import db.types.records.ClientRecord;


public final class Clients extends Database<ClientRecord> {
    public Clients() {
        super("admin", "password");
        createDatabase();
    }

    @Override
    protected void createTables() {

    }
}


