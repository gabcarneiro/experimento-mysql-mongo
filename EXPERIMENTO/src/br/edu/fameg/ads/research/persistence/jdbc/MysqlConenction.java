package br.edu.fameg.ads.research.persistence.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConenction {

    private Connection connection;

    private final String URL ="jdbc:mysql://localhost:3306/research?rewriteBatchedStatements=true";

    private final String USER = "root";

    private final String PASSWORD = "691007";

    private final String TPCONEXAO = "com.mysql.jdbc.Driver";



    public Connection abrir(){
        try{
            Class.forName(TPCONEXAO);
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }


    public void fechar(){
        if (connection != null){
            try{
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
    

}
