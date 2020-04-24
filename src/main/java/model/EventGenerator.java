package model;

public class EventGenerator implements SystemEvent,ExternalEvent{
    private EventType field;

    public EventGenerator() {

    }
    public Event generateNextEvent() {
        return generateExternalEvent();
    }

    @Override
    public Event generateExternalEvent() {
        return null;
    }

    @Override
    public EventType getType() {
        return null;
    }

    @Override
    public void setType(EventType et) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription() {

    }

    @Override
    public Event generateSystemEvent() {
        return null;
    }
}
