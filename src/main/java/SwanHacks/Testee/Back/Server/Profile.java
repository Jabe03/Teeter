package SwanHacks.Testee.Back.Server;

import java.util.UUID;

public class Profile {
    String name;
    String[] courses;
    String location;
    TimeSlot[] availability;
    String bio;
    UUID id;

    public Profile(String name, String[] courses, String location, TimeSlot[] availability,
                   String bio, UUID accountID) {
        this.name = name;
        this.courses = courses;
        this.location = location;
        this.availability = availability;
        this.bio = bio;
        this.id = accountID;
    }

    public Profile(String name, String[] courses, String location, TimeSlot[] availability, String bio) {
        this.name = name;
        this.courses = courses;
        this.location = location;
        this.availability = availability;
        this.bio = bio;
    }
}
