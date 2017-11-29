package br.edu.fameg.ads.research.domain;

public interface Persistible <T>{
    
	public void save (T t) throws Exception;
	     
        public void query(T t) throws Exception;


}
