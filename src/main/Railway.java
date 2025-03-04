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
		
	}
	
	public void setRiderDirection(Rider r) {
		String start = r.getStarting();
		String end = r.getDestination();
		int startInd = -1;
		int endInd = -1;
		boolean north = false;
		for(int i = 0; i < stationNames.length; i++)
		{
			if(stationNames[i] == start)
			{
				startInd = i;
			}
			if(stationNames[i] == end)
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
		if((curr.getData()).equals(stationNames[0]))
		{
			//special case
		}
		if((curr.getData()).equals(stationNames[stationNames.length - 1]))
		{
			//special case
		}
		else
		{
			Train t_N = curr.getData().northBoardTrain();
			Train t_S = curr.getData().southBoardTrain();
			t_N.updateStation(curr.getNext().getData().stationName());
			t_S.updateStation(curr.getPrev().getData().stationName());
			sim = sim + t_N.disembarkPassengers();
			sim = sim + t_S.disembarkPassengers();
			sim = sim + curr.getNext().toString();
		}
		curr = curr.getNext();
		return sim;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
