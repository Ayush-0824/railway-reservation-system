package org.ayushanand;

import java.time.DayOfWeek;
import java.util.*;

public class Train {
    private final int id;
    private String name;
    private Set<DayOfWeek> runningDays;
    private List<Station> stationList;
    private Set<Station> stationSet;

    public Train(int id,String name,Set<DayOfWeek> runningDays,List<Station> stationList) {
        if(id <= 0) {
            throw new IllegalArgumentException("Id must be Positive");
        }
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        if(runningDays == null || runningDays.isEmpty()) {
            throw new IllegalArgumentException("RunningDays can't be null or empty");
        }
        if(stationList == null || stationList.size() < 2) {
            throw new IllegalArgumentException("Stations must contain at least two stations");
        }
        stationSet = new HashSet<>();
        for(Station station : stationList) {
           if(station == null)
               throw new IllegalArgumentException("Station cannot be null");
           if(!stationSet.add(station))
               throw new IllegalArgumentException("Station cannot appear more than once in a train route");
        }
        this.id = id;
        this.name = name;
        this.runningDays = new HashSet<>(runningDays);
        this.stationList = new ArrayList<>(stationList);

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        this.name = name;
    }

    public Set<DayOfWeek> getRunningDays() {
        return Collections.unmodifiableSet(runningDays);
    }

    public List<Station> getStationList() {
        return Collections.unmodifiableList(stationList);
    }

    void addStation(int position,Station station){
        if(station == null) {
            throw new IllegalArgumentException("Station is invalid");
        }
        if(0 <= position && position <= stationList.size()  ) {
            if(!stationSet.add(station))
                throw new IllegalArgumentException("Station already exists");
            stationList.add(position, station);
        }else
            throw new IllegalArgumentException("Invalid Position");

    }
    void removeStation(int position){
        if( position < 0 || position >= stationList.size()){
            throw new IllegalArgumentException("Invalid position for removal");
        }
        if(stationList.size() <=2 ) {
            throw new IllegalArgumentException("Cannot remove station because less than two stations left");
        }
        Station delStation = stationList.get(position);
        stationSet.remove(delStation);
        stationList.remove(position);

    }
    public boolean addRunningDay(DayOfWeek day) {
        if(day == null) {
            throw new IllegalArgumentException("Day is invalid");
        }
        return runningDays.add(day);
    }
    public boolean removeRunningDay(DayOfWeek day) {
        if (day == null) {
            throw new IllegalArgumentException("Day is invalid");
        }
        if (!runningDays.contains(day)) {
            return false;
        }
        if (runningDays.size() == 1) {
            throw new IllegalStateException("Train must run for at least 1 day");
        }
        return runningDays.remove(day);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if (!(o instanceof Train train)) return false;
        return id == train.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
