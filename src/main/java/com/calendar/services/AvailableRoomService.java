package com.calendar.services;

import com.calendar.entity.Invite;

import java.util.List;

public interface AvailableRoomService {
    Integer numberOfRoomsAvailable(List<Invite> invites);

    void addMeetingRoom(String name);
}
