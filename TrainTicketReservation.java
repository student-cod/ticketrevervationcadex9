

import java.util.Scanner;

public class TrainTicketReservation {

    static final int NUM_ROUTES = 5; // Number of available train routes
    static final int NUM_SEATS_PER_ROUTE = 30; // Seats per route
    static String[] routes = new String[NUM_ROUTES];
    static int[][] seats = new int[NUM_ROUTES][NUM_SEATS_PER_ROUTE];

    public static void main(String[] args) {
        initializeRoutes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Train Ticket Reservation System");
            displayRoutes();
            int routeChoice = getRouteChoice(scanner);

            if (routeChoice >= 0 && routeChoice < NUM_ROUTES) {
                displaySeating(routeChoice);
                int seatChoice = getSeatChoice(scanner);

                if (reserveSeat(routeChoice, seatChoice)) {
                    System.out.println("Seat reserved successfully. Enjoy your journey!");
                } else {
                    System.out.println("Seat is already reserved. Please choose another seat.");
                }
            } else {
                System.out.println("Invalid route choice. Please try again.");
            }
        }
    }

    static void initializeRoutes() {
        routes[0] = "Bangalore to Chennai";
        routes[1] = "Delhi to Lucknow";
        routes[2] = "Hyderabad to Goa";
        routes[3] = "Mysore to Bangalore";
        routes[4] = "Chennai to Thiruvananthapuram";
    }

    static void displayRoutes() {
        System.out.println("Select a train route to reserve tickets for:");
        for (int i = 0; i < NUM_ROUTES; i++) {
            System.out.println((i + 1) + ". " + routes[i]);
        }
    }

    static int getRouteChoice(Scanner scanner) {
        System.out.print("Enter your choice (1-" + NUM_ROUTES + "): ");
        return scanner.nextInt() - 1;
    }

    static void displaySeating(int routeChoice) {
        System.out.println("Seating for " + routes[routeChoice] + ":");
        for (int seat = 0; seat < NUM_SEATS_PER_ROUTE; seat++) {
            System.out.print(seats[routeChoice][seat] == 0 ? "O " : "X ");
            if ((seat + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    static int getSeatChoice(Scanner scanner) {
        System.out.print("Enter seat number (1-" + NUM_SEATS_PER_ROUTE + "): ");
        return scanner.nextInt() - 1;
    }

    static boolean reserveSeat(int routeChoice, int seatChoice) {
        if (seats[routeChoice][seatChoice] == 0) {
            seats[routeChoice][seatChoice] = 1;
            return true;
        }
        return false;
    }
}