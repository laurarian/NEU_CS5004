/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Tests for GenericNode.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGenericNode {
    private GenericNode<Chore> firstNode;
    private GenericNode<Chore> secondNode;
    private Chore chore1;
    private Chore chore2;

    @Before
    public void setUp() {
        chore1 = new Chore("Clean", "Weekly", false);
        chore2 = new Chore("Cook", "Daily", true);
        secondNode = new GenericNode<>(chore2, new EmptyNode<>());
        firstNode = new GenericNode<>(chore1, secondNode);
    }

    @Test
    public void testGetData() {
        assertEquals("Data should match the chore assigned", chore1, firstNode.getData());
    }

    @Test
    public void testGetNext() {
        assertEquals("Next node should match the one set in setUp", secondNode, firstNode.getNext());
    }

    @Test
    public void testSetNext() {
        GenericNode<Chore> thirdNode = new GenericNode<>(new Chore("Wash", "Monthly", false), new EmptyNode<>());
        firstNode.setNext(thirdNode);
        assertEquals("Next node should be the one set by setNext method", thirdNode, firstNode.getNext());
    }

    @Test
    public void testCountIf() {
        int count = firstNode.countIf(new ChoreNotDoneFilter());
        assertEquals("Should count chores that are not done", 1, count);
    }

    @Test
    public void testFilter() {
        Node<Chore> filtered = firstNode.filter(new ChoreNotDoneFilter());
        assertEquals("Filtered node should contain only the not done chores", chore1, filtered.getData());
    }

    @Test
    public void testGetNodeAtIndex() {
        Node<Chore> nodeAtIndex = firstNode.getNodeAtIndex(1);
        assertEquals("Node at index should match the second node", chore2, nodeAtIndex.getData());
    }

    @Test
    public void testToString() {
        String expected = chore1.toString() + "\n" + chore2.toString();
        assertEquals("toString should match the concatenated string of chore data", expected, firstNode.toString());
    }

    @Test
    public void testToStringWithPredicate() {
        String expected = chore1.toString(); // Assuming chore1 is not done and should be included
        String actual = firstNode.toString(new ChoreNotDoneFilter());
        assertEquals("toString with predicate should only include the not done chores", expected.trim(), actual.trim());
    }
}
