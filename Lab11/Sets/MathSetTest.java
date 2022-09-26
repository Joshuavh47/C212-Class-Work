package Sets;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MathSetTest {

    @Test
    void intersection() {
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        b.add(1);
        b.add(2);
        b.add(3);
        Set<Integer> c=new TreeSet<Integer>();
        Set<Integer> d=new TreeSet<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        d.add(1);
        d.add(2);
        assertEquals(MathSet.intersection(a,b).toString(),"[1, 2, 3]");
        assertEquals(MathSet.intersection(c,d).toString(),"[1, 2]");
        assertEquals(MathSet.intersection(a,c).toString(), "[1, 2, 3, 4]");
        assertEquals(MathSet.intersection(b,d).toString(), "[1, 2]");

    }

    @Test
    void union() {
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        a.add(3);
        a.add(4);
        b.add(1);
        b.add(2);
        b.add(3);
        Set<Integer> c=new TreeSet<Integer>();
        Set<Integer> d=new TreeSet<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        d.add(1);
        d.add(2);
        assertEquals(MathSet.union(a,b).toString(),"[1, 2, 3, 4]");
        assertEquals(MathSet.union(c,d).toString(),"[1, 2, 3, 4, 5]");
        assertEquals(MathSet.union(a,c).toString(), "[1, 2, 3, 4, 5]");
        assertEquals(MathSet.union(b,d).toString(), "[1, 2, 3]");
    }

    @Test
    void compliment() {
        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        b.add(1);
        b.add(2);
        Set<Integer> c=new TreeSet<Integer>();
        Set<Integer> d=new TreeSet<Integer>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        d.add(1);
        d.add(2);
        assertEquals(MathSet.compliment(b, a).toString(),"[3, 4]");
        assertEquals(MathSet.compliment(d,c).toString(),"[3, 4, 5]");
        assertEquals(MathSet.compliment(a,c).toString(), "[5]");
        assertEquals(MathSet.compliment(b,d).toString(), "[]");
    }
}