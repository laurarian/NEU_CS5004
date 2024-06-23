/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This class defines a filter for checking if a meeting is located at a specific location.
 */
import java.util.function.Predicate;

/**
 * Filter for meetings based on location.
 * This filter checks if a meeting is located at a specified location.
 */
public class MeetingLocationFilter implements Predicate<Meeting> {
    private String location;

    /**
     * Constructs a MeetingLocationFilter with a specific location.
     *
     * @param location The location to filter meetings by.
     */
    public MeetingLocationFilter(String location) {
        this.location = location;
    }

    /**
     * Tests whether a meeting is at a specified location.
     *
     * @param meeting The meeting to test.
     * @return true if the meeting is at the specified location, false otherwise.
     */
    @Override
    public boolean test(Meeting meeting) {
        return meeting.getLocation().equals(location);
    }
}

