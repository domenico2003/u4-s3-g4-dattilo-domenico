package poject.classDatabase;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poject.classDatabase.enums.EventoTipo;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Evento {

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}

	@Id
	@GeneratedValue
	private UUID id;
	@Column
	private String titolo;
	@Column
	private LocalDate dataEvento;
	@Column
	private String descrizione;
	@Column
	@Enumerated(EnumType.STRING)
	private EventoTipo tipoEvento;
	@Column
	private int numeroMassimoPartecipanti;

	@OneToMany(mappedBy = "evento", fetch = FetchType.EAGER)
	private Set<Partecipazione> partecipazioni;
	@OneToOne
	private Location location;

	public Evento(String titolo, LocalDate dataEvento, String descrizione, EventoTipo tipoEvento,
			int numeroMassimoPartecipanti, Location location) {

		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

}
