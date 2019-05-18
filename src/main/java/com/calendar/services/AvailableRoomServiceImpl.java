package com.calendar.services;

import com.calendar.entity.Invite;
import com.calendar.entity.MeetingRoom;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AvailableRoomServiceImpl implements AvailableRoomService {

    @Override
    public Integer numberOfRoomsAvailable(List<Invite> invites) {
        return calculateRoomsRequired(invites);
    }

    @Override
    public void addMeetingRoom(String name) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setName(name);
        DBService.meetingRoomList.add(meetingRoom);
    }

    private Integer calculateRoomsRequired(List<Invite> invites) {
        Map<Integer, Integer> meetingEndTime = new TreeMap<>();
        invites.stream().forEach(invite -> {
            if(meetingEndTime.get(invite.getStartTime().getHour()) == null){
                meetingEndTime.put(invite.getStartTime().getHour(),0);
            }
            meetingEndTime.put(invite.getStartTime().getHour(),meetingEndTime.get(invite.getStartTime().getHour())+1);

            if(meetingEndTime.get(invite.getEndTime().getHour()) == null){
                meetingEndTime.put(invite.getEndTime().getHour(),0);
            }
            meetingEndTime.put(invite.getEndTime().getHour(),meetingEndTime.get(invite.getEndTime().getHour())-1);
        });

        int maxRoom = 0;

        int countTillNow = 0;

        for(Map.Entry<Integer, Integer> data : meetingEndTime.entrySet()){
            countTillNow += data.getValue();
            if(maxRoom<countTillNow){
                maxRoom = countTillNow;
            }
        }
        return maxRoom;

    }


}
