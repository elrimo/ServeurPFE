package  com.pfe.localisation.dao;

import java.util.List;

import com.pfe.localisation.object.Etage;



public interface EtageDao {

	void persistEtage(Etage etage);
	Etage findEtageById(int id);
	List<Etage> findAll();
	void updateEtage(Etage etage);
	void deleteEtage(Etage etage);

}
