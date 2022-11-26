import java.lang.Math;

public class CoordinateSystem {
    private String[][] FillCoordinateSystem(){
        String[][] CoordinateSystem = new String[10][51];
        //initialize Array with Spaces
        for(int n = 0; n < 10; n++){
            //has to run to 51 because the task asks us to show the 5 (-> 50) aswell
            for(int m = 0; m < 51; m++){
                CoordinateSystem[n][m] = " ";
            }
        }

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 51; j++){
                if(j == 0){
                    CoordinateSystem[i][j] = 9-i+"|";
                }
                if(i == 9 && j != 0 && j != 10 && j != 20 && j != 30 && j != 40 && j != 50){
                    CoordinateSystem[i][j] = "-";
                }
                if(i == 9 && j == 10){
                    CoordinateSystem[i][j] = "1";
                }
                if(i == 9 && j == 20){
                    CoordinateSystem[i][j] = "2";
                }
                if(i == 9 && j == 30){
                    CoordinateSystem[i][j] = "3";
                }
                if(i == 9 && j == 40){
                    CoordinateSystem[i][j] = "4";
                }
                if(i == 9 && j == 50){
                    CoordinateSystem[i][j] = "5";
                }
            }
        }
        return CoordinateSystem;
    }
    private void DrawCoordinateSystem(String[][] CoordinateSystem){
        for(int i = 0; i < 10; i++){
            System.out.println();
            for(int j = 0; j < 51; j++){
                System.out.print(CoordinateSystem[i][j]);
            }
        }
    }
    private String[][] AddPointsToCoordinateSystem(String[][] CoordinateSystemDrawn, int x, int y){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 51; j++){
                CoordinateSystemDrawn[y][x] = "*";
            }
        }
        return CoordinateSystemDrawn;
    }
    private double CalculateDistanceBetweenPoints(int x1, int x2, int y1, int y2){
        double distance = 0;
        //Use the Math library and search for the function / method square Root to calculate the distance between the points
        //If it's not allowed to use libraries you have to figure out another way to calculate (google is your friend)
        distance = Math.sqrt( ((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)) );

        return distance;
    }

    public static void main(String[] args) {
        CoordinateSystem system = new CoordinateSystem();

        //to calculate the y-coordinate we have to think because the arrays first Row is titled with 9 here but starts initialising with 0
        //therefore we enter a wished y-coordinate f.e. if i want y = 7 if have to enter it on the 2nd Array Row
        //9 - given y-coordinate = right Row in Array

        int x1 = 20;
        int y1 = 9;
        int rightRow = 9-y1;

        int x2 = 30;
        int y2 = 5;
        int rightRowTwo = 9-y2;

        //you have to check if the Variables entered are correct -> simple if's i think should do the work

        //initialize the coordinate system and fill it in the wanted format
        String[][] myCoordinateSystem = system.FillCoordinateSystem();
        //set the first given coordinates in the before filled coordinate system
        String[][] WithFirstPoint = system.AddPointsToCoordinateSystem(myCoordinateSystem, x1, rightRow);
        //take the resulting coordinate system and fill in the second point
        String[][] WithBothPoints = system.AddPointsToCoordinateSystem(WithFirstPoint, x2, rightRowTwo);
        //draw the finished coordinate system
        system.DrawCoordinateSystem(WithBothPoints);

        double distance = system.CalculateDistanceBetweenPoints(x1, x2, y1, y2);
        System.out.println();
        System.out.println("The distance between the two given coordinates is: "+distance);
    }
}
