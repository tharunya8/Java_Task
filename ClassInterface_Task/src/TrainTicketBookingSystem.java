import java.util.*;

class Train {
    String trainName;
    String destination;
    Integer availableSeats;  // Wrapper class
    Double ticketCost;       // Wrapper class

    public Train(String trainName, String destination, int availableSeats, double ticketCost) {
        this.trainName = trainName;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.ticketCost = ticketCost;
    }
}

public class TrainTicketBookingSystem {
    public static void main(String[] args) {
        List<Train> trains = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Train Ticket Booking System!");

        // Dynamically add trains to the system
        System.out.println("Enter the number of trains to add:");
        int numTrains = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 1; i <= numTrains; i++) {
            System.out.println("Enter details for Train " + i + " (format: Name, Destination, AvailableSeats, TicketCost):");
            String trainInput = scanner.nextLine();
            StringTokenizer trainTokenizer = new StringTokenizer(trainInput, ",");

            // Parse train details
            String trainName = trainTokenizer.nextToken().trim();
            String destination = trainTokenizer.nextToken().trim();
            int availableSeats = Integer.parseInt(trainTokenizer.nextToken().trim());
            double ticketCost = Double.parseDouble(trainTokenizer.nextToken().trim());

            // Add train to list
            trains.add(new Train(trainName, destination, availableSeats, ticketCost));
        }

        // Allow user to perform multiple bookings
        String continueBooking;
        do {
            System.out.println("\nEnter booking details (e.g., Destination: New York; Seat Type: Economy):");
            String userInput = scanner.nextLine();

            StringTokenizer tokenizer = new StringTokenizer(userInput, ";:");
            String destination = "", seatType = "";

            // Process each key-value pair safely
            while (tokenizer.hasMoreTokens()) {
                String key = tokenizer.nextToken().trim();
                if (tokenizer.hasMoreTokens()) {
                    String value = tokenizer.nextToken().trim();
                    if (key.equalsIgnoreCase("Destination")) destination = value;
                    if (key.equalsIgnoreCase("Seat Type")) seatType = value;
                } else {
                    System.out.println("Invalid input format. Please use 'Key: Value; Key: Value'.");
                    return;
                }
            }

            // Search for matching train with available seats
            Iterator<Train> iterator = trains.iterator();
            boolean trainFound = false;

            while (iterator.hasNext()) {
                Train train = iterator.next();
                if (train.destination.equalsIgnoreCase(destination) && train.availableSeats > 0) {
                    System.out.println("Train found: " + train.trainName + " to " + train.destination);

                    // Book seat and build confirmation message
                    train.availableSeats -= 1;

                    StringBuffer confirmation = new StringBuffer();
                    confirmation.append("Booking Confirmed!\n");
                    confirmation.append("Train: ").append(train.trainName).append("\n");
                    confirmation.append("Destination: ").append(train.destination).append("\n");
                    confirmation.append("Seat Type: ").append(seatType).append("\n");
                    confirmation.append("Cost: $").append(train.ticketCost).append("\n");

                    System.out.println(confirmation.toString());
                    trainFound = true;
                    break;
                }
            }

            if (!trainFound) {
                System.out.println("No trains available for the given destination.");
            }

            System.out.println("Do you want to make another booking? (yes/no)");
            continueBooking = scanner.nextLine();

        } while (continueBooking.equalsIgnoreCase("yes"));

        scanner.close();
        System.out.println("Thank you for using the Train Ticket Booking System!");
    }
}
