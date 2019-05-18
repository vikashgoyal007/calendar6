package com.calendar;

import com.calendar.resources.CalendarResource;
import com.calendar.resources.EmployeeResource;
import com.calendar.resources.InviteResource;
import com.calendar.resources.MeetingRoomResource;
import com.calendar.services.AvailableRoomService;
import com.calendar.services.AvailableRoomServiceImpl;
import com.calendar.services.EmployeeServiceImpl;
import com.calendar.services.InviteServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CalendarApplication extends Application<CalendarConfiguration>  {

    public static void main(String[] args) throws Exception {
        new CalendarApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<CalendarConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(CalendarConfiguration configuration,
                    Environment environment) {
        final CalendarResource resource = new CalendarResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final EmployeeResource employeeResource = new EmployeeResource(new EmployeeServiceImpl());
        AvailableRoomService availableRoomService = new AvailableRoomServiceImpl();
        final InviteResource inviteResource = new InviteResource(new InviteServiceImpl(),availableRoomService);
        final MeetingRoomResource meetingRoomResource = new MeetingRoomResource(availableRoomService);

        environment.jersey().register(resource);
        environment.jersey().register(employeeResource);
        environment.jersey().register(inviteResource);
        environment.jersey().register(meetingRoomResource);
    }
}
