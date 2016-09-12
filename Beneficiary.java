package edu.mum.volunteering.domain;
// Generated Sep 12, 2016 12:53:46 AM by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Beneficiary generated by hbm2java
 */
@Entity
@Table(name = "beneficiary", catalog = "volunteering")
public class Beneficiary implements java.io.Serializable {

	private Integer beneficiaryId;
	private Image image;
	private int projectId;
	private String description;
	private Set<TaskBeneficiary> taskBeneficiaries = new HashSet<TaskBeneficiary>(0);

	public Beneficiary() {
	}

	public Beneficiary(int projectId) {
		this.projectId = projectId;
	}

	public Beneficiary(Image image, int projectId, String description, Set<TaskBeneficiary> taskBeneficiaries) {
		this.image = image;
		this.projectId = projectId;
		this.description = description;
		this.taskBeneficiaries = taskBeneficiaries;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "beneficiaryID", unique = true, nullable = false)
	public Integer getBeneficiaryId() {
		return this.beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "imgID")
	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Column(name = "projectID", nullable = false)
	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiary")
	public Set<TaskBeneficiary> getTaskBeneficiaries() {
		return this.taskBeneficiaries;
	}

	public void setTaskBeneficiaries(Set<TaskBeneficiary> taskBeneficiaries) {
		this.taskBeneficiaries = taskBeneficiaries;
	}

}
