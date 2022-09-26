import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTests {

    @org.junit.jupiter.api.Test
    void maxMin(){
        assertEquals(Lab5Fixed.maxMin("Hello my name is Josh"), "[1, 0]");
        assertEquals(Lab5Fixed.maxMin("This is a JUnit test"), "[2, 3]");
        assertEquals(Lab5Fixed.maxMin("I hope this is working"), "[0, 4]");
    }

    @Test
    void add() {
        MyArrayList testArr=new MyArrayList();
        testArr.add(3);
        assertEquals(testArr.toString(), "[3]");
        testArr.add(1);
        assertEquals(testArr.toString(), "[3, 1]");
        testArr.add(2);
        assertEquals(testArr.toString(), "[3, 1, 2]");
    }

    @Test
    void testToString() {
        MyArrayList testArr=new MyArrayList();
        testArr.add(3);
        assertEquals(testArr.toString(), "[3]");
        testArr.add(1);
        assertEquals(testArr.toString(), "[3, 1]");
        testArr.add(2);
        assertEquals(testArr.toString(), "[3, 1, 2]");
    }

    @Test
    void remove() {
        MyArrayList testArr=new MyArrayList();
        testArr.add(3);
        testArr.add(1);
        testArr.add(2);
        assertEquals(testArr.toString(), "[3, 1, 2]");
        assertEquals(testArr.remove(1), 1);
        assertEquals(testArr.toString(), "[3, 2]");
        assertEquals(testArr.remove(0), 3);
        assertEquals(testArr.toString(), "[2]");
        assertEquals(testArr.remove(0), 2);
        assertEquals(testArr.toString(), "[]");
    }

    @Test
    void getSize() {
        MyArrayList testArr = new MyArrayList();
        testArr.add(3);
        assertEquals(testArr.getSize(),1);
        testArr.add(1);
        assertEquals(testArr.getSize(),2);
        testArr.add(2);
        assertEquals(testArr.getSize(),3);
    }

    @Test
    void isEmpty() {
        MyArrayList testArr = new MyArrayList();
        assertEquals(testArr.isEmpty(),true);
        testArr.add(3);
        assertEquals(testArr.isEmpty(), false);
        testArr.remove(0);
        assertEquals(testArr.isEmpty(), true);
    }

    @Test
    void contains() {
        MyArrayList testArr=new MyArrayList();
        testArr.add(3);
        testArr.add(1);
        testArr.add(2);
        assertEquals(testArr.contains(3), true);
        assertEquals(testArr.contains(1), true);
        assertEquals(testArr.contains(2), true);
        assertEquals(testArr.contains(12), false);
    }

    @Test
    void indexOf() {
        MyArrayList testArr=new MyArrayList();
        testArr.add(3);
        testArr.add(1);
        testArr.add(2);
        assertEquals(testArr.indexOf(3),0);
        assertEquals(testArr.indexOf(1), 1);
        assertEquals(testArr.indexOf(2), 2);
    }
}