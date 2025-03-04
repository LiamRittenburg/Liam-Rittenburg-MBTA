package main;

public class Rider {

	private String ID;
	private String starting;
	private String destination;
	private boolean goingNorth;

	public Rider(String riderID, String startingStation, String destinationStation) {
		this.ID = riderID;
		this.starting = startingStation;
		this.destination = destinationStation;
		this.goingNorth = false;
	}
	
	public String getStarting() {
		return this.starting;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public String getRiderID() {
		return this.ID;
	}
	
	public boolean goingNorth() {	
		return this.goingNorth;
	}
	
	public void swapDirection() {
		if(goingNorth())
		{
			goingNorth = false;
		}
		else
		{
			goingNorth = true;
		}
	}
	
	@Override
	public String toString() {
		return ID + ", " + destination;
	}
	
	@Override
	public boolean equals(Object s) {
		if(s instanceof Rider)
		{
			Rider other = (Rider) s;
			return other.getRiderID() == getRiderID();
		}
		else
		{
			return false;
		}
	}
}
