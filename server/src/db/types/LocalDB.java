package db.types;

public final class LocalDB {
    private static Clients CLIENTS;

    private LocalDB(){}

    public static void init(){
        CLIENTS = Clients.get();

    }

}
