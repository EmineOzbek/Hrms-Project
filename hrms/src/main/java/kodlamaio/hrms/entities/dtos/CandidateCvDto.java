package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ContactInformation;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {

	private Candidate candidate;

	private List<ContactInformation> contactInformations;

	private List<CoverLetter> coverLetters;

	private List<Education> educations;

	private List<Experience> experiences;

	private List<Image> images;

	private List<Language> languages;

	private List<ProgrammingLanguage> programmingLanguages;

}
