package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	private String current;
	private boolean goingNorth;
	
	public Train(String currentStation, int direction) {
		this.current = currentStation;
		if(direction > 0)
		{
			goingNorth = false;
		}
		else
		{
			goingNorth = true;
		}
		passengers = new Rider[TOTAL_PASSENGERS];
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
	
	public String currentPassengers() {
		String p = "";
		for(int i = 0; i < passengerIndex; i++)
		{
			p = p + passengers[i].toString() + "\n";
		}
		return p;
	}
	
	public boolean addPassenger(Rider r) {
		if(r.getStarting().equals(getStation()) && r.goingNorth() == goingNorth() && hasSpaceForPassengers())
		{
			passengers[passengerIndex] = r;
			passengerIndex++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasSpaceForPassengers() {
		if(passengerIndex < TOTAL_PASSENGERS)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String disembarkPassengers() {
		String exiting = "";
		Rider[] tmp = new Rider[TOTAL_PASSENGERS];
		int tmpInd = 0;
		int exited = 0;
		for(int i = 0; i < passengerIndex; i++)
		{
			if((passengers[i].getDestination()).equals(getStation()))
			{
				exiting = exiting + passengers[i].toString() + "\n";
				passengers[i] = null;
				exited++;
			}
		}
		for(int j = 0; j < passengerIndex - exited; j++)
		{
			if(passengers[j] != null)
			{
				tmp[tmpInd] = passengers[j];
				tmpInd++;
			}
		}
		passengers = tmp;
		passengerIndex -= exited;
		return exiting;
	}
	
	public void updateStation(String s) {
		current = s;
	}
	
	public String getStation() {
		return current;
	}
	
	@Override
	public String toString() {
		String direction = "";
		if(goingNorth())
		{
			direction = "North";
		}
		else
		{
			direction = "South";
		}
		return direction + "-bound train at " + getStation() + " carrying " + passengerIndex + " passengers.";
	}
}
