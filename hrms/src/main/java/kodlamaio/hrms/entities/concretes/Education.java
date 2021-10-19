package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "collage_name")
	@NotNull
	@NotBlank
	private String collageName;

	@Column(name = "department")
	@NotNull
	@NotBlank
	private String department;

	@Column(name = "entry_date")
	@NotNull
	@NotBlank
	private LocalDate entryDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@Column(name = "is_graduated")
	@NotNull
	@NotBlank
	private String isGraduated;

	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;

}
