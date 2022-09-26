import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab4Test {

    @Test
    void exponentCalculatorTest() {
        assertEquals(Lab4.exponentCalculator(4,2),"16");
        assertEquals(Lab4.exponentCalculator(2,3),"8");
        Throwable exception1 = assertThrows(IllegalArgumentException.class,
                ()->{Lab4.exponentCalculator(0,0);} );
        Throwable exception2 = assertThrows(IllegalArgumentException.class,
                ()->{Lab4.exponentCalculator(3,-2);} );
    }
        Throwable exception3 = assertThrows(IllegalArgumentException.class,
                ()->{Lab4.exponentCalculator(-4,-8);} );

    @Test
    void rectangle() {
        assertEquals(Lab4.rectangle(3,4),"###\n###\n###\n###");
        assertEquals(Lab4.rectangle(5,7),"#####\n#####\n#####\n#####\n#####\n#####\n#####");
        assertEquals(Lab4.rectangle(2,4),"##\n##\n##\n##");
    }
}