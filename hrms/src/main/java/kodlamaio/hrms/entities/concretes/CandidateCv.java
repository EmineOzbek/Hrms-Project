package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_cvs")
public class CandidateCv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@OneToMany(mappedBy = "candidateCv")
	private List<ContactInformation> contactInformations;

	@OneToMany(mappedBy = "candidateCv")
	private List<CoverLetter> coverLetters;

	@OneToMany(mappedBy = "candidateCv")
	private List<Education> educations;

	@OneToMany(mappedBy = "candidateCv")
	private List<Experience> experiences;

	@OneToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToMany(mappedBy = "candidateCv")
	private List<Language> languages;

	@OneToMany(mappedBy = "candidateCv")
	private List<ProgrammingLanguage> programmingLanguages;

}
