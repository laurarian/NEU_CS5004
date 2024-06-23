/**
 * Name:Rong Huang
 * Assignment:Lab 5 part 1 : Linked List of Tasks
 * Date:2024-03-10
 * Driver of the TaskLinkedList
 */
public class Driver {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Step 1: Check add functionality
        // Adding tasks at top, including a completed task
        taskList.addTaskAtTop(new Task(2, "Outline thesis chapters", new Date(2024, 3, 15, 16, 0), false, Priority.HIGH));
        taskList.addTaskAtTop(new Task(1, "Complete project proposal", new Date(2024, 3, 10, 10, 0), true, Priority.HIGH)); // This task is marked as completed
        // Adding tasks at bottom, including an expired and a completed task
        taskList.addTaskAtBottom(new Task(3, "Submit ethics application", new Date(2024, 2, 27, 9, 30), true, Priority.MEDIUM)); // This task is marked as completed
        taskList.addTaskAtBottom(new Task(4, "Collect initial data", new Date(2024, 3, 1, 11, 0), false, Priority.HIGH)); // This task will be expired
        // Add task by priority
        taskList.addTaskByPriority(new Task(5, "Write introduction", new Date(2024, 3, 20, 14, 0), false, Priority.LOW));

        // Display initial list and counts
        System.out.println("Initial Tasks List:");
        System.out.println(taskList.listAllTasks());
        System.out.println("Total Tasks: " + taskList.countAllTasks());
        System.out.println("Completed Tasks: " + taskList.countCompletedTasks());
        System.out.println("High Priority Tasks: " + taskList.countTasksByPriority(Priority.HIGH));

        // Step 2: Check change date functionality
        // Changing the date of task with ID 3
        taskList.changeTaskDate(2, new Date(2024, 3, 5, 10, 0));
        System.out.println("\nAfter Changing Date of Task 3:");
        System.out.println(taskList.listAllTasks());

        // Step 3: Check getTaskByID functionality
        System.out.println("\nChecking getTaskByID Functionality:");

        // Try to find a task that we know exists
        Task foundTask = taskList.getTaskByID(3); // ID 3 was changed in Step 2
        if (foundTask != null) {
            System.out.println("Successfully found Task 3 after date change: " + foundTask);
        } else {
            System.out.println("Task 3 not found.");
        }

        // Step 4: To-do list detailed display
        // Listing all tasks, tasks by priority, and expired tasks
        System.out.println("\nDetailed Task Lists:");
        System.out.println("All Tasks in Order:");
        System.out.println(taskList.listAllTasks());
        System.out.println("\nTasks by High Priority:");
        System.out.println(taskList.listTasksByPriority(Priority.HIGH));
        // Assuming today's date for expired tasks example
        System.out.println("\nExpired Tasks before 2024-3-13 14:00:");
        System.out.println(taskList.listExpiredTasks(new Date(2024, 3, 13,14,0)));

        // Step 4: Check remove functionality
        // Remove tasks by index (Task 1 and 2)
        taskList.removeTaskAtIndex(0); // Remove the first task
        taskList.removeTaskAtIndex(0); // Remove the next first task, originally Task 2
        System.out.println("\nAfter Removing Task 1 and 2:");
        System.out.println(taskList.listAllTasks());

        // Remove all completed tasks
        taskList.removeCompletedTasks();
        System.out.println("\nAfter Removing All Completed Tasks:");
        System.out.println(taskList.listAllTasks());

        // Remove all tasks with Priority LOW
        taskList.removeTasksByPriority(Priority.LOW);
        System.out.println("\nAfter Removing All Priority LOW Tasks:");
        System.out.println(taskList.listAllTasks());

        // Finally, remove all tasks
        taskList.removeAllTasks();
        System.out.println("\nAfter Removing All Tasks:");
        System.out.println(taskList.listAllTasks() + " -> Now list should only contain an EmptyNode indicating it's empty.");
    }
}





