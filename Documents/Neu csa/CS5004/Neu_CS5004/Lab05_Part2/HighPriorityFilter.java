/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * This class defines a filter for identifying high priority tasks.
 */

import java.util.function.Predicate;

/**
 * Filter for high priority tasks.
 * This filter checks if a task is of high priority.
 */
public class HighPriorityFilter implements Predicate<Task> {
    /**
     * Tests whether a task has high priority.
     *
     * @param task The task to test.
     * @return true if the task is high priority, false otherwise.
     */
    @Override
    public boolean test(Task task) {
        return task.getPriority() == Priority.HIGH;
    }
}

