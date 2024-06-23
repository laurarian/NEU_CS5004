/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Description: Filter for not completed chores.This filter checks if a chore has not been completed.
 */

import java.util.function.Predicate;

public class ChoreNotDoneFilter implements Predicate<Chore> {

    /**
     * Tests whether a chore is not completed.
     *
     * @param chore The chore to test.
     * @return true if the chore is not completed, false otherwise.
     */
    @Override
    public boolean test(Chore chore) {
        return !chore.isDone();  // Returns true for chores that are not done
    }
}
