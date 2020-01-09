package com.tree.speedtest.bean;

public class Project{
	
	private Integer id;
	private Integer progress;
	
	private String name;
	
	private boolean isChild;
	private boolean isAttachement;
	private boolean isCheckList;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public boolean isChild() {
		return isChild;
	}
	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}
	public boolean isAttachement() {
		return isAttachement;
	}
	public void setAttachement(boolean isAttachement) {
		this.isAttachement = isAttachement;
	}
	public boolean isCheckList() {
		return isCheckList;
	}
	public void setCheckList(boolean isCheckList) {
		this.isCheckList = isCheckList;
	}
	
	
	
	
	
	
}
