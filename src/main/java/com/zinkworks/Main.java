package com.zinkworks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();
        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
        System.out.println("#####################");
        // Adventure game
        locations.put(0, new Location(0, "You are at your desk learning Java"));
        locations.put(1, new Location(1, "You are standing under a bridge"));
        locations.put(2, new Location(2, "You are at the top of a mountain"));
        locations.put(3, new Location(3, "You are inside a haunted house"));
        locations.put(4, new Location(4, "You are at the beach"));
        locations.put(5, new Location(5, "You are in a forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        //locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        //locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        //locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        //locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        //locations.get(5).addExit("Q", 0);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exists are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = s.nextLine().toUpperCase();
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You can't go that way");
            }

        }
    }
}