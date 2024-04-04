package db;


public final class DataBaseManager {
    private static Integer idPoll;


    public static Integer getAnID(){
        return idPoll++;
    }

}
