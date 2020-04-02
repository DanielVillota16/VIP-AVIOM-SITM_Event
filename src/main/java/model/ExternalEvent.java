package model;

public interface ExternalEvent {
	String description = "";

	EventType getType();
	void setType(EventType et);
	String getDescription();
	void setDescription();
	Event generateExternalEvent();
}
