import java.util.*;
import java.time.LocalDate;

public class HotelManager {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public HotelManager() {
        loadSampleRooms();
        bookings = FileHandler.loadBookings("bookings.txt");
    }

    private void loadSampleRooms() {
        rooms.add(new Room(101, "Standard", 2000));
        rooms.add(new Room(102, "Deluxe", 3000));
        rooms.add(new Room(103, "Suite", 5000));
    }

    public void showAvailableRooms() {
        for (Room room : rooms) {
            if (room.isAvailable()) System.out.println(room);
        }
    }

    public boolean bookRoom(String username, String category) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                room.book();
                Booking booking = new Booking(username, room.getRoomNumber(), LocalDate.now(), room.getPrice());
                bookings.add(booking);
                FileHandler.saveBooking("bookings.txt", booking);
                System.out.println("✅ Room booked successfully. Payment of ₹" + room.getPrice() + " simulated.");
                return true;
            }
        }
        System.out.println("❌ No available rooms in selected category.");
        return false;
    }

    public boolean cancelBooking(String username, int roomNumber) {
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (b.toString().contains(username) && b.toString().contains(String.valueOf(roomNumber))) {
                iterator.remove();
                for (Room r : rooms) {
                    if (r.getRoomNumber() == roomNumber) r.cancel();
                }
                FileHandler.rewriteBookings("bookings.txt", bookings);
                System.out.println("🔄 Booking cancelled.");
                return true;
            }
        }
        System.out.println("❌ Booking not found.");
        return false;
    }

    public void showBookings() {
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }
}
