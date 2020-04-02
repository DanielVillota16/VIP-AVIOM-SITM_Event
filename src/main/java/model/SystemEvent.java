package model;
public interface SystemEvent {
    String description = "";

    EventType getType();
    void setType(EventType et);
    String getDescription();
    void setDescription();
    Event generateSystemEvent();
}
