package main;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	public static void main(String[] args) throws FileNotFoundException{
		r = new Railway();
		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");
		runSimulation();
	}
	
	public static void runSimulation() {
		int runs = TIMES;
		for(int i = 0; i < runs; i++)
		{
			System.out.println(r.simulate());
		}
	}
	
	public static void initTrains(String trainsFile) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(trainsFile));
		String nums = "01";
		while(scanner.hasNextLine())
		{
			String station = scanner.nextLine();
			String direction = scanner.nextLine();
			int directionNum = nums.indexOf(direction);
			Train t = new Train(station, directionNum);
			r.addTrain(t);
		}
	}
	
	public static void initRiders(String ridersFile) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(ridersFile));
		while(scanner.hasNextLine())
		{
			String ID = scanner.nextLine();
			String start = scanner.nextLine();
			String end = scanner.nextLine();
			Rider rider = new Rider(ID, start, end);
			r.addRider(rider);
		}
	}
	
	public static void initStations(String stationsFile) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(stationsFile));
		int stationIndex = 0;
		while(scanner.hasNextLine())
		{
			String name = scanner.nextLine();
			Station s = new Station(name);
			r.addStation(s);
			r.stationNames[stationIndex] = s.stationName();
			stationIndex++;
		}
	}
}
