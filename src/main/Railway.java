/**
 * This class constructs Railway() and creates the methods addStation(Station s), addRider(Rider r), addTrain(Train t),
 * setRiderDirection(Rider r), simulate(), and toString() methods. 
 * Known bugs: None
 * 
 * Liam Rittenburg
 * liamrittenburg@brandeis.edu
 * March 2025
 * COSI 21A PA1
 */
package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	
	/**
	 * Runtime: O(1)
	 * This constructor initializes a Railway object. An empty double linked list is initialized, and stationNames
	 * is set to hold 18 elements.
	 */
	public Railway() {
		railway = new DoubleLinkedList<>();
		stationNames = new String[18];
	}
	
	/**
	 * Runtime: O(1)
	 * This method adds a node holding the argument s to the railway linked list.
	 * @param s
	 */
	public void addStation(Station s) {
		railway.insert(s);
	}
	
	/**
	 * Runtime: O(n) (.get() is an O(n) method))
	 * This method sets the rider in the appropriate direction (see setRiderDirection()), and adds them to the
	 * appropriate queue of the appropriate starting station.
	 * @param r
	 */
	public void addRider(Rider r) {
		setRiderDirection(r);
		Station copy = new Station(r.getStarting());
		Station real = railway.get(copy);
		real.addRider(r);
	}
	
	/**
	 * Runtime: O(n) (.get() is an O(n) method))
	 * This method adds the argument t to the appropriate train queue of the appropriate station.
	 * @param t
	 */
	public void addTrain(Train t) {
		String station = t.getStation();
		Station copy = new Station(station);
		Station real = railway.get(copy);
		real.addTrain(t);
	}
	
	/**
	 * Runtime: O(n) (n being stationNames.length)
	 * This method determines whether the rider is heading north or south based on the rider's starting and 
	 * ending destinations, and sets their goingNorth field accordingly.
	 * @param r
	 */
	public void setRiderDirection(Rider r) {
		String start = r.getStarting();
		String end = r.getDestination();
		int startInd = -1;
		int endInd = -1;
		boolean north = false;
		for(int i = 0; i < stationNames.length; i++)
		{
			if(stationNames[i].equals(start))
			{
				startInd = i;
			}
			if(stationNames[i].equals(end))
			{
				endInd = i;
			}
		}
		if(endInd > startInd)
		{
			north = false;
		}
		else
		{
			north = true;
		}
		if(north)
		{
			if(r.goingNorth() == false)
			{
				r.swapDirection();
			}
		}
		else if(!north)
		{
			if(r.goingNorth())
			{
				r.swapDirection();
			}
		}
	}
	
	/**
	 * Runtime: O(n^m) (n being stationNames.length, m being TOTAL_PASSENGERS being called inside of the while loop)
	 * This method runs one simulation of of a run through the railway. A string representing the log of that
	 * simulation is returned.
	 * @return
	 */
	public String simulate() {
		String sim = "Simulating one run of MBTA.\n";
		Node<Station> curr = railway.getFirst();
		while(curr != null)
		{
			Station currStation = curr.getData();
			if(currStation.stationName().equals(stationNames[0])) // Alewife
			{
				sim = sim + currStation.toString() + "\n";
				Train t_S = currStation.southBoardTrain();
				currStation.moveTrainNorthToSouth();
				curr = curr.getNext();
				currStation = curr.getData();
				sim = sim + currStation.addTrain(t_S);
				
			}
			else if(currStation.stationName().equals(stationNames[stationNames.length - 1])) // Braintree
			{
				sim = sim + currStation.toString() + "\n";
				Train t_N = currStation.northBoardTrain();
				sim = sim + curr.getPrev().getData().addTrain(t_N);
				sim = sim + "\n------------\n" + "\n";
				currStation.moveTrainSouthToNorth();
				curr = curr.getNext();
			}
			else
			{
				sim = sim + currStation.toString() + "\n";
				Train t_N = currStation.northBoardTrain();
				Train t_S = currStation.southBoardTrain();
				sim = sim + curr.getPrev().getData().addTrain(t_N);
				curr = curr.getNext();
				currStation = curr.getData();
				sim = sim + currStation.addTrain(t_S);
			}
		}
		return sim;
	}
	
	/**
	 * Runtime: O(n)
	 * This method returns a string representation of the Railway object.
	 */
	@Override
	public String toString() {
		String ret = "";
		Node<Station> curr = railway.getFirst();
		while(curr != null)
		{
			Station currStation = curr.getData();
			ret = ret + currStation.toString();
			curr = curr.getNext();
		}
		return ret;
	}
}
