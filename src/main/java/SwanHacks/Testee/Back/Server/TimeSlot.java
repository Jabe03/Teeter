package SwanHacks.Testee.Back.Server;

import java.util.Arrays;

public class TimeSlot implements Comparable<TimeSlot>{

    private static String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int day;
    private Time startTime;
    private Time endTime;
    public TimeSlot(int day, Time startTime, Time endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDay() {
        return day;
    }
    private Time getStartTime() {
        return startTime;
    }

    @Override
    public int compareTo(TimeSlot o) {
        if (day != o.getDay()) {
            return Integer.compare(this.day, o.day);
        } else {
            return startTime.compareTo(o.getStartTime());
        }
    }
    @Override
    public String toString() {
        return DAYS[day] + ": " + startTime + "-" + endTime;
    }

    public static void main(String[] args) {
        TimeSlot one = new TimeSlot(0, new Time(5,30), new Time(8, 0));
        TimeSlot two = new TimeSlot(3, new Time(5,30), new Time(8, 0));
        TimeSlot three = new TimeSlot(1, new Time(5,30), new Time(8, 0));
        TimeSlot four = new TimeSlot(0, new Time(4,30), new Time(8, 0));
        TimeSlot[] avails = {one, two, three, four};
        Arrays.sort(avails);
        System.out.println(Arrays.toString(avails));
    }
}
