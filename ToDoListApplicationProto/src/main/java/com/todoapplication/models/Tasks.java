package com.todoapplication.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id")
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	@ApiModelProperty(value = "Taskname")
	private String taskname;

	@NotNull
	@ApiModelProperty(value = "Performdate")
	private Date performdate;

	@NotNull
	@Size(min = 5, max = 15)
	@ApiModelProperty(value = "Category")
	private String category;

	@NotNull
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Priority")
	private PriorityEnum priority;

	@NotNull
	@ApiModelProperty(value = "IsDone")
	private Boolean isdone;

	public Tasks(String taskname, Date performdate, String category, PriorityEnum priority, Boolean isdone) {
		this.taskname = taskname;
		this.performdate = performdate;
		this.category = category;
		this.priority = priority;
		this.isdone = false;
	}

	public Tasks() {
	}

}
