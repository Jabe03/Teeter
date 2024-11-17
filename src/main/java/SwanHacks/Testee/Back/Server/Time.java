package SwanHacks.Testee.Back.Server;

public class Time implements Comparable<Time> {
    private Integer hour;
    private Integer minute;
    private Integer totalMinutes;

    public Time(int hour, int minute){
        this(hour*60 + minute);
    }
    public Time(int totalMinutes){
        this.hour = totalMinutes / 60;
        this.minute = totalMinutes - (hour * 60);
        this.totalMinutes = totalMinutes;
    }
    public int getTotalMinutes(){
        return totalMinutes;
    }

    /**
     * @param other other timestamp
     * @return 1 if greater, -1 if less, 0 if equal
     */
    public int compare(Time other) {
        if (totalMinutes > other.getTotalMinutes()) {
            return 1;
        } else if (totalMinutes < other.getTotalMinutes()) {
            return -1;
        } else { return 0; }
    }

    public boolean isValid() {
        if (totalMinutes >= 0 && totalMinutes < 1440) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (minute < 10) {
            return hour.toString() + ":0" + minute.toString();
        } else {
            return hour.toString() + ":" + minute.toString();
        }
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(this.totalMinutes, o.totalMinutes);
    }

    public static void main(String[] args) {
        Time seven = new Time(6,50);
        Time sven = new Time(6,60);
        System.out.println(sven.compareTo(seven));
    }
}
