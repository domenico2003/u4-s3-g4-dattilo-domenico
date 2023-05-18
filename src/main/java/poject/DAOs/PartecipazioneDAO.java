package poject.DAOs;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import poject.classDatabase.Partecipazione;
import poject.exceptions.NotFoundException;

@Slf4j
public class PartecipazioneDAO {
	private EntityManagerFactory emf;

	public PartecipazioneDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Partecipazione e) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		em.persist(e);

		transazione.commit();

		em.close();
		log.info("salvataggio avvenuto con successo");
	}

	public Partecipazione getById(String id) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		Partecipazione risultatoRicerca = em.find(Partecipazione.class, UUID.fromString(id));

		transazione.commit();

		em.close();

		return risultatoRicerca;
	}

	public void deleteById(String id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transazione = em.getTransaction();
			transazione.begin();

			Partecipazione partecipazione = em.find(Partecipazione.class, UUID.fromString(id));

			if (partecipazione != null) {
				em.remove(partecipazione);
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
