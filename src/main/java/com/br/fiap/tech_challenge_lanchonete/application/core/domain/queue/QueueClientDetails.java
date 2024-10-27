package com.br.fiap.tech_challenge_lanchonete.application.core.domain.queue;

import java.time.LocalDateTime;

public class QueueClientDetails {

	private String jobId;
	private String taskType;
	private String status;
	private LocalDateTime createAt;
	
	public QueueClientDetails() {
	}
	
	public QueueClientDetails(String jobId, String taskType, String status, LocalDateTime createAt) {
		super();
		this.jobId = jobId;
		this.taskType = taskType;
		this.status = status;
		this.createAt = createAt;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	
}
