package com.acheron.resource.mngt.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project")
public class ProjectNew {

	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectOwner() {
		return projectOwner;
	}


	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}


	public Timestamp getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public CampaignNew getCampaign() {
		return campaign;
	}


	public void setCampaign(CampaignNew campaign) {
		this.campaign = campaign;
	}


	public Set<TaskNew> getTasks() {
		return tasks;
	}


	public void setTasks(Set<TaskNew> tasks) {
		this.tasks = tasks;
	}


	public ProjectNew() {
		super();
	}


	@Id
	private int projectId;
	private String projectName;
	private String projectOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
	private String createdBy;
	private String updatedBy;
	
	@ManyToOne
	@JoinColumn(name="campaignId")
	private CampaignNew campaign;
	
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private Set<TaskNew> tasks;

	public ProjectNew(int projectId, String projectName, String projectOwner, Timestamp startDate, Timestamp endDate,
			Priority priority, Status status, Timestamp createDate, Timestamp updateDate, int isDeleted,
			String createdBy, String updatedBy, CampaignNew campaign, Set<TaskNew> tasks) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectOwner = projectOwner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.campaign = campaign;
		this.tasks = tasks;
	}
	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectOwner=" + projectOwner
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", status=" + status
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", isDeleted=" + isDeleted + "]";
	}

	
}
