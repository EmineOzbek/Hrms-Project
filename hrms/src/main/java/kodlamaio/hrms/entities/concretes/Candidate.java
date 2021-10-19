package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "birt_year")
	private Date birtYear;

	@OneToOne(mappedBy = "candidate")
	private Image image;

	@OneToOne(mappedBy = "candidate")
	private CandidateCv candidateCv;
}
