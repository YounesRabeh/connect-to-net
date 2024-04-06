package db;


import db.records.ClientRecord;
import rules.ClientType;
import template.base.Client;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static db.DbTools.*;
import static explorer.CsvTools.addToCsvFile;
import static explorer.CsvTools.appendRow;

public final class DBMS implements DbInfo {
    private DBMS(){}

    //TODO: set a readable id to clients [primary key]

    private volatile static List<Integer> releasedIDs = new LinkedList<Integer>();
    private static int ID_bound = 0;

    public static int assignClientId(){
        return releasedIDs.isEmpty() ? ID_bound++ : releasedIDs.removeFirst();
    }

    public static void removeClient(Client client){
        try {
            removeTuple(client.getClientType(), client.getID());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        releaseClientID(client);
    }

    private static void releaseClientID(Client client){
        releasedIDs.add(client.getID());
    }

    private static Clients CLIENTS;

    public static void init(){
        //TODO: create for the rest
        CLIENTS = Clients.get();
    }

    //Todo: get the data base Clienttypoe -> database


    public static void add(ClientRecord record) {
        try {
            String[] tuple = record.toTuple();
            appendRow(ALL_CLIENTS, tuple);
            appendRow(getClientDbDestination(record), tuple);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
