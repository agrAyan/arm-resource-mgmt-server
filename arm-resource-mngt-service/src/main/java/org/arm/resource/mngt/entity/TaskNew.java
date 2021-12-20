package org.arm.resource.mngt.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="task")
public class TaskNew {

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskOwner=" + taskOwner + ", startDate="
				+ startDate + ", endDate=" + endDate + ", duration=" + duration + ", priority=" + priority + ", status="
				+ status + ", createDate=" + createDate + ", updateDate=" + updateDate + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", resource=" + resource + "]";
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
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

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
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

	public ProjectNew getProject() {
		return project;
	}

	public void setProject(ProjectNew project) {
		this.project = project;
	}

	public ResourceNew getResource() {
		return resource;
	}

	public void setResource(ResourceNew resource) {
		this.resource = resource;
	}

	public TaskNew() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private String taskName;
	private String taskOwner;
	private Timestamp startDate;
	private Timestamp endDate;
	private float duration;
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
	@JoinColumn(name = "projectId")
	private ProjectNew project;

	@ManyToOne
	@JoinColumn(name = "resourceId")
	@JsonIgnore
	private ResourceNew resource;

	public TaskNew(int taskId, String taskName, String taskOwner, Timestamp startDate, Timestamp endDate, float duration,
			Priority priority, Status status, Timestamp createDate, Timestamp updateDate, int isDeleted,
			String createdBy, String updatedBy, ProjectNew project, ResourceNew resource) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.duration = duration;
		this.priority = priority;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.project = project;
		this.resource = resource;
	}

	
	

}
