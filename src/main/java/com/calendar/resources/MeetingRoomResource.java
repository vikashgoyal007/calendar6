package com.calendar.resources;

import com.calendar.entity.EmployeeInvite;
import com.calendar.services.AvailableRoomService;
import com.calendar.views.CalendarInvite;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/meetingroom")
@Produces(MediaType.APPLICATION_JSON)
public class MeetingRoomResource {

    private final AvailableRoomService availableRoomService;

    public MeetingRoomResource(AvailableRoomService availableRoomService) {
       this.availableRoomService = availableRoomService;
    }

    @POST
    @Timed
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee(@PathParam("name") String name) {
        availableRoomService.addMeetingRoom(name);
        return "Success";
    }
}
