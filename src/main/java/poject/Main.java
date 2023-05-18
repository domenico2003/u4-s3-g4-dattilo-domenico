package poject;

import javax.persistence.EntityManagerFactory;

import lombok.extern.slf4j.Slf4j;
import poject.DAOs.EventoDAO;
import poject.DAOs.PartecipazioneDAO;
import poject.DAOs.PersonaDAO;
import poject.classDatabase.Evento;
import poject.classDatabase.Partecipazione;
import poject.classDatabase.Persona;
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
//		LocationDAO locationDao = new LocationDAO(emf);
		PartecipazioneDAO paDao = new PartecipazioneDAO(emf);
//RICAVO LE LOCATION
//		Location location1 = locationDao.getById("2a7718b9-0d6d-44cc-b248-1ed39159a872");
//		Location location2 = locationDao.getById("5463721f-e6e0-4fa6-bc62-f0750d425d30");
//RICAVO LE PERSONE

		Persona persona1 = personaDao.getById("34274c22-93de-4b83-8b48-187ce0ee4be4");
		Persona persona2 = personaDao.getById("8c72ae9c-83d5-4b80-8939-a54c24378388");

		// persona1.getPartecipazioni().stream().forEach(p -> System.out.println(p));
//RICAVO GLI EVENTI

		Evento evento1 = eventoDao.getById("5294e351-541c-4dec-b9c5-d5a80c79878b");
		Evento evento2 = eventoDao.getById("b1c082d4-929d-48d0-bbe5-672ac4b95786");

//		System.out.println(evento1.getLocation());
//		evento2.getPartecipazioni().stream().forEach(p -> System.out.println(p.getPersona()));

//RICAVO LE PARTECIPAZIONI E LE TABELLE COLLEGATE
		Partecipazione partecipazione1 = paDao.getById("007c92b4-f98c-450a-b469-7977409559f6");
		Partecipazione partecipazione2 = paDao.getById("2c913727-5b81-4dd7-a569-90c75d4ad88f");
		Partecipazione partecipazione3 = paDao.getById("81c62755-24f0-4281-aaf2-2bd9a2646619");
		Partecipazione partecipazione4 = paDao.getById("c5253d87-eb42-4059-810a-64ce822b6983");

//		System.out.println(partecipazione1.getEvento());
//		System.out.println(partecipazione2.getPersona());
//		System.out.println(partecipazione3.getEvento());
//		System.out.println(partecipazione4.getPersona());
//SALVO EVENTO

//		Evento test = new Evento("java event", LocalDate.now().plusWeeks(1), "mi piace", EventoTipo.PUBBLICO, 1000,
//				location1);
//		eventoDao.save(test);

//SALVO PERSONA

//		Persona p = new Persona("Daniele", "Dattilo", "danydat07@gmail.com", LocalDate.now().plusMonths(6),
//				Gender.Maschio);
//		personaDao.save(p);

//SALVO LOCATION

//		Location l = new Location("Milano Summer festival", "Milano");
//		locationDao.save(l);

//SALVO PARTECIPAZIONE

//		Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Status.CONFERMATA);
//		Partecipazione partecipazione2 = new Partecipazione(persona1, evento2, Status.DA_CONFERMARE);
//		Partecipazione partecipazione3 = new Partecipazione(persona2, evento2, Status.CONFERMATA);
//		Partecipazione partecipazione4 = new Partecipazione(persona2, evento1, Status.DA_CONFERMARE);
//
//		paDao.save(partecipazione1);
//		paDao.save(partecipazione2);
//		paDao.save(partecipazione3);
//		paDao.save(partecipazione4);
		emf.close();
	}

}
