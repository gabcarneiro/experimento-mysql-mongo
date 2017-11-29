package br.edu.fameg.ads.research.experiments;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.edu.fameg.ads.research.domain.Persistible;
import br.edu.fameg.ads.research.domain.TaxiTrajectory;
import br.edu.fameg.ads.research.utils.Chronometer;
import br.edu.fameg.ads.research.utils.FileUtils;



public class Experiment {
	
	private List<TaxiTrajectory> lista = new ArrayList<TaxiTrajectory>();
	private Persistible<List<TaxiTrajectory>> tDAO;
	

	public Experiment(Persistible<List<TaxiTrajectory>> tDAO){
		this.tDAO = tDAO;
	}
	
        
	public void write() throws Exception{
		FileUtils fu = new FileUtils();
		String[] arquivos = fu.getFileNames();
		for (int i = 0; i < arquivos.length; i++) {
			try {
				lista.addAll(fu.readFile(arquivos[i]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}	
		System.out.println(lista.size()+" trajectories");
		Chronometer.start();
		tDAO.save(lista);
		Chronometer.stop();
		System.out.println(Chronometer.elapsedTimeInMiliseconds()+ " milisseconds -> write operation.");
	}


	public void read() throws Exception{
		List<TaxiTrajectory> aleatoryList = new ArrayList<TaxiTrajectory>();

		
		for(int i=0; i < 10; i++){
			Collections.shuffle(lista);
			aleatoryList.add(lista.get(i));
		}
		
		Chronometer.start();
		tDAO.query(aleatoryList);		
		Chronometer.stop();
		System.out.println(Chronometer.elapsedTimeInMiliseconds()+ " milisseconds -> read operation.");
		System.out.println("_________________");
	}
	
	

}
