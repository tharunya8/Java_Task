import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TrainBookingSystem {
    private List<Ticket> bookedTickets;

    public TrainBookingSystem() {
        bookedTickets = new ArrayList<>();
    }

    public void bookTicket(Ticket ticket) {
        ticket.setPrice(ticket.calculatePrice());
        ticket.setStatus(TicketStatus.BOOKED);
        bookedTickets.add(ticket);
        System.out.println("Ticket booked: " + ticket);
    }

    public void displayBookedTickets() {
        Iterator<Ticket> iterator = bookedTickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            System.out.println(ticket);
        }
    }

    public static Ticket createTicketDynamically(String ticketType, String trainNumber, String passengerName, int seatNumber) {
        switch (ticketType.toLowerCase()) {
            case "economy":
                return new EconomyTicket(trainNumber, passengerName, seatNumber, TicketStatus.BOOKED);
            case "business":
                return new BusinessTicket(trainNumber, passengerName, seatNumber, TicketStatus.BOOKED);
            case "sleeper":
                return new SleeperTicket(trainNumber, passengerName, seatNumber, TicketStatus.BOOKED);
            default:
                throw new IllegalArgumentException("Invalid ticket type");
        }
    }

    public static void main(String[] args) {
        TrainBookingSystem bookingSystem = new TrainBookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Ticket Type (Economy/Business/Sleeper) or 'exit' to stop: ");
            String ticketType = scanner.nextLine();
            if (ticketType.equalsIgnoreCase("exit")) break;

            System.out.println("Enter Train Number: ");
            String trainNumber = scanner.nextLine();

            System.out.println("Enter Passenger Name: ");
            String passengerName = scanner.nextLine();

            System.out.println("Enter Seat Number: ");
            int seatNumber = Integer.parseInt(scanner.nextLine());

            Ticket ticket = createTicketDynamically(ticketType, trainNumber, passengerName, seatNumber);
            bookingSystem.bookTicket(ticket);
        }

        System.out.println("Booked Tickets:");
        bookingSystem.displayBookedTickets();
    }
}
