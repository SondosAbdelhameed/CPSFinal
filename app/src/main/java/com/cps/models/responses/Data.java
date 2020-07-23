package com.cps.models.responses;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("events_news")
	private List<EventsNewsItem> eventsNews;

	@SerializedName("gallery")
	private List<GalleryItem> gallery;

	@SerializedName("admission_id")
	private int admissionId;

	@SerializedName("user")
	private User user;

	@SerializedName("children")
	private List<ChildrenItem> children;

	@SerializedName("grades")
	private List<GradesItem> grades;

	@SerializedName("activities")
	private List<ActivitiesItem> activities;

	@SerializedName("messages")
	private List<MessagesItem> messages;

	@SerializedName("notification")
	private List<NotificationItem> notification;

	public void setNotification(List<NotificationItem> notification){
		this.notification = notification;
	}

	public List<NotificationItem> getNotification(){
		return notification;
	}

	public void setMessages(List<MessagesItem> messages){
		this.messages = messages;
	}

	public List<MessagesItem> getMessages(){
		return messages;
	}

	public void setActivities(List<ActivitiesItem> activities){
		this.activities = activities;
	}

	public List<ActivitiesItem> getActivities(){
		return activities;
	}

	public void setGrades(List<GradesItem> grades){
		this.grades = grades;
	}

	public List<GradesItem> getGrades(){
		return grades;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setChildren(List<ChildrenItem> children){
		this.children = children;
	}

	public List<ChildrenItem> getChildren(){
		return children;
	}

	public void setAdmissionId(int admissionId){
		this.admissionId = admissionId;
	}

	public int getAdmissionId(){
		return admissionId;
	}

	public void setGallery(List<GalleryItem> gallery){
		this.gallery = gallery;
	}

	public List<GalleryItem> getGallery(){
		return gallery;
	}

	public void setEventsNews(List<EventsNewsItem> eventsNews){
		this.eventsNews = eventsNews;
	}

	public List<EventsNewsItem> getEventsNews(){
		return eventsNews;
	}

	@Override
	public String toString() {
		return "Data{" +
				"eventsNews=" + eventsNews +
				", gallery=" + gallery +
				", admissionId=" + admissionId +
				", user=" + user +
				", children=" + children +
				", grades=" + grades +
				", activities=" + activities +
				", messages=" + messages +
				'}';
	}
}