public class EconomyTicket {
    public EconomyTicket(String trainNumber, String passengerName, int seatNumber, TicketStatus status) {
        super(trainNumber, passengerName, seatNumber, status);
    }

    public double calculatePrice() {
        return 50.0; // Base price for Economy class
    }

}
