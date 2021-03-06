package DesktopAplication.predavanje3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> unavailableConnections = new ArrayList<>();

    public ConnectionPool() throws SQLException{
        int NUMBER_OF_CONNECTIONS = 10;
        for(int i = 0; i< NUMBER_OF_CONNECTIONS; i++){
            Connection connection = createConnection();
            availableConnections.add(connection);
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(ConnectionProperties.URL.getValue(), ConnectionProperties.USERNAME.getValue(), ConnectionProperties.PASSWORD.getValue());
    }

    public Connection getConnection(){
        if(availableConnections.isEmpty()){
            throw new RuntimeException("Nemam ti dostupnih konekcija");
        }else{
            Connection connection = availableConnections.get(availableConnections.size()-1);
            availableConnections.remove(connection);
            unavailableConnections.add(connection);
            return connection;
        }
    }

    public boolean releaseConnection(Connection connection){
        if(null != connection){
            unavailableConnections.remove(connection);
            availableConnections.add(connection);
            return true;
        }else{
            return false;
        }
    }
}
