package com.leet.jan;
 
import java.util.PriorityQueue;

public class CarPooling {


 


	public boolean carPooling(int[][] trips, int capacity) {


		//Arrays.sort(trips, (a, b) -> Integer.compare(a[1],b[1]));
	 
		PriorityQueue<int[]> dropPassengerQueue= new PriorityQueue<>((a, b) -> Integer.compare(a[2],b[2]));
		int successfulTrips=0;
		int lastPickUp=0;
		for(int[] trip: trips) {
			
			if(trip[1]<lastPickUp) {
				return false;
			}

			if (capacity>=trip[0]) {
				capacity-=trip[0];
				lastPickUp=trip[1];
				dropPassengerQueue.add(trip);
				successfulTrips++;
			}
			else if(capacity<trip[0] && !dropPassengerQueue.isEmpty()) {
				int[] temp = dropPassengerQueue.peek();
				if(temp[2]<=trip[1]) {
					capacity+=temp[0];
					dropPassengerQueue.poll();
					dropPassengerQueue.add(trip);
					lastPickUp=trip[1];
					successfulTrips++;
				}else
					return false; 

			}
			else
				return false; 


		}

		if(successfulTrips==trips.length) {
			return true;
		}
		else return false;
	}


	public static void main(String[] args) {
		//int[][] trips = {{2,1,5},{3,5,7}};
		//int[][] trips = {{3,2,7},{3,7,9},{8,3,9}};
		int[][] trips= {{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}};
		//int[][] trips = {{2,1,5},{3,3,7}};
		int capacity = 12;

		CarPooling obj = new CarPooling();
	 
	 	System.out.println(obj.carPooling(trips, capacity));
		 
	}

}
