package model;

public abstract class Event {
	private String description;
	private EventType eventType;

	public EventType getType() {
        return eventType;
    }
    public void setType(EventType eventType) {
	    this.eventType = eventType;
    }
    public String getDescription() {
	    return description;
    }
    public void generateEvent() {

    }
}
