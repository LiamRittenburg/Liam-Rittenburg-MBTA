package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	
	public Railway() {
		railway = new DoubleLinkedList<>();
		stationNames = new String[18];
	}
	
	public void addStation(Station s) {
		railway.insert(s);
	}
	
	public void addRider(Rider r) {
		setRiderDirection(r);
		Station copy = new Station(r.getStarting());
		Station real = railway.get(copy);
		real.addRider(r);
	}
	
	public void addTrain(Train t) {
		String station = t.getStation();
		Station copy = new Station(station);
		Station real = railway.get(copy);
		real.addTrain(t);
	}
	
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
				//while loop to move all trains from north into south queue?
				
			}
			else if(currStation.stationName().equals(stationNames[stationNames.length - 1])) // Braintree
			{
				sim = sim + currStation.toString() + "\n";
				Train t_N = currStation.northBoardTrain();
				sim = sim + curr.getPrev().getData().addTrain(t_N);
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
			//curr = curr.getNext();
			//sim = sim + currStation.toString();
		}
		return sim;
	}
	
	@Override
	public String toString() {
		return "" + railway.size();
	}
}
