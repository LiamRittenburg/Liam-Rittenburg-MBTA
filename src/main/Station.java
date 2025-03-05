package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	private String name;
	
	public Station(String name) {
		northBoundRiders = new Queue(20);
		southBoundRiders = new Queue(20);
		northBoundTrains = new Queue(20);
		southBoundTrains = new Queue(20);
		this.name = name;
	}
	
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
	
	public String addTrain(Train t) {
		String enter = null;
		if(t != null)
		{
			String exiters = t.disembarkPassengers();
			if(exiters.length() > 0)
			{
				enter = stationName() + ": \n";
				enter = enter + exiters + "\n";
			}
			//t.updateStation(stationName());
			
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
	
	public void moveTrainNorthToSouth() {
		if(northBoundTrains.size() > 0)
		{
			Train t = northBoundTrains.front();
			t.swapDirection();
			northBoundTrains.dequeue();
			southBoundTrains.enqueue(t);
		}

	}
	
	public void moveTrainSouthToNorth() {
		if(southBoundTrains.size() > 0)
		{
			Train t = southBoundTrains.front();
			t.swapDirection();
			southBoundTrains.dequeue();
			northBoundTrains.enqueue(t);
		}
	}
	
	@Override
	public String toString() {
		String station = "Station: " + stationName() + "\n";
		station = station + northBoundTrains.size() + " north-bound trains waiting\n";
		station = station + southBoundTrains.size() + " south-bound trains waiting\n";
		station = station + northBoundRiders.size() + " north-bound passengers waiting\n";
		station = station + southBoundRiders.size() + " south-bound passengers waiting\n";
		return station;
	}
	
	public String stationName() {
		return this.name;
	}
	
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
