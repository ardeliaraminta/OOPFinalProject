package oopfinal;

import java.util.List;

public class scheduleTime {
    private int availTime;
    List<Doctors> doctors;

    public scheduleTime(int time, List<Doctors> doc) {
        availTime = time;
        doctors = doc;
    }

    public int getScheduleTime(){
        return availTime;
    }

    public List<Doctors> getDoctors(){
        return doctors;
    }

}
