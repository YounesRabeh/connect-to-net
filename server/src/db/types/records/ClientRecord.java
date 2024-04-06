package db.types.records;


import template.base.Client;

public record ClientRecord(Client client) {

    //TODO: check if the name or username doesn't contain ','
    public String[] toTuple(){
        return new String[]{
                String.valueOf(client.getID()),
                client.getName(),
                client.getIP(),
                String.valueOf(client.getPortNumber()),
                client.getUsername(),
                client.getFormattedConnectionTime()
        };
    }

}
