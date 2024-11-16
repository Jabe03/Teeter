public class User {
    String name;
    String[] courses;
    String location;
    Availability[] availability;
    String bio;

    public User(String name, String[] courses, String location, Availability[] availability,
                    String bio) {
        this.name = name;
        this.courses = courses;
        this.location = location;
        this.availability = availability;
        this.bio = bio;
    }
}
