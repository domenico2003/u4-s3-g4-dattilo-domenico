package poject.classDatabase.ExendedClasses;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import poject.classDatabase.Evento;
import poject.classDatabase.Location;
import poject.classDatabase.Persona;
import poject.classDatabase.enums.EventoTipo;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//@NamedQuery(name = "getGareDiAtleticaPerVincitore", query = "SELECT  ")
//@NamedQuery(name = "getGareDiAtleticaPerPartecipante", query = "")
public class GaraDiAtletica extends Evento {
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Persona> atleti;
	@ManyToOne
	private Persona vincitore;

	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventoTipo tipoEvento,
			int numeroMassimoPartecipanti, Location location, Set<Persona> atleti, Persona vincitore) {

		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);

		this.atleti = atleti;
		this.vincitore = vincitore;
	}
}
