
package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        // ============================
        // ROOM TESTS
        // ============================

        System.out.println("===== ROOM TESTS =====");

        Room room = new Room(2, 180, false, false);

        System.out.println("Initially available: " + room.isAvailable());

        // Guest checks in
        room.checkIn();
        System.out.println("Occupied after check-in: " + room.isOccupied());
        System.out.println("Dirty after check-in: " + room.isDirty());

        // Try cleaning while occupied
        room.cleanRoom();

        // Guest checks out
        room.checkOut();
        System.out.println("Occupied after check-out: " + room.isOccupied());

        // Try checking in before cleaning
        room.checkIn();

        // Housekeeper cleans room
        room.cleanRoom();
        System.out.println("Available after cleaning: " + room.isAvailable());

        // Guest can check in again
        room.checkIn();
        System.out.println("Occupied again: " + room.isOccupied());


        // ============================
        // EMPLOYEE TESTS
        // ============================

        System.out.println("\n===== EMPLOYEE TESTS =====");

        Employee employee = new Employee(
                1, "John", "Front Desk", 20.0, 0
        );

        // Regular punch in / punch out
        employee.punchIn(10);
        employee.punchOut(14);

        System.out.println("Regular hours: " + employee.getRegularHours());

        // Bonus: automatic time card
        employee.punchTimeCard(15);
        employee.punchTimeCard(18);

        System.out.println("Total regular hours: " + employee.getRegularHours());
        System.out.println("Overtime hours: " + employee.getOvertimeHours());
        System.out.println("Total pay: $" + employee.getTotalPay());


        // ============================
        // RESERVATION TESTS
        // ============================

        System.out.println("\n===== RESERVATION TESTS =====");

        Reservation reservation = new Reservation(
                "king", 2, true
        );

        System.out.println("Room type: " + reservation.getRoomType());
        System.out.println("Price per night: $" + reservation.getPrice());
        System.out.println("Reservation total: $" + reservation.getReservationTotal());

        // ============================
        // EXERCISE 3 - EMPLOYEE
        // ============================

        System.out.println("\n===== EMPLOYEE OVERLOADING TESTS =====");

        Employee employee2 = new Employee(
                2, "Alice", "Reception", 20.0, 0
        );

        // Manual methods
        employee2.punchIn(10);
        employee2.punchOut(14);

        System.out.println("Hours worked: " + employee2.getRegularHours());
        System.out.println("Total pay: $" + employee2.getTotalPay());

        // Overloaded methods
        employee2.punchIn();
        employee2.punchOut();

        System.out.println("Updated hours: " + employee2.getRegularHours());


        // ============================
        // EXERCISE 3 - HOTEL
        // ============================

        System.out.println("\n===== HOTEL TESTS =====");

        // First constructor
        Hotel hotel1 = new Hotel("Marriott", 10, 20);

        System.out.println("Available suites: " + hotel1.getAvailableSuites());
        System.out.println("Available rooms: " + hotel1.getAvailableRooms());

        // Successful booking
        System.out.println("Book 3 suites: " + hotel1.bookRoom(3, true));
        System.out.println("Remaining suites: " + hotel1.getAvailableSuites());

        // Unsuccessful booking
        System.out.println("Book 8 suites: " + hotel1.bookRoom(8, true));
        System.out.println("Remaining suites: " + hotel1.getAvailableSuites());

        // Basic room booking
        System.out.println("Book 5 rooms: " + hotel1.bookRoom(5, false));
        System.out.println("Remaining rooms: " + hotel1.getAvailableRooms());


        // Second constructor
        System.out.println("\n===== SECOND CONSTRUCTOR =====");

        Hotel hotel2 = new Hotel("Hilton", 10, 20, 3, 5);

        System.out.println("Available suites: " + hotel2.getAvailableSuites());
        System.out.println("Available rooms: " + hotel2.getAvailableRooms());

    }
}
