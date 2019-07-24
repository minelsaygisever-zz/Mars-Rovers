//Created by Minel SAYGISEVER
//PROBLEM ONE: MARS ROVERS

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MoveMoveTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void crashTest() { //Given input, it contains no crash
        MoveMove.readWrite("input.txt", "output.txt");
        outputControls("output.txt", "expected.txt");

    }

    @Test
    void crashTest2(){ //I created a new input txt file, first rover won't crash but second one will
        MoveMove.readWrite("input2.txt", "output2.txt");
        outputControls("output2.txt", "expected2.txt");
    }

    //Expected files contain expected result, output files contain program's result
    //This method compares these two files, check for bugs
    static void outputControls(String outputString, String expectedString){
        File outputFile = new File(outputString);
        File expectedFile = new File(expectedString);

        try( Scanner output = new Scanner(outputFile)) {
            try (Scanner expected = new Scanner(expectedFile)) {
                while(output.hasNext() && expected.hasNext()){
                    assertEquals(expected.nextLine(),output.nextLine(),"Rover's location or direction is wrong");
                }
            }
        } catch(IOException io){
            System.out.println(io.getMessage());
            fail("Can't find the input files.");
        }
    }
}