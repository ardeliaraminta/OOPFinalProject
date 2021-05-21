package oopfinal;

import java.util.List;

public class ScheduleTime {
    private int availTime;
    List<Doctors> doctors;

    public ScheduleTime(int time, List<Doctors> doc) {
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
