package poject;

import javax.persistence.EntityManagerFactory;

import lombok.extern.slf4j.Slf4j;
import poject.DAOs.EventoDAO;
import poject.DAOs.LocationDAO;
import poject.DAOs.PartecipazioneDAO;
import poject.DAOs.PersonaDAO;
import poject.utils.jpaUtil;

@Slf4j
public class Main {

	public static void main(String[] args) {

		/**
		 * NON FUNZIONA PERCHE MANCA LA PASSWORD CONTATTARMI PER RECUPERARLA:
		 * domdat03@gmail.com
		 **/
		System.out.println(
				"**********************************************************************************************");

		System.out.println();
		System.out.println("NON FUNZIONA PERCHE MANCA LA PASSWORD CONTATTAMI PER RECUPERARLA: domdat03@gmail.com");
		System.out.println();
		System.out.println(
				"**********************************************************************************************");
		System.out.println();

		// di seguito il codice
		EntityManagerFactory emf = jpaUtil.getEntityManagerFactory();

		EventoDAO eventoDao = new EventoDAO(emf);
		PersonaDAO personaDao = new PersonaDAO(emf);
		LocationDAO locationDao = new LocationDAO(emf);
		PartecipazioneDAO paDao = new PartecipazioneDAO(emf);

//ESERCIZIO1

//1		
		// eventoDao.getConcertiInStreaming().stream().forEach(c ->
		// System.out.println(c));

//2		
		// eventoDao.getConcertiPerGenere(GenereConcerto.ROCK).stream().forEach(c ->
		// System.out.println(c));

//ESERCIZIO2

//1
		// eventoDao.getPartiteVinteInCasa().stream().forEach(c ->
		// System.out.println(c));
//2
		// eventoDao.getPartiteVinteInTrasferta().stream().forEach(c ->
		// System.out.println(c));

//3
		// eventoDao.getPartitePareggiate().stream().forEach(c ->
		// System.out.println(c));
		emf.close();
	}

}
