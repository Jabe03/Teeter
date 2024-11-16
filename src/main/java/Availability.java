import java.lang.reflect.Array;
import java.util.Arrays;

public class Availability implements Comparable<Availability>{

    private static String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int day;
    private Time startTime;
    private Time endTime;
    public Availability( int day, Time startTime, Time endTime) {
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
    public int compareTo(Availability o) {
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
        Availability one = new Availability(0, new Time(5,30), new Time(8, 0));
        Availability two = new Availability(3, new Time(5,30), new Time(8, 0));
        Availability three = new Availability(1, new Time(5,30), new Time(8, 0));
        Availability four = new Availability(0, new Time(4,30), new Time(8, 0));
        Availability[] avails = {one, two, three, four};
        Arrays.sort(avails);
        System.out.println(Arrays.toString(avails));
    }
}
