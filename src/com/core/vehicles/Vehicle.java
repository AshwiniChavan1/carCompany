package com.core.vehicles;
import java.time.LocalDate;




public class Vehicle {
    
    private String regNum;
    private String color;
    private double price;
	private LocalDate manufactureDate;
	//Vehicle HAS-A Category (many to one)
	//Category ---> Vehicle (one ---> many)
	private Category vehicleCategory;
	
    public Vehicle() {
    }

    protected Vehicle(String regNum, String color, double price, LocalDate manufactureDate, Category vehicleCategory) {
        this.regNum = regNum;
        this.color = color;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.vehicleCategory = vehicleCategory;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    



    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Category getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(Category vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }


    @Override
    public String toString() {
        return "Vehicle [color=" + color + ", manufactureDate=" + manufactureDate + ", price=" + price + ", regNum="
                + regNum + ", vehicleCategory=" + vehicleCategory + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((regNum == null) ? 0 : regNum.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Vehicle))
            return false;
        Vehicle other = ((Vehicle) o);
        if (this.regNum == null || other.regNum == null)
            return false;
        return this.regNum.equals(other.regNum);
    }

}
