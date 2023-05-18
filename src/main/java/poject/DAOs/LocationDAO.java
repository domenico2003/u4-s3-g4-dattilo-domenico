package poject.DAOs;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import lombok.extern.slf4j.Slf4j;
import poject.classDatabase.Location;
import poject.exceptions.NotFoundException;

@Slf4j
public class LocationDAO {
	private EntityManagerFactory emf;

	public LocationDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Location e) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		em.persist(e);

		transazione.commit();

		em.close();
		log.info("salvataggio avvenuto con successo");
	}

	public Location getById(String id) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		Location risultatoRicerca = em.find(Location.class, UUID.fromString(id));

		transazione.commit();

		em.close();

		return risultatoRicerca;
	}

	public void deleteById(String id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transazione = em.getTransaction();
			transazione.begin();

			Location location = em.find(Location.class, UUID.fromString(id));

			if (location != null) {
				em.remove(location);
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
