package br.edu.fameg.ads.research.persistence.mongodb;



import br.edu.fameg.ads.research.domain.Persistible;
import br.edu.fameg.ads.research.domain.TaxiTrajectory;
import br.edu.fameg.ads.research.utils.Chronometer;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.List;
import com.mongodb.MongoClient;

import java.util.ArrayList;


public class MongoTaxiTrajectoryDAO implements
        Persistible<List<TaxiTrajectory>> {

    private MongoClient mongo;
    private DB db;
    private DBCollection colecao;
  

    public MongoTaxiTrajectoryDAO() {
        mongo = new MongoClient("localhost", 27017);

        mongo.dropDatabase("research");

        db = mongo.getDB("research");

        colecao = db.getCollection("TaxiTrajectory");
        System.out.println("Mongo");
    }

    @Override
    public void save(List<TaxiTrajectory> list) throws Exception{

        List<DBObject> documents = new ArrayList<>();
        for (TaxiTrajectory t : list) {
            
            BasicDBObject dbTaxi = new BasicDBObject();
                dbTaxi.append("TaxiID", t.getTaxiID())
                    .append("DateTime", t.getDateTime())
                    .append("longitude", t.getLongitude())
                    .append("latitude", t.getLatitude());
            documents.add(dbTaxi);
            
          }
        colecao.insert(documents);
    }
    

    @Override
    public void query(List<TaxiTrajectory> list) throws Exception {
        
	for (TaxiTrajectory t : list) {	
            DBObject query = BasicDBObjectBuilder.start().append("latitude", t.getLatitude()).get();
            DBCursor cursor = colecao.find(query);
        
        }
        
    }


}
