import br.edu.fameg.ads.research.experiments.Experiment;
//import br.edu.fameg.poo.research.persistence.mysql.MySQLTaxiTrajectoryDAO;
import br.edu.fameg.ads.research.persistence.jdbc.JDBC;
import br.edu.fameg.ads.research.persistence.jdbc.MysqlConenction;
import br.edu.fameg.ads.research.persistence.mongodb.MongoTaxiTrajectoryDAO;


public class Tester {

	public static void main(String[] args) throws Exception{

        Experiment eMongo = new Experiment(new MongoTaxiTrajectoryDAO());
        eMongo.write();
        eMongo.read();
        
        
        MysqlConenction conexao = new MysqlConenction();
        Experiment eMysql = new Experiment(new JDBC(conexao));
        eMysql.write();
        eMysql.read();
    }

}
