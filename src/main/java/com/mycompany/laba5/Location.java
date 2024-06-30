package com.mycompany.laba5;

public class Location {


    int locationsCount;

    public int getRoundsInLocation() {
        return roundsInLocation;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void increseCurrentLocationsCount() {
        this.currentLocationsCount = this.currentLocationsCount+1;
    }

    public int getCurrentLocationsCount() {
        return currentLocationsCount;
    }

    private int currentLocationsCount = 0;
    private int roundsInLocation;
    private int currentRound;
    public void initLocation(int locationCount){
        this.locationsCount=locationCount;
        if(Math.random()<0.5){
            this.roundsInLocation=2;
        }
        else {
            this.roundsInLocation=3;
        }
        this.currentRound=1;
        this.currentLocationsCount=0;
    }
    public void prepareNewLocation() {
        if (currentLocationsCount < locationsCount) {

            this.currentLocationsCount++;
            if(Math.random()<0.5){
                roundsInLocation=2;
            }
            else {
                roundsInLocation=3;
            }

        }

    }

}
