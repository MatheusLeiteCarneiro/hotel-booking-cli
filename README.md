# Hotel Reservation CLI 🏨

**Description:** `A Java command-line application that simulates a hotel booking system, featuring complex availability checks and OOP design.`

This project is a complete hotel reservation system built in Java. It was developed to practice and implement advanced Object-Oriented Programming (OOP) concepts, including complex class composition, "smart" enums, and date/time manipulation.

The application allows a user to book a room by checking availability based on room type, dates, and existing reservations, preventing any booking conflicts.

---

## ✨ Features

* **Guest Registration:** Gathers guest information (name and email) at the start of the session.
* **Dynamic Room Catalog:** Displays a list of available room types (`Standard`, `Family`, `Deluxe`) loaded from a "smart" Enum, showing base price, base occupancy, extra person cost, and max occupancy.
* **Occupancy Validation:** Validates that the number of guests (base + extra) does not exceed the room's maximum capacity.
* **Complex Availability Check:**
    * The core feature of the system.
    * Dynamically checks which *specific* rooms are available for a selected date range.
    * It does this by cross-referencing the hotel's main room inventory (`List<Room>`) against the central booking list (`List<Reserve>`).
    * Implements a date overlap algorithm to ensure a room is not double-booked.
* **Accurate Price Calculation:**
    * Calculates the final price based on the room's base price, the number of extra guests, and the **correct number of nights** (using `ChronoUnit.DAYS.between`).
* **Booking Confirmation:** Asks the user for final confirmation before adding the new `Reserve` object to the hotel's booking list.
* **Final Report:** Displays a full summary of all successful bookings at the end of the session.

---

## 🛠️ Technologies Used

* **Java 25**
* **IntelliJ IDEA**
* **Java Date-Time API** (`LocalDate`, `ChronoUnit`, `DateTimeFormatter`)
* **Git & GitHub** for version control.

---

## 🚀 What I Learned (Concepts Practiced)

This was a complex project that solidified several advanced concepts:

* **Advanced OOP (Composition):**
    * Designed a multi-class system where classes "have-a" relationship (Composition/Aggregation).
    * `Hotel` "has-a" `List<Room>` and a `List<Reserve>`.
    * `Reserve` "has-a" `Room` and "has-a" `Guest`.
    * This design follows the "Information Expert" principle, where the `Hotel` class acts as the central controller.
* **"Smart" Enums:**
    * Implemented `RoomType` as an enum with its own constructor, attributes (`price`, `capacity`), and methods (`defineRoomType`, `finalDailyPrice`).
    * This encapsulates all business rules (pricing, capacity) *within* the enum, keeping other classes clean.
* **Java Date-Time API:**
    * Mastered the use of `LocalDate` for handling check-in and check-out dates.
    * Implemented the `ChronoUnit.DAYS.between(start, end)` method to accurately calculate the number of nights, correctly handling the "check-out day exclusion".
* **Algorithm Design (Availability Check):**
    * The most challenging part was designing the `availableRoomList` method.
    * This involved iterating through two separate lists and implementing a date overlap algorithm: `(newEnd.isBefore(oldStart) || newStart.isAfter(oldEnd))`.
* **Professional Git Workflow:**
    * Configured a robust `.gitignore` for an IntelliJ and Eclipse project, ignoring files to maintain a clean repository.

---

## 🏁 How to Run
1.  Open your **Terminal** (or `Git Bash` on Windows).
2.  Navigate to the directory (folder) where you want to save the project.
3.  **Copy and paste** the following command into your terminal and press **Enter**:

    ```bash
    git clone https://github.com/MatheusLeiteCarneiro/hotel-reservation-cli.git
    ```
    *(This will create a new folder named `hotel-reservation-cli` with all the project files.)*
 
3. Open the project in your Java IDE.
3.  Locate and run the `Program.java` file (under `src/application/Program.java`).

---

Author: **Matheus Leite Carneiro**