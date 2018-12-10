package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * 
 *   A. Door 

 *   	- num
 *     	- floor
 *      - open()
 *      - close()
 *      - addDoorListenr(listener)
 *      - removeDoorListener(listener)
 *      
 *      
 *   B.  Light
 *   
 *       - on(event)
 *       - off(event)
 *    
 *   C.  AC
 *   
 *       - on(event)
 *       - off(event)
 *       
 */

// Event-Emitter e.g Door
//----------------------------------------------

class DoorEvent {
	private int num;

	public DoorEvent(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

}

interface DoorListener {
	void on(DoorEvent event);

	void off(DoorEvent event);
}

class Door {

	private int num;
	private int floorNum;

	private List<DoorListener> doorListeners = new ArrayList<>();

	public Door(int num, int floorNum) {
		super();
		this.num = num;
		this.floorNum = floorNum;
	}

	public void open() {
		System.out.println("door opened..");
		DoorEvent event = new DoorEvent(this.num);
		for (DoorListener listener : doorListeners)
			listener.on(event);
	}

	public void close() {
		System.out.println("door closed..");
		DoorEvent event = new DoorEvent(this.num);
		for (DoorListener listener : doorListeners)
			listener.off(event);
	}

	public void addDoorListener(DoorListener listener) {
		doorListeners.add(listener);
	}

	public void removeListener(DoorListener listener) {
		doorListeners.remove(listener);
	}
}

// Light module
//----------------------------------------------

class Light implements DoorListener {
	@Override
	public void on(DoorEvent event) {
		System.out.println("LIGHT ON , door-num " + event.getNum());
	}

	@Override
	public void off(DoorEvent event) {
		System.out.println("LIGHT OFF , door-num " + event.getNum());
	}
}

//----------------------------------------------

//Light module
//----------------------------------------------

class AC implements DoorListener {
	@Override
	public void on(DoorEvent event) {
		System.out.println("AC ON , door-num " + event.getNum());
	}

	@Override
	public void off(DoorEvent event) {
		System.out.println("AC OFF , door-num " + event.getNum());
	}
}

//----------------------------------------------
// Observer/Listener pattern
//----------------------------------------------

public class Ex1 {

	public static void main(String[] args) throws InterruptedException {

		Door door = new Door(1, 3);

		Light light = new Light();
		AC ac = new AC();

		door.addDoorListener(light);
		door.addDoorListener(ac);

		TimeUnit.SECONDS.sleep(2);
		door.open();
		TimeUnit.SECONDS.sleep(2);
		door.close();

		door.removeListener(ac);

		TimeUnit.SECONDS.sleep(2);
		door.open();
		TimeUnit.SECONDS.sleep(2);
		door.close();
	}

}
