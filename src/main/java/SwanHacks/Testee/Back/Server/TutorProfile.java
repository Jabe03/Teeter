package SwanHacks.Testee.Back.Server;

public class TutorProfile extends Profile {
    private String title; // Major in/
    private Float rate;
    private Float rating;
    private int numOfRatings;

    boolean active = false; // whether tutor is available for office hours

    public TutorProfile(String name, String[] courses, String location, TimeSlot[] availability, String bio, String title, Float rate) {
        super(name, courses, location, availability, bio);
        rating = null;
        numOfRatings = 0;
        this.title = title;
        this.rate = rate;
    }

    public void setNewRating(Float newRating) {
        if (rating == null) {
            rating = newRating;
            numOfRatings ++;
            return;
        }
        numOfRatings ++;
        rating = (Float) ((rating + newRating) / (float)numOfRatings);
    }

    public Float getRating() {
        return rating;
    }
    public int numOfRatings() {
        return numOfRatings;
    }

    public void checkIn() {
        active = true;
    }

    public void checkOut() {
        active = false;
    }

    public boolean isAvailabile() {
        return active;
    }
}
