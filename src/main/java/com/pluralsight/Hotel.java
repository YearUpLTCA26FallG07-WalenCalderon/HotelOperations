package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public int getAvailableSuites(){
        return this.numberOfSuites - this.bookedSuites;

    }

    public int getAvailableRooms(){
        return this.numberOfRooms - this.bookedBasicRooms;
    }

    public Boolean bookRoom(int roomCount, boolean suite){
         //todo

        if(roomCount <= getAvailableRooms() && !suite){
            this.bookedBasicRooms += roomCount;
            return true;

        }else if(roomCount <= getAvailableSuites() && suite){
            this.bookedSuites += roomCount;
            return true;
        } else if(roomCount > getAvailableSuites()){

            System.out.println("No suites Available: "+ getAvailableSuites());
        }else if (suite && roomCount > getAvailableRooms()){
            System.out.println("No rooms Available: "+ getAvailableRooms());
        }

        return null;
    }


}
