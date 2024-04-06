package db;

import explorer.PathResolver;

import java.util.List;

public interface DbInfo {
    String DB_DIR           = PathResolver.getJarDirectory() + "/DB";
    String CLIENTS_DB_DIR   = DB_DIR + "/Clients";
    String ROUTING_DB_DIR   = DB_DIR + "/Routing";
    String BLACKLIST_DB_DIR = DB_DIR + "/Blacklist";

    List<String> DATABASES_DIR = List.of(new String[]{
            CLIENTS_DB_DIR,
            ROUTING_DB_DIR,
            BLACKLIST_DB_DIR
    });

    //////////////////////////////////////////////////////////////

    List<String> CLIENT_TYPES = List.of(new String[]{"BASIC", "SUPER", "ADMIN"});
    String DB_FILE_SEPARATOR = "-";
    String DB_FILE_CLIENTS_ENDING = "Clients.csv";

    String ALL_CLIENTS       = CLIENTS_DB_DIR + "/ALL-Clients.csv";

    String BASIC_CLIENTS     = CLIENTS_DB_DIR + "/" + CLIENT_TYPES.getFirst()
            + DB_FILE_SEPARATOR + DB_FILE_CLIENTS_ENDING;
    String SUPER_CLIENTS     = CLIENTS_DB_DIR + "/" + CLIENT_TYPES.get(1)
            + DB_FILE_SEPARATOR + DB_FILE_CLIENTS_ENDING;
    String ADMIN_CLIENTS     = CLIENTS_DB_DIR + "/" + CLIENT_TYPES.get(2)
            + DB_FILE_SEPARATOR + DB_FILE_CLIENTS_ENDING;

    List<String> CLIENTS_DATABASES = List.of(new String[]{
            ALL_CLIENTS,
            BASIC_CLIENTS,
            SUPER_CLIENTS,
            ADMIN_CLIENTS
    });








}
