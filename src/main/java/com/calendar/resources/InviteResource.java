package com.calendar.resources;

import com.calendar.entity.EmployeeInvite;
import com.calendar.services.AvailableRoomService;
import com.calendar.services.AvailableRoomServiceImpl;
import com.calendar.services.DBService;
import com.calendar.services.InviteService;
import com.calendar.views.CalendarInvite;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/invite")
@Produces(MediaType.APPLICATION_JSON)
public class InviteResource {

    private final InviteService inviteService;
    private final AvailableRoomService availableRoomService;

    public InviteResource(InviteService inviteService, AvailableRoomService availableRoomService) {
       this.inviteService = inviteService;
       this.availableRoomService = availableRoomService;
    }

    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addInvites(List<CalendarInvite> invites) {
        System.out.println("==== data "+invites);
        inviteService.addInvites(invites);
        return "Success";
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/required-room")
    public Integer getRequitedRooms() {
        return availableRoomService.numberOfRoomsAvailable(DBService.inviteList);
    }
}
