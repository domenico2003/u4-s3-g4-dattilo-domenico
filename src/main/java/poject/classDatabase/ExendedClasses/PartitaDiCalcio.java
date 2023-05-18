package poject.classDatabase.ExendedClasses;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import poject.classDatabase.Evento;
import poject.classDatabase.Location;
import poject.classDatabase.enums.EventoTipo;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraDiCasa")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "getPartitePareggiate", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento {

	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int goalSquadraDiCasa;
	private int goalSquadraOspite;

	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventoTipo tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite,
			String squadraVincente, int goalSquadraDiCasa, int goalSquadraOspite) {

		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);

		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.goalSquadraDiCasa = goalSquadraDiCasa;
		this.goalSquadraOspite = goalSquadraOspite;
	}

}
