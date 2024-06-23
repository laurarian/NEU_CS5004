/**
 * Name: Rong Huang
 * Date: 2024-03-20
 * Assignment: Lab 5 Part 2
 * Tests for EmptyNode.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestEmptyNode {

    private EmptyNode<?> emptyNode;

    @BeforeEach
    public void setUp() {
        emptyNode = new EmptyNode<>();
    }

    /**
     * Test getData method.
     */
    @Test
    public void testGetData() {
        assertNull(emptyNode.getData(), "getData should return null.");
    }

    /**
     * Test getNext method.
     */
    @Test
    public void testGetNext() {
        assertNull(emptyNode.getNext(), "getNext should return null.");
    }

    /**
     * Test setNext method.
     */
    @Test
    public void testSetNext() {
        emptyNode.setNext(null);
        assertNull(emptyNode.getNext(), "setNext should not change anything.");
    }

    /**
     * Test countIf method.
     */
    @Test
    public void testCountIf() {
        assertEquals(0, emptyNode.countIf(e -> true), "countIf should always return 0.");
    }

    /**
     * Test filter method.
     */
    @Test
    public void testFilter() {
        assertEquals(emptyNode, emptyNode.filter(e -> true), "filter should return the same EmptyNode instance.");
    }

    /**
     * Test getNodeAtIndex method.
     */
    @Test
    public void testGetNodeAtIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyNode.getNodeAtIndex(0), "getNodeAtIndex should throw IndexOutOfBoundsException.");
    }

    /**
     * Test toString method.
     */
    @Test
    public void testToString() {
        assertEquals("EmptyNode", emptyNode.toString(), "toString should return 'EmptyNode'.");
    }

    /**
     * Test toString with Predicate.
     */
    @Test
    public void testToStringWithPredicate() {
        assertEquals("", emptyNode.toString(e -> true), "toString with predicate should return an empty string.");
    }
}

