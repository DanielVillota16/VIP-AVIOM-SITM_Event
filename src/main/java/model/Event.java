package model;
//cada instancia debe estar asociada a una dist. de prob.
public abstract class Event {
	private String description;
	private EventType eventType;
	private ProbabilisticDistribution distribution;
	//contexto: dentro o fuera de event?
    //dentro como atributo, así cada instancia de event puede acceder a la información de su respectivo contexto

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
