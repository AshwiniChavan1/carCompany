package com.core;

import java.util.Scanner;

import com.core.vehicles.VehicleManager;

public class App {
	
	static String menu = "1. Add Vehicle \n"
			+ "2. Remove the last Vehicle\n"
			+ "3. See vehicle at index \n"
			+ "4. See all the vehicle \n"
			+ "5. Number of Vehicles"
			+ "0. Exit.";
    public static void main(String[] args) {


        try(Scanner sc = new Scanner(System.in)){
            VehicleManager vhm = new VehicleManager();
            boolean flag =true; 
            while(flag){
                System.out.println(menu);
                try{
                    switch(sc.nextInt()){
                    case 1:
                        System.out.println("Enter details: regNum, color, price, manufactureDate, vehicleCategory(yyyy-MM-dd)");
                        vhm.addVehicle(sc.next(), sc.next(), sc.nextDouble(), sc.next(),sc.next());
                        break;
                    case 2:
                        vhm.removeVehicle();
                        break;
                    case 3:
                        System.out.println("Enter index: ");
                        System.out.println(vhm.getVehicle(sc.nextInt()));
                        break;
                    case 4:
                        vhm.showAll();
                        break;
                    case 5:
                        flag = false;
                        break;
                    default:
                        System.err.println("Invalid input Try again!!");
                        break;

                    }
                }catch(Exception e){
                    e.printStackTrace();
                    System.err.println("Try again!!!");
                }finally{
                    sc.nextLine();
                }
            }
        }




    }
}
