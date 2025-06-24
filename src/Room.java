public class Room {
    private int roomNumber;
    private String category; // Standard, Deluxe, Suite
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    public void book() { isAvailable = false; }
    public void cancel() { isAvailable = true; }

    @Override
    public String toString() {
        return "Room #" + roomNumber + " [" + category + "] - ₹" + price +
                " - " + (isAvailable ? "Available" : "Booked");
    }
}