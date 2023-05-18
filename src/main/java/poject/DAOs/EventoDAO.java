package poject.DAOs;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import lombok.extern.slf4j.Slf4j;
import poject.classDatabase.Evento;
import poject.classDatabase.ExendedClasses.Concerto;
import poject.classDatabase.ExendedClasses.PartitaDiCalcio;
import poject.classDatabase.enums.GenereConcerto;
import poject.exceptions.NotFoundException;

@Slf4j
public class EventoDAO {
	private EntityManagerFactory emf;

	public EventoDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(Evento e) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		em.persist(e);

		transazione.commit();

		em.close();
		log.info("salvataggio avvenuto con successo");
	}

	public Evento getById(String id) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		Evento risultatoRicerca = em.find(Evento.class, UUID.fromString(id));

		transazione.commit();

		em.close();

		return risultatoRicerca;
	}

	public void deleteById(String id) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transazione = em.getTransaction();
			transazione.begin();

			Evento evento = em.find(Evento.class, UUID.fromString(id));

			if (evento != null) {
				em.remove(evento);
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

	public List<Concerto> getConcertiInStreaming() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();
		Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming=true");
		List<Concerto> risultato = query.getResultList();

		em.close();
		return risultato;
	}

	public List<Concerto> getConcertiPerGenere(GenereConcerto g) {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();
		Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere=:gen");
		query.setParameter("gen", g);
		List<Concerto> risultato = query.getResultList();

		em.close();
		return risultato;
	}

	public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
		List<PartitaDiCalcio> risultato = query.getResultList();

		em.close();
		return risultato;
	}

	public List<PartitaDiCalcio> getPartiteVinteInCasa() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
		List<PartitaDiCalcio> risultato = query.getResultList();

		em.close();
		return risultato;
	}

	public List<PartitaDiCalcio> getPartitePareggiate() {
		EntityManager em = emf.createEntityManager();

		EntityTransaction transazione = em.getTransaction();
		transazione.begin();

		TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartitePareggiate", PartitaDiCalcio.class);
		List<PartitaDiCalcio> risultato = query.getResultList();

		em.close();
		return risultato;
	}

}
