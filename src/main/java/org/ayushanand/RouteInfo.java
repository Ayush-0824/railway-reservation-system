package org.ayushanand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RouteInfo {
    private final Station source;
    private final Station destination;
    private Set<Train> availableTrains;
    private int fare;

    public RouteInfo(Station source, Station destination, Set<Train> availableTrains, int fare) {
        if(source == null || destination == null || source.equals(destination)){
            throw new IllegalArgumentException("Either source or destination is invalid or they are same");
        }
        if(availableTrains == null)
            throw new IllegalArgumentException("Available Trains is invalid");
        if(fare < 0)
            throw new IllegalArgumentException("fare can't be negative");
        this.source = source;
        this.destination = destination;
        this.availableTrains = new HashSet<>(availableTrains);
        this.fare = fare;
    }

    public Station getSource() {
        return source;
    }

    public Station getDestination() {
        return destination;
    }

    public Set<Train> getAvailableTrains() {
        return Collections.unmodifiableSet(availableTrains);
    }

    public int getFare() {
        return fare;
    }

    public boolean addAvailableTrain(Train train) {
        if(train == null)
            throw new IllegalArgumentException("Train is invalid");
        return availableTrains.add(train);
    }
    public boolean removeAvailableTrain(Train train) {
        if(train == null)
            throw new IllegalArgumentException("Train is invalid");
        return availableTrains.remove(train);
    }
    public void updateFare(int fare) {
        if(fare < 0)
            throw new IllegalArgumentException("Fare can't be negative");
        this.fare = fare;
    }
}
