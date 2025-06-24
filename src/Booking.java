import java.time.LocalDate;

public class Booking {
    private String username;
    private int roomNumber;
    private LocalDate date;
    private double amount;

    public Booking(String username, int roomNumber, LocalDate date, double amount) {
        this.username = username;
        this.roomNumber = roomNumber;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return username + "," + roomNumber + "," + date + "," + amount;
    }

    public static Booking fromString(String data) {
        String[] parts = data.split(",");
        return new Booking(parts[0], Integer.parseInt(parts[1]),
                LocalDate.parse(parts[2]), Double.parseDouble(parts[3]));
    }
}