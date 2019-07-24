//Created by Minel SAYGISEVER
//PROBLEM ONE: MARS ROVERS

class Rover {
    private int x, y;
    private String facing;

    Rover(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    String getFacing() {
        return facing;
    }

    private void setFacing(String facing) {
        this.facing = facing;
    }

    //moveForward changes only coordinates
    void moveForward(){
        switch(getFacing()){
            case "N":
                setY(getY() + 1); break;
            case "W":
                setX(getX() - 1); break;
            case "S":
                setY(getY() - 1); break;
            case "E":
                setX(getX() + 1); break;
        }
    }

    //turnLeft and turnRight change only direction
    void turnLeft(){
        switch(getFacing()){
            case "N": setFacing("W"); break;
            case "W": setFacing("S"); break;
            case "S": setFacing("E"); break;
            case "E": setFacing("N"); break;
        }

    }

    void turnRight(){
        switch(getFacing()){
            case "N": setFacing("E"); break;
            case "W": setFacing("N"); break;
            case "S": setFacing("W"); break;
            case "E": setFacing("S"); break;
        }
    }

}
