package db;


import db.records.ClientRecord;
import template.base.Client;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static db.DbTools.*;
import static explorer.CsvTools.addToCsvFile;

public final class DBMS implements DbInfo {
    private DBMS(){}

//    private static List<Integer> liveClient = new LinkedList<Integer>();
//    public static int assignClientId(Client client){
//        int id;
//        try {
//            if (liveClient.isEmpty()){
//                id = getTupleNumber(client);
//            } else {
//                id = liveClient.removeFirst();
//            }
//        } catch (IOException e) {throw new RuntimeException(e);}
//        return id;
//    }

//    public static void releaseClientID(int id){
//        liveClient.add(id);
//    }

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
