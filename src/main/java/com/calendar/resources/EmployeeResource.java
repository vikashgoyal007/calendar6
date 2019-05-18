package com.calendar.resources;

import com.calendar.entity.Employee;
import com.calendar.entity.EmployeeInvite;
import com.calendar.services.EmployeeService;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


@Path("/employee")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
       this.employeeService = employeeService;
    }

    @GET
    @Timed
    @Path("/invites/{name}")
    public List<EmployeeInvite> getEmployeeInvites(@PathParam("name") String name) {
        return employeeService.getEmployeeMeetings(name);
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Employee getEmployee(@PathParam("name") String name) {
        return employeeService.getEmployee(name);
    }

    @POST
    @Timed
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee(@PathParam("name") String name) {
        employeeService.addEmployee(name);
        return "Success";
    }
}
