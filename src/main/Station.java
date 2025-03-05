/**
 * This class constructs Station(String name), and the addRider(Rider r), addTrain(Train t), southBoardTrain(),
 * northBoardTrain(), moveTrainNorthToSouth(), moveTrainSouthToNorth(), toString(), stationName(), and equals(Object o) methods. 
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	private String name;
	
	/**
	 * Runtime: O(1)
	 * This constructor initializes a Station object with rider and train queues initialized with capacities of 20,
	 * and sets name equal to the argument name.
	 * @param name
	 */
	public Station(String name) {
		northBoundRiders = new Queue(20);
		southBoundRiders = new Queue(20);
		northBoundTrains = new Queue(20);
		southBoundTrains = new Queue(20);
		this.name = name;
	}
	
	/**
	 * Runtime: O(1)
	 * If a rider is at the appropriate starting station, this method adds that rider to the appropriate queue based
	 * on their direction and returns true. Otherwise false is returned.
	 * @param r
	 * @return
	 */
	public boolean addRider(Rider r) { 
		if(r.getStarting().equals(stationName()))
		{
			if(r.goingNorth())
			{
				northBoundRiders.enqueue(r);
			}
			else
			{
				southBoundRiders.enqueue(r);
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Runtime: O(n) (O(1) method but calls O(n) method(disembarkPassengers))
	 * If the train object passed to this method is not null, this method moves the train into the station, disembarks
	 * its passengers at the updated station, and adds the train to the appropriate queue based on its direction and
	 * returns a String representing the disembarked passengers (if any). If the train object passed is null, and empty
	 * String is returned.
	 * @param t
	 * @return
	 */
	public String addTrain(Train t) {
		String enter = null;
		if(t != null)
		{
			t.updateStation(stationName());
			String exiters = t.disembarkPassengers();
			if(exiters.length() > 0)
			{
				enter = stationName() + " Disembarking Passenger: \n";
				enter = enter + exiters;
			}
			
			if(t.goingNorth())
			{
				northBoundTrains.enqueue(t);
			}
			else
			{
				southBoundTrains.enqueue(t);
			}
		}
		if(enter == null)
		{
			return "";
		}
		else{
			return enter;
		}
	}
	
	/**
	 * Runtime: O(n), n being TOTAL_PASSENGERS
	 * This method removed a southBoundTrain from its queue, and boards the train with passengers (as long as there is space).
	 * The subsequent train object is returned.
	 * @return
	 */
	public Train southBoardTrain() 
	{
		Train t = null;
		if(southBoundTrains.size() > 0)
		{
			t = southBoundTrains.front();
			southBoundTrains.dequeue();
			while(t.hasSpaceForPassengers() && southBoundRiders.size() > 0)
			{
				Rider r = southBoundRiders.front();
				southBoundRiders.dequeue();
				t.addPassenger(r);
			}
		}
		return t;
	}
	
	/**
	 * Runtime: O(n), n being TOTAL_PASSENGERS
	 * This method removed a northBoundTrain from its queue, and boards the train with passengers (as long as there is space).
	 * The subsequent train object is returned.
	 * @return
	 */
	public Train northBoardTrain() 
	{
		Train t = null;
		if(northBoundTrains.size() > 0)
		{
			t = northBoundTrains.front();
			northBoundTrains.dequeue();
			while(t.hasSpaceForPassengers() && northBoundRiders.size() > 0)
			{
				Rider r = northBoundRiders.front();
				northBoundRiders.dequeue();
				t.addPassenger(r);
			}
		}
		return t;
	}
	
	/**
	 * Runtime: O(1)
	 * If the northBoundTrain queue of this station has one or more trains in it, this method
	 * changes the direction of that train and adds it to the queue of the opposite direction.
	 */
	public void moveTrainNorthToSouth() {
		if(northBoundTrains.size() > 0)
		{
			Train t = northBoundTrains.front();
			t.swapDirection();
			northBoundTrains.dequeue();
			southBoundTrains.enqueue(t);
		}

	}
	
	/**
	 * Runtime: O(1)
	 * If the southBoundTrain queue of this station has one or more trains in it, this method
	 * changes the direction of that train and adds it to the queue of the opposite direction.
	 */
	public void moveTrainSouthToNorth() {
		if(southBoundTrains.size() > 0)
		{
			Train t = southBoundTrains.front();
			t.swapDirection();
			southBoundTrains.dequeue();
			northBoundTrains.enqueue(t);
		}
	}
	
	/**
	 * Runtime: O(1)
	 * This method returns a string representation of the station object, indicating the station name
	 * and the size of each queue.
	 */
	@Override
	public String toString() {
		String station = "Station: " + stationName() + "\n";
		station = station + northBoundTrains.size() + " north-bound trains waiting\n";
		station = station + southBoundTrains.size() + " south-bound trains waiting\n";
		station = station + northBoundRiders.size() + " north-bound passengers waiting\n";
		station = station + southBoundRiders.size() + " south-bound passengers waiting\n";
		return station;
	}
	
	/**
	 * Runtime: O(1)
	 * This method returns the String representation of the name of this station.
	 * @return
	 */
	public String stationName() {
		return this.name;
	}
	
	/**
	 * Runtime: O(1)
	 * This method compares station objects based on name. True is returned if the names are the same, false is
	 * returned otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Station)
		{
			Station other = (Station) o;
			String otherName = other.stationName();
			return otherName.equals(name);
		}
		else
		{
			return false;
		}
	}
}
