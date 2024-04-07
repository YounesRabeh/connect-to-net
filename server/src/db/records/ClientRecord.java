package db.records;


import template.base.Client;

public record ClientRecord(Client client) {

    //TODO: check if the name or username doesn't contain ','
    public String[] toTuple(){
        return new String[]{
                String.valueOf(client.getID()),
                client.getName(),
                client.getUsername(),
                String.valueOf(client.getClientType()),
                client.getIP(),
                String.valueOf(client.getPortNumber()),
                client.getFormattedConnectionTime()
        };
    }

}
