package db;

import explorer.PathResolver;

public interface DbInfo {
    String DB_DIR           = PathResolver.getJarDirectory() + "/DB";
    String CLIENTS_DB_DIR   = DB_DIR + "/Clients";
    String ROUTING_DB_DIR   = DB_DIR + "/Routing";
    String BLACKLIST_DB_DIR = DB_DIR + "/Blacklist";

    String ALL_CLIENTS       = CLIENTS_DB_DIR + "/allClients.csv";
    String BASIC_CLIENTS     = CLIENTS_DB_DIR + "/basicClients.csv";
    String SUPER_CLIENTS     = CLIENTS_DB_DIR + "/superClients.csv";
    String ADMIN_CLIENTS     = CLIENTS_DB_DIR + "/adminClients.csv";




}
