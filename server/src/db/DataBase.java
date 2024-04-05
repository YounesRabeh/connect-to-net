package db;

public abstract class DataBase implements Constrains {
    private static Integer idPoll = 0;
    public static Integer assignID(){
        return idPoll++;
    }
}
