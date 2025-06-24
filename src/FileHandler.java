import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Booking> loadBookings(String filename) {
        List<Booking> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Booking.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("📂 Booking file not found. Starting fresh.");
        }
        return list;
    }

    public static void saveBooking(String filename, Booking booking) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(booking.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error saving booking.");
        }
    }

    public static void rewriteBookings(String filename, List<Booking> bookings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Booking b : bookings) {
                bw.write(b.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error rewriting bookings.");
        }
    }
}
