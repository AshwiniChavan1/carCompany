package com.core.vehicles;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class VehicleManager {
    // private static Exception e = new Exception("DateTimeException");

    private LinkedList<Vehicle> list = new LinkedList<>();

    public void showAll(){
        list.showAll();
    }

    public Vehicle getVehicle(int index) {
        return list.get(index);
    }

    public void removeVehicle() {
        if(null==list.remove()){
            System.err.println("Empty List!!!!!");
        }
    }

    public void addVehicle(String regNum, String color, double price, String manufactureDate,
            String vehicleCategory) throws DateTimeException {

        try {
            LocalDate md = LocalDate.parse(manufactureDate);
            Category vc = Category.valueOf(vehicleCategory);
            Vehicle veh = new Vehicle(regNum, color, price, md, vc);
            if (list.add(veh)) {
                System.out.println("Successfully Added Vehicle!!");
            } else {
                System.out.println("UnSuccessful in Adding Vehicle!!");

            }
        } catch (DateTimeException | InputMismatchException dte) {
            throw dte;
        }

    }

}
