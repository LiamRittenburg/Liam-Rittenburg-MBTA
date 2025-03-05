/**
 * This class constructs Rider(String riderID, String startingStation, String destinationStation) and creates the getStarting(),
 * getDestination(), getRiderID(), goingNorth(), swapDirection(), and toString() methods.
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class Rider {

	private String ID;
	private String starting;
	private String destination;
	private boolean goingNorth;

	/**
	 * This constructor initializes a Rider object with ID equal to argument riderID, starting equal to argument
	 * startingStation, and destination equal to argument destinationStation. The rider is defaulted to goingNorth() = false.
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.ID = riderID;
		this.starting = startingStation;
		this.destination = destinationStation;
		this.goingNorth = false;
	}
	
	/**
	 * This method returns the String representation of the Rider's starting station.
	 * @return
	 */
	public String getStarting() {
		return this.starting;
	}
	
	/**
	 * This method returns the String representation of the Rider's destination station.
	 * @return
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * This method returns the String representation of the Rider's ID.
	 * @return
	 */
	public String getRiderID() {
		return this.ID;
	}
	
	/**
	 * This method returns a boolean; true of the rider is heading north, and false if they are heading south.
	 * @return
	 */
	public boolean goingNorth() {	
		return this.goingNorth;
	}
	
	/**
	 * This method sets the goingNorth field to the opposite of its current state.
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
	 * This method returns a string representation of a Rider object.
	 */
	@Override
	public String toString() {
		return ID + ", " + destination;
	}
	
	/**
	 * This method compares rider objects based on their ID. If their ID's are the same, this method returns true,
	 * and false otherwise.
	 */
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
