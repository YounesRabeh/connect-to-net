package db;


public final class DataBaseManager {
    private static Integer idPoll = 0;


    public static Integer getAnID(){
        return idPoll++;
    }

}
