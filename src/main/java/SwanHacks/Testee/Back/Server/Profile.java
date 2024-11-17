package SwanHacks.Testee.Back.Server;

public class Profile {
    String name;
    String[] courses;
    String location;
    TimeSlot[] availability;
    String bio;

    public Profile(String name, String[] courses, String location, TimeSlot[] availability,
                   String bio) {
        this.name = name;
        this.courses = courses;
        this.location = location;
        this.availability = availability;
        this.bio = bio;
    }
}
