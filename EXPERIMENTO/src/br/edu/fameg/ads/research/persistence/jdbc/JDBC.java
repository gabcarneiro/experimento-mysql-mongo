package br.edu.fameg.ads.research.persistence.jdbc;

import java.sql.*;

import java.util.List;
import br.edu.fameg.ads.research.domain.Persistible;
import br.edu.fameg.ads.research.domain.TaxiTrajectory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class JDBC implements Persistible<List<TaxiTrajectory>> {

    private Connection connection;
    private MysqlConenction conexao;

    public JDBC(MysqlConenction conexao) throws Exception{
        System.out.println("MySQL");
        this.conexao = conexao;
        
    }


    @Override
    public void save(List<TaxiTrajectory> taxiTrajectory) throws Exception {
        connection = conexao.abrir();
        connection.setAutoCommit(false);
        
        DateFormat dateFormatYMD = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        String sql = "insert into TaxiTrajectory (taxiID, latitude, longitude, dateTime) "
                + "values(?,?,?,?)";
        
        PreparedStatement pstmt = connection.prepareStatement(sql);
  
        final int batchSize = 1000;
        int count = 0;
        int size = taxiTrajectory.size();
        
        for (TaxiTrajectory tt : taxiTrajectory){
            pstmt.setLong(1, tt.getTaxiID());
            pstmt.setDouble(2, tt.getLatitude());
            pstmt.setDouble(3, tt.getLongitude());
            pstmt.setDate(4, new java.sql.Date(tt.getDateTime().getTime()));
            pstmt.addBatch();


            if(++count % batchSize == 0 || count == size) {
		pstmt.executeBatch();
            }
        }
        connection.commit();
        pstmt.close();
        conexao.fechar();

    }

    
        @Override
        public void query(List<TaxiTrajectory> list) throws Exception{
        connection = conexao.abrir();
        Statement sta = connection.createStatement();
        for (TaxiTrajectory tt : list) {
                sta.executeQuery("select * "
                        + "from TaxiTrajectory "
                        + "where latitude =  " + tt.getLatitude() + ""
                                + "and longitude = " + tt.getLongitude() );
        }
        conexao.fechar();        
    }



}



