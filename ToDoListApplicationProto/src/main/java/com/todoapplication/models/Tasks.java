package com.todoapplication.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "Tasks", reference = "Tasks", description = "Tasks Response")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id")
	private int id;
	
	@ApiModelProperty(value = "Taskname")
	private String taskname;
	
	@ApiModelProperty(value = "Task Description")
	private String taskdescription;
	
	@ApiModelProperty(value = "Task Priority")
	private String taskpriority;
	
	@ApiModelProperty(value = "Task Status")
	private String taskstatus;
	

	@ApiModelProperty(value = "Task Archived")
	private int taskarchived = 0;

	public Tasks(String taskname, String taskdescription, String taskpriority, String taskstatus, int taskarchived) {
		this.taskname = taskname;
		this.taskdescription = taskdescription;
		this.taskpriority = taskpriority;
		this.taskstatus = taskstatus;
		this.taskarchived = taskarchived;
	}


	public String getTaskname() {
		return taskname;
	}


	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}


	public String getTaskdescription() {
		return taskdescription;
	}


	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}


	public String getTaskpriority() {
		return taskpriority;
	}


	public void setTaskpriority(String taskpriority) {
		this.taskpriority = taskpriority;
	}


	public String getTaskstatus() {
		return taskstatus;
	}


	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}


	public int getTaskarchived() {
		return taskarchived;
	}


	public void setTaskarchived(int taskarchived) {
		this.taskarchived = taskarchived;
	}


	public Tasks() {
	}

}
