package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	@Id
	@GeneratedValue()
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisement> jobPositions;
}
