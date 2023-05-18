package poject.DAOs;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import poject.classDatabase.Persona;
import poject.exceptions.NotFoundException;

@Slf4j
public class PersonaDAO {
	private EntityManagerFactory emf;

	public PersonaDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Persona e) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		em.persist(e);

		transazione.commit();

		em.close();
		log.info("salvataggio avvenuto con successo");
	}

	public Persona getById(String id) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		Persona risultatoRicerca = em.find(Persona.class, UUID.fromString(id));

		transazione.commit();

		em.close();

		return risultatoRicerca;
	}

	public void deleteById(String id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transazione = em.getTransaction();
			transazione.begin();

			Persona persona = em.find(Persona.class, UUID.fromString(id));

			if (persona != null) {
				em.remove(persona);
				log.info("elemento con id: " + id + " eliminato con successo");
			} else {
				throw new NotFoundException("evento non trovato");
			}
			transazione.commit();
		} catch (NotFoundException e) {
			log.error(e.getMessage());
		} finally {
			em.close();
		}

	}

}
