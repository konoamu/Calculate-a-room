/**
 * Calculate the room
 * Created by Samuel Edwards on 09/01/2015.
 */
import static java.lang.System.*;
import java.util.Scanner;
import java.util.stream.DoubleStream;


public class Main {

    public static double AreaFloor = 0;
    public static double AreaWalls = 0;
    public static double RoomVolume = 0;

    public static double Circle() {

        double Radius;

        Scanner in = new Scanner(System.in);
        out.println("Please enter the radius of the circle:");
        Radius = in.nextDouble();
        out.println("The Area for this circle is: "+Math.PI * Radius * Radius);

        return Math.PI * Radius * Radius;
    }

    public static double Rectangle() {
        double Width = 0;
        double Height = 0;

        Scanner in = new Scanner(System.in);

        out.println("Please enter the width of the rectangle:");
        Width = in.nextDouble();
        out.println("Please enter the height of the rectangle:");
        Height = in.nextDouble();
        out.println("The Area for this rectangle is: "+Width * Height);

        return Width * Height;
    }

    public static double Triangle() {
        double Base = 0;
        double Height = 0;

        Scanner in = new Scanner(System.in);

        out.println("Please enter the width of the triangle:");
        Base = in.nextDouble();
        out.println("Please enter the height of the triangle:");
        Height = in.nextDouble();
        out.println("The Area for this triangle is: "+(Base * Height)/2);

        return (Base * Height)/2;
    }

    public static double FloorArea(){
        double[] Area = new double[20];

        int Shapes = 0;
        int x = 0;

        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);

        out.println("How many simple shapes make up the floor space?");
        Shapes = in.nextInt();


        do {

            System.out.println(
                    "Select an option: \n" +
                            "  1) Triangle\n" +
                            "  2) Rectangle\n" +
                            "  3) Circle \n" +
                            "  4) Exit\n "
            );
            boolean quit = false;
            int menuItem;
            do {
                System.out.print("Choose Shape: ");
                menuItem = in.nextInt();
                switch (menuItem) {
                    case 1:

                        Area[x] = Triangle();
                        x++;
                        break;
                    case 2:

                        Area[x] = Rectangle();
                        x++;
                        break;
                    case 3:

                        Area[x] = Circle();
                        x++;
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (x < Shapes);

        } while (x < Shapes);

        AreaFloor = DoubleStream.of(Area).sum();
        System.out.println("The floor area is " + AreaFloor);

        return AreaFloor;
    }
    public static double WallArea(){
        double[] Area = new double[20];

        double TotalWallArea;
        int x = 0;
        int TotalWalls;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the total Number of walls:");
        TotalWalls = in.nextInt();
        do {
            Area[x] = Rectangle();
            ++x;

        } while(x < TotalWalls);

        AreaWalls = DoubleStream.of(Area).sum();
        System.out.println("The Wall area is " + AreaWalls + " With no doors or windows");

        TotalWallArea = AreaWalls-(Doors()+Windows());
        System.out.println("Total wall area that Requires Paint is: " + TotalWallArea);
        return AreaWalls;
    }

    public static double Windows(){
        double[] Area = new double[20];

        int x = 0;
        int TotalWindows;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the total Number of windows:");
        TotalWindows = in.nextInt();
        do {
            Area[x] = Rectangle();
            ++x;

        } while(x < TotalWindows);


        System.out.println("The window area is " + DoubleStream.of(Area).sum());
        return DoubleStream.of(Area).sum();
    }
    public static double Doors(){
        double[] Area = new double[20];
        int x = 0;
        int TotalDoors;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the total Number of doors:");
        TotalDoors = in.nextInt();
        do {
            Area[x] = Rectangle();
            ++x;

        } while(x < TotalDoors);
        System.out.println("The door area is " + DoubleStream.of(Area).sum());
        return DoubleStream.of(Area).sum();
    }
    public static double RoomVolume(){
        double Height;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the height of the room:");
        Height = in.nextInt();

        if (AreaFloor != 0){
            RoomVolume = AreaFloor*Height;
        }else {
            System.out.println("Please enter the floor area details first.");
            FloorArea();
            RoomVolume = AreaFloor*Height;
            System.out.println("The volume of the room is:"+RoomVolume);

        }

        return RoomVolume;
    }
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);

            System.out.println(
                    "Select an option: \n" +
                            "  1) Floor Area\n" +
                            "  2) Wall Area\n" +
                            "  3) Room Volume \n" +
                            "  4) Exit\n "
            );
            boolean quit = false;
            int menuItem;
            do {
                System.out.print("Choose Menu Option: ");
                menuItem = in.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("Floor Area");
                        FloorArea();
                        return;
                    case 2:
                        System.out.println("Wall Area");
                        WallArea();
                        return;
                    case 3:
                        System.out.println("Room Volume");
                        RoomVolume();
                        return;
                    case 4:
                        quit = true;
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (quit = false);
            System.out.println("Goodbye.");
        }

}
