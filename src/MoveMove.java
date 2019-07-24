//Created by Minel SAYGISEVER
//PROBLEM ONE: MARS ROVERS

import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.fail;

class MoveMove {

    static void readWrite(String inputString, String outputString){
        //plateau size values
        int plateauX, plateauY;

        File inputFile = new File(inputString);
        File outputFile = new File(outputString);

        try( Scanner input = new Scanner(inputFile)) {
            try (PrintWriter output = new PrintWriter(outputFile)){

                //first two inputs are plateau sizes
                plateauX = input.nextInt();
                plateauY = input.nextInt();

                //our cursor is at the end of the first line right now, so go next line
                input.nextLine();

                while(input.hasNext()){
                    Rover rover = new Rover(input.nextInt(), input.nextInt(), input.next());
                    input.nextLine(); //cursor is at the end of the line

                    //take the moves input as one string and transform it to a char array
                    String control = input.nextLine();
                    char[] controlLetters = control.toCharArray();

                    //apply movements
                    movements(rover, controlLetters, plateauX, plateauY, output);

                    output.println(rover.getX() + " " + rover.getY() + " " + rover.getFacing());
                }
            }
        } catch(IOException io){
            System.out.println(io.getMessage());
        }

    }

    private static void movements(Rover rover, char[] controlLetters, int plateauX, int plateauY, PrintWriter output){

        //analyze movements
        for (char controlLetter : controlLetters) {

            switch (controlLetter) {
                case 'R':
                    rover.turnRight();
                    break;
                case 'L':
                    rover.turnLeft();
                    break;

                //we need to stay inside the plateau, so check the boundaries
                case 'M':
                    if(     (rover.getFacing().equalsIgnoreCase("N") && (rover.getY() < plateauY)) ||
                            (rover.getFacing().equalsIgnoreCase("W") && (rover.getX() > 0)) ||
                            (rover.getFacing().equalsIgnoreCase("S") && (rover.getY() > 0)) ||
                            (rover.getFacing().equalsIgnoreCase("E") && (rover.getX() < plateauX)) )
                    {
                        rover.moveForward();
                    }
                    else{
                        output.println("Crash!");
                    }
            }
        }
    }

}
