/**
 * This class constructs Train(String currentStation, int direction), and creates the goingNorth(), swapDirection(),
 * currentPassengers(), addPassenger(Rider r), hasSpaceForPassengers(), disembarkPassengers(), updateStation(),
 * getStation(), and toString() methods.
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	private String current;
	private boolean goingNorth;
	
	/**
	 * This constructor initializes a train object with current set equal to argument currentStation, and direction set
	 * based on argument direction(1 for south, 0 for north). The passengers array is set to the length of TOTAL_PASSENGERS
	 * @param currentStation
	 * @param direction
	 */
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
	
	/**
	 * This method returns the boolean true if the train is going north, and false if the train is going south.
	 * @return
	 */
	public boolean goingNorth() {
		return this.goingNorth;
	}
	
	/**
	 * This method changes the direction of the train when called.
	 */
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
	
	/**
	 * This method returns a String representation of the current Rider objects on the train object.
	 * @return
	 */
	public String currentPassengers() {
		String p = "";
		for(int i = 0; i < passengerIndex; i++)
		{
			p = p + passengers[i].toString() + "\n";
		}
		return p;
	}
	
	/**
	 * If the argument r is at the current of the train, is heading the same direction as the train, and the train
	 * has room to take on more passengers, the Rider r is added to the train's currentPassengers, and the boolean
	 * true is returned. Otherwise, false is returned.
	 * @param r
	 * @return
	 */
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
	
	/**
	 * If the train objects currentPassengers array has room for more elements, this method returns true. False otherwise
	 * @return
	 */
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
	
	/**
	 * This method returns a string representation of the passengers that are exiting at the trains current station. The
	 * Rider objects that are exiting are removed from the train object. If no passengers are exiting, an empty String is
	 * returned.
	 * @return
	 */
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
		for(int j = 0; j < passengerIndex - exited + 1; j++)
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
	
	/**
	 * This method updates current to be equal to argument String s, representing the new station.
	 * @param s
	 */
	public void updateStation(String s) {
		current = s;
	}
	
	/**
	 * This method returns the string representation of the current station of the train.
	 * @return
	 */
	public String getStation() {
		return current;
	}
	
	/**
	 * This method returns a string representation of the train object.
	 */
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
