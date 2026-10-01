package org.ayushanand;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Station delhi = new Station("DEL","Delhi");
        Station agra = new Station("AGR","Agra");
        Station gwalior = new Station("GWL","Gwalior");
        Station jhansi = new Station("JHS", "Jhansi");
        Station bhopal = new Station("BPL","Bhopal");


        Train train1 = new Train(
                101,
                "Delhi Express",
                new HashSet<DayOfWeek>(List.of(DayOfWeek.MONDAY,DayOfWeek.SATURDAY)),
                new ArrayList<Station>(List.of(delhi,agra,gwalior,jhansi,bhopal)));
        Train train2 = new Train(
                102,
                "Jhansi Express",
                new HashSet<DayOfWeek>(List.of(DayOfWeek.MONDAY,DayOfWeek.SATURDAY)),
                new ArrayList<Station>(List.of(delhi,agra,jhansi)));
        Train train3 = new Train(
                103,
                "Agra Express",
                new HashSet<DayOfWeek>(List.of(DayOfWeek.MONDAY,DayOfWeek.SATURDAY)),
                new ArrayList<Station>(List.of(jhansi,gwalior,agra)));
        Train train4 = new Train(
                104,
                "Bhopal Express",
                new HashSet<DayOfWeek>(List.of(DayOfWeek.MONDAY,DayOfWeek.SATURDAY)),
                new ArrayList<Station>(List.of(delhi,gwalior,bhopal)));
        RailwaySystem system = new RailwaySystem();
        system.addStation(delhi);
        system.addStation(agra);
        system.addStation(gwalior);
        system.addStation(jhansi);
        system.addStation(bhopal);

        system.addTrain(train1);
        system.addTrain(train2);
        system.addTrain(train3);
        system.addTrain(train4);

        RouteInfo info1 = system.findAvailableTrains(agra,jhansi);
        System.out.println("Available Trains between "+ agra.getName() +" & "+jhansi.getName()+" :");
        for(Train train : info1.getAvailableTrains()) {
            System.out.println(train.getName());
        }
        RouteInfo info2 = system.findAvailableTrains(jhansi,agra);
        System.out.println();
        System.out.println("Available Trains between "+ jhansi.getName() +" & "+agra.getName()+" :");
        for(Train train : info2.getAvailableTrains()) {
            System.out.println(train.getName());
        }
        RouteInfo info3 = system.findAvailableTrains(agra,bhopal);
        System.out.println();
        System.out.println("Available Trains between "+ agra.getName() +" & "+bhopal.getName()+" :");
        for(Train train : info3.getAvailableTrains()) {
            System.out.println(train.getName());
        }
        RouteInfo info4 = system.findAvailableTrains(bhopal,agra);
        System.out.println();
        System.out.println("Available Trains between "+ bhopal.getName() +" & "+agra.getName()+" :");
        for(Train train : info4.getAvailableTrains()) {
            System.out.println(train.getName());
        }
        try {
            RouteInfo info5 = system.findAvailableTrains(agra, agra);
            System.out.println();
            System.out.println("Available Trains between " + agra.getName() + " & " + agra.getName() + " :");
            for (Train train : info5.getAvailableTrains()) {
                System.out.println(train.getName());
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Error Message :"+e.getMessage());
        }
        try {
            Station patna = new Station("PAT", "Patna");
            RouteInfo info6 = system.findAvailableTrains(agra, patna);
            System.out.println();
            System.out.println("Available Trains between " + agra.getName() + " & " + patna.getName() + " :");
            for (Train train : info6.getAvailableTrains()) {
                System.out.println(train.getName());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error Message :"+e.getMessage());
        }

    }
}