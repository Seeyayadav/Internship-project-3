import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelManager manager = new HotelManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("🏨 Welcome to Java Hotel Booking System");
        System.out.print("Enter your name: ");
        User user = new User(sc.nextLine());

        while (true) {
            System.out.println("\n1. View Available Rooms\n2. Book Room\n3. Cancel Booking\n4. View All Bookings\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> manager.showAvailableRooms();
                case 2 -> {
                    System.out.print("Enter category (Standard/Deluxe/Suite): ");
                    String cat = sc.nextLine();
                    manager.bookRoom(user.getUsername(), cat);
                }
                case 3 -> {
                    System.out.print("Enter room number to cancel: ");
                    int roomNum = sc.nextInt();
                    manager.cancelBooking(user.getUsername(), roomNum);
                }
                case 4 -> manager.showBookings();
                case 5 -> {
                    System.out.println("👋 Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid option.");
            }
        }
    }
}
