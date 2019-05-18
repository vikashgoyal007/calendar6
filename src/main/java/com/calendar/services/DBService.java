package com.calendar.services;

import com.calendar.entity.Employee;
import com.calendar.entity.EmployeeInvite;
import com.calendar.entity.Invite;
import com.calendar.entity.MeetingRoom;

import java.util.ArrayList;
import java.util.List;

public class DBService {

    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Invite> inviteList = new ArrayList<>();
    public static List<MeetingRoom> meetingRoomList = new ArrayList<>();
    public static List<EmployeeInvite> employeeInviteList = new ArrayList<>();

}
