package org.ayushanand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RailwaySystem {
    private final Set<Station> stations;
    private final Set<Train> trains;

    public RailwaySystem() {
        this.stations = new HashSet<>();
        this.trains = new HashSet<>();
    }

    public Set<Station> getStations() {
        return Collections.unmodifiableSet(stations);
    }
    public Set<Train> getTrains() {
        return Collections.unmodifiableSet(trains);
    }
    public void addStation(Station station) {
        if(station == null)
            throw new IllegalArgumentException("Station is invalid");
        if(!stations.add(station))
            throw new IllegalArgumentException("Station with code "+ station.getCode() + " already exists");
    }
    public void addTrain(Train train) {
        if(train == null)
            throw new IllegalArgumentException("Train is invalid");
        for(Station station : train.getStationList()) {
            if(!stations.contains(station))
                throw new IllegalArgumentException("Register station with code : "+ station.getCode() + ",first");
        }
        if(!trains.add(train))
            throw new IllegalArgumentException("Train is already registered");
    }
    public void addStationToTrain(int position,Station station,Train train) {
        if(train == null)
            throw new IllegalArgumentException("Train is invalid");
        if(station == null)
            throw new IllegalArgumentException("Station is invalid");
        if(!trains.contains(train))
            throw new IllegalArgumentException("Register Train with id "+ train.getId() + " first");
        if(!stations.contains(station))
            throw new IllegalArgumentException("Register station with code :"+ station.getCode() + " first");
        train.addStation(position,station);
    }
    public void removeStationFromTrain(int position,Train train) {
        if(train == null)
            throw new IllegalArgumentException("Train is invalid");
        if(!trains.contains(train))
            throw new IllegalArgumentException("Register Train with id "+ train.getId() + " first");
        train.removeStation(position);
    }
    public RouteInfo findAvailableTrains(Station source,Station destination) {
        if(source == null)
            throw new IllegalArgumentException("source is invalid");
        if(destination == null)
            throw new IllegalArgumentException("destination is invalid");
        if(source.equals(destination))
            throw new IllegalArgumentException("Source & Destination are same");
        if(!stations.contains(source))
            throw new IllegalArgumentException("Source station doesn't exist");
        if(!stations.contains(destination))
            throw new IllegalArgumentException("Destination station doesn't exist");

        Set<Train> availableTrains = new HashSet<>();
        for(Train train : trains){
            int sourceIndex = -1;
            int destinationIndex = -1;
            int index=0;
            for(Station station : train.getStationList()){
                if(station.equals(source))
                    sourceIndex = index;
                if(station.equals(destination))
                    destinationIndex = index;
                if(sourceIndex !=-1 && destinationIndex !=-1)
                    break;
                index++;
            }
            if(sourceIndex !=-1 && destinationIndex !=-1 && sourceIndex < destinationIndex) {
                availableTrains.add(train);
            }
        }
        return new RouteInfo(source,destination,availableTrains,500);
    }
}
