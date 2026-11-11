package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void ifCheckInRoomShouldBeOccuppiedAndDirty() {
// arrange
        Room r1 = new Room(2, 180.00, false, false);
// act
        r1.checkIn();
// assert
        assertTrue(r1.isOccupied());
        assertTrue(r1.isDirty());

    }

    @Test
    void checkOut() {
// arrange
        Room r1 = new Room(2, 180.00, true, true);
// act
        r1.checkOut();

// assert
        assertFalse(r1.isOccupied());
        assertTrue(r1.isDirty());
    }

    @Test
    void cleanRoom() {
// arrange
        Room r1 = new Room(2, 180.00, false, true);
// act
        r1.cleanRoom();
// assert
        assertFalse(r1.isDirty());
    }
}