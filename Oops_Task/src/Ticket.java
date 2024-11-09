public class Ticket {
    private String trainNumber;
    private String passengerName;
    private int seatNumber;
    private double price;
    private TicketStatus status;

    public Ticket(String trainNumber, String passengerName, int seatNumber, TicketStatus status) {
        this.trainNumber = trainNumber;
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    // Polymorphic method
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Train: " + trainNumber + ", Passenger: " + passengerName + ", Seat: " + seatNumber +
                ", Price: " + price + ", Status: " + status;
    }
}
