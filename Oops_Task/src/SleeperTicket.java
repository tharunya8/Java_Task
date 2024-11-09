public class SleeperTicket {
    public SleeperTicket(String trainNumber, String passengerName, int seatNumber, TicketStatus status) {
        super(trainNumber, passengerName, seatNumber, status);
    }

    public double calculatePrice() {
        return 75.0; // Base price for Sleeper class
    }
}
