For compiling use:
mvn clean install

For running use:
java -jar target/calendar-1.0-SNAPSHOT.jar server calendar.yml

After will expose api:
1. POST : http://localhost:8080/employee/vikash -- for adding employee with name 'vikash'
2. GET  : http://localhost:8080/employee/vikash -- get employee
3. POST : http://localhost:8080/invite -- for posting invites like
        Payload : [{
                      "startHour" : 9,
                      "endHour" : 18,
                      "employeeList" : ["vikash"]
                  }
                  ]
4. GET  : http://localhost:8080/invite/required-room -- for getting required room for above invites
5. POST : http://localhost:8080/meetingroom/m1 -- for adding new room with name 'm1'