package com.core.vehicles;


public enum Category {
	BIKE, SCOOTER, SPORTS_CAR, SUV, SEDAN, TRUCK;

	@Override
	public String toString() {
		return "Category " + name().toLowerCase();
	}
	//can add constr , state , getter/setter  , methods , static init blocks
}
