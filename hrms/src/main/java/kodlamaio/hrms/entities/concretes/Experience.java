package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experiences")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "exit_name")
	private LocalDate exitDate;

	@Column(name = "is_working")
	private String isWorking;

	@OneToMany(mappedBy = "experience")
	private List<JobPosition> jobPositions;

	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;

}
