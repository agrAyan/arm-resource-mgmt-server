package com.acheron.resource.mngt.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="campaign")
public class CampaignNew {
	public int getCampaignId() {
		return campaignId;
	}


	public String getCampaignName() {
		return campaignName;
	}


	public String getCampaignOwner() {
		return campaignOwner;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public Priority getPriority() {
		return priority;
	}


	public Status getStatus() {
		return status;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public Timestamp getUpdateDate() {
		return updateDate;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public String getRegion() {
		return region;
	}


	public Set<ProjectNew> getProjects() {
		return projects;
	}


	public CampaignNew() {
		super();
	}


	@Id
	private int campaignId;
	private String campaignName;
	private String campaignOwner;
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
	private String region;
	@OneToMany(mappedBy = "campaign")
	@JsonIgnore
	private Set<ProjectNew> projects;

	
	@Override
	public String toString() {
		return "Campaign [campaignId=" + campaignId + ", campaignName=" + campaignName + ", campaignOwner="
				+ campaignOwner + ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority
				+ ", status=" + status + ", createDate=" + createDate + ", updateDate=" + updateDate + ", isDeleted="
				+ isDeleted + "]";
	}


	public CampaignNew(int campaignId, String campaignName, String campaignOwner, Timestamp startDate, Timestamp endDate,
			Priority priority, Status status, Timestamp createDate, Timestamp updateDate, int isDeleted,
			String createdBy, String updatedBy, String region, Set<ProjectNew> projects) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.campaignOwner = campaignOwner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.region = region;
		this.projects = projects;
	}
	
}
