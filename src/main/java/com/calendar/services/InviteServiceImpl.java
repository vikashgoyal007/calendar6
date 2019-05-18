package com.calendar.services;

import com.calendar.entity.Employee;
import com.calendar.entity.EmployeeInvite;
import com.calendar.entity.Invite;
import com.calendar.views.CalendarInvite;

import java.time.LocalDateTime;
import java.util.List;

public class InviteServiceImpl implements  InviteService {

    @Override
    public void addInvites(List<CalendarInvite> calendarInviteList) {
        calendarInviteList.forEach(calendarInvite -> {
            Invite invite = new Invite();
            invite.setStartTime(LocalDateTime.of(2019,05,18,calendarInvite.getStartHour(),0));
            invite.setEndTime(LocalDateTime.of(2019,05,18,calendarInvite.getEndHour(),0));
            DBService.inviteList.add(invite);

            calendarInvite.getEmployeeList().forEach(employee -> {
                Employee meetingEmployee = DBService.employeeList.stream().
                        filter(employee1 -> employee1.getName().equals(employee)).findAny().get();
                EmployeeInvite employeeInvite = new EmployeeInvite();
                employeeInvite.setEmployee(meetingEmployee);

                employeeInvite.setInvite(invite);

                DBService.employeeInviteList.add(employeeInvite);

            });

        });
    }
}
