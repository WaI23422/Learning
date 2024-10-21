package packexercise.exercise8;

class Connection{
    private Connection() {};

    public static Connection get(){
        return new Connection();
    }
}

public class ConnectionManager {
    private static Connection[] connections  = {Connection.get(), Connection.get(),Connection.get()};
    private static int i = 0;
    
    public static Connection getConnection() {
        if (i < connections.length) {
            return connections[i++];
        } else {
            return null;
        }
    }
}
