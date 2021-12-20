package org.arm.resource.mngt.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name="resource")
public class ResourceNew {

	public ResourceNew(int resourceId, String resourceName, String resourceType, Timestamp createDate,
			Timestamp updateDate, int isDeleted, List<TaskNew> taskList, String resourceImage, String region,
			Availability availability, Leaves leave) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.isDeleted = isDeleted;
		this.taskList = taskList;
		this.resourceImage = resourceImage;
		this.region = region;
		this.availability = availability;
		this.leave = leave;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceType="
				+ resourceType + ", createDate=" + createDate + ", updateDate=" + updateDate + ", isDeleted="
				+ isDeleted + ", resourceImage=" + resourceImage + ", region=" + region + ", availability="
				+ availability + ", leave=" + leave + "]";
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
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

	public List<TaskNew> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskNew> taskList) {
		this.taskList = taskList;
	}

	public String getResourceImage() {
		return resourceImage;
	}

	public void setResourceImage(String resourceImage) {
		this.resourceImage = resourceImage;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public Leaves getLeave() {
		return leave;
	}

	public void setLeave(Leaves leave) {
		this.leave = leave;
	}

	public ResourceNew() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resourceId;
	private String resourceName;
	private String resourceType;
	private Timestamp createDate;
	private Timestamp updateDate;
	private int isDeleted;
		
	@OneToMany(mappedBy="resource")
	private List<TaskNew> taskList;
	private String resourceImage;
	private String region;
	@OneToOne
	@JoinColumn(name="availableId")
	private Availability availability;
	
	@OneToOne
	@JoinColumn(name="leaveId")
	private Leaves leave;

	
}
