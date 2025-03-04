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
		String sim = "";
		Node<Station> curr = railway.getFirst();
		while(curr != null)
		{
			Station currStation = curr.getData();
			if(currStation.equals(stationNames[0]))
			{
				//special case
			}
			if(currStation.equals(stationNames[stationNames.length - 1]))
			{
				//special case
			}
			else
			{
				if((currStation.northBoundTrains).size() > 0)
				{
					Train t_N = currStation.northBoardTrain();
					t_N.updateStation(curr.getNext().getData().stationName());
					sim = sim + t_N.disembarkPassengers();
				}
				if((currStation.southBoundTrains).size() > 0)
				{
					Train t_S = currStation.southBoardTrain();
					t_S.updateStation(curr.getNext().getData().stationName());
					sim = sim + t_S.disembarkPassengers();
				}
			}
			sim = sim + currStation.toString();
			curr = curr.getNext();
		}
		return sim;
	}
	
	@Override
	public String toString() {
		return "" + railway.size();
	}
}
