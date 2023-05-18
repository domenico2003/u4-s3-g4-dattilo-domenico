package poject.classDatabase.ExendedClasses;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import poject.classDatabase.Evento;
import poject.classDatabase.Location;
import poject.classDatabase.enums.EventoTipo;
import poject.classDatabase.enums.GenereConcerto;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//@NamedQuery(name = "getEventiSoldOut", query = "")
//@NamedQuery(name = "getEventiPerInvitato", query = "")

public class Concerto extends Evento {
	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;
	private boolean inStreaming;

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventoTipo tipoEvento,
			int numeroMassimoPartecipanti, Location location, GenereConcerto genere, boolean inStreaming) {

		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);

		this.genere = genere;
		this.inStreaming = inStreaming;
	}

}
