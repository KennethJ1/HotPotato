package HotPotato.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*; 

public class circularUnitTests {

    @Test
    public void testEnds(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("A", "D");
        String[] expected = {"D","B","C","A"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void testEndsReversed(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("D", "A");
        String[] expected = {"D","B","C","A"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void testSideBySide(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("A", "B");
        String[] expected = {"B","A","C","D"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void testSideBySideReversed(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("B", "A");
        String[] expected = {"B","A","C","D"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void testSideBySideAtTheEnd(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("C", "D");
        String[] expected = {"A","B","D","C"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void testSideBySideAtTheEndReversed(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("D", "C");
        String[] expected = {"A","B","D","C"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }

    @Test
    public void RandomInTheMiddle(){
        var list = new CircularlyLinkedList<String>();
        String[] input = {"A","B","C","D"};
        for (String in : input) {
            list.addAsLast(in);
        }
        list.exchangeTwoPlayers("B", "D");
        String[] expected = {"A","D","C","B"};
        String formatExpected = Arrays.toString(expected);
        String formatOutput = list.toString().replace('(','[').replace(')',']');
        Assertions.assertEquals(formatExpected,formatOutput);
    }
}
