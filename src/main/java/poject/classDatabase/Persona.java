package poject.classDatabase;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import poject.classDatabase.enums.Gender;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;

	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataDiNascita;
	@Enumerated(EnumType.STRING)
	private Gender sesso;
	@OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
	private Set<Partecipazione> partecipazioni;

	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Gender sesso) {

		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;

	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataDiNascita="
				+ dataDiNascita + ", sesso=" + sesso + "]";
	}
}
