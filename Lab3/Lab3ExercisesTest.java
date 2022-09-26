import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab3ExercisesTest {

    @Test
    void pigLatinEncoder() {
        assertEquals(Lab3Exercises.pigLatinEncoder("Hi my name is Josh"),"i-Hay y-may ame-nay is-way osh-Jay ");
        assertEquals(Lab3Exercises.pigLatinEncoder("This is my JUnit test"),"is-Thay is-way y-may Unit-Jay est-tay ");
        assertEquals(Lab3Exercises.pigLatinEncoder("I hope this works"),"I-way ope-hay is-thay orks-way ");
    }

    @Test
    void pigLatinDecoder() {
        assertEquals(Lab3Exercises.pigLatinDecoder("i-Hay y-may ame-nay is-way osh-Jay"),"Hi my name (wis/is) Josh ");
        assertEquals(Lab3Exercises.pigLatinDecoder("is-Thay is-way y-may Unit-Jay est-tay"),"This (wis/is) my JUnit test ");
        assertEquals(Lab3Exercises.pigLatinDecoder("I-way ope-hay is-thay orks-way"),"(wI/I) hope this (works/orks) ");
    }

    @Test
    void hexToIntNBin() {
        assertEquals(Lab3Exercises.hexToIntNBin("FACE"),"Your number is 64206 (in decimal) and 1111101011001110 (in binary).");
        assertEquals(Lab3Exercises.hexToIntNBin("A123C"),"Your number is 660028 (in decimal) and 10100001001000111100 (in binary).");
        assertEquals(Lab3Exercises.hexToIntNBin("17269FE"),"Your number is 24275454 (in decimal) and 1011100100110100111111110 (in binary).");
    }
}