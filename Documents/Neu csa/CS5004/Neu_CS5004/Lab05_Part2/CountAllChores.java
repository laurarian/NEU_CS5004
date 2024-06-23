/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Description: Implements Predicate for counting all chores regardless of their attributes or state.
 */

import java.util.function.Predicate;

public class CountAllChores implements Predicate<Chore> {
    @Override
    public boolean test(Chore chore) {
        return true; // Always returns true, so it counts all chores
    }
}

