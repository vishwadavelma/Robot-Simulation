import constants.RobotCommonConstants;
import model.RobotModel;
import service.RobotSimulateService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RobotSimulationApplication {

   public static void main(String[] args) throws IOException {
       RobotSimulateService robotService = new RobotSimulateService();
       int robotCount = 0;
       RobotModel activeRobot = null;
       List<RobotModel> robotsList = new ArrayList<>();
       /*System.out.println("Welcome to the Robot Simulation!! \n" +
               "You can simulate robot using the following commands \n" +
               "1. PLACE X,Y,F --> where X,Y are positions on table top and F is direction(i.e NORTH,EAST,WEST,SOUTH) \n" +
               "2. MOVE    --> moves the robot one step forward in the direction it is facing \n" +
               "3. LEFT    --> rotates the robot in 90 degrees towards left without changing position \n" +
               "4. RIGHT   --> rotates the robot in 90 degrees towards right without changing position \n" +
               "5. REPORT  --> Displays the current position of the robot \n" +
               "6. STOP    --> To Stop and Exit from the program \n" +
               "7. ROBOT <NUMBER> --> Makes the robot identified by as active.\n\n" +
               "NOTE: To start with, Please enter the 'PLACE X,Y,F' command to place the robot on the square table top and then proceed with other commands. \n" +
               "Example: PLACE 1,1,NORTH\n");*/
       System.out.println(RobotCommonConstants.DISPLAY_MENU);
       while (true) {
           //Read the input commands from console.
           BufferedReader reader = new BufferedReader(
                   new InputStreamReader(System.in));
           String input = reader.readLine();
           //validate the input command
           boolean validateCommandResult = robotService.validateRobotCommand(input);
           //Once command validation is successful, implement the input command accordingly.
           if (validateCommandResult) {
               /*Split the input command string and store into array.
                 Use zero index element in array for verifying the input commands type and execute its methods subsequently.*/
               String[] commands = input.split(" ");

               switch (commands[0]) {
                   case "PLACE":
                       RobotModel robotModel = robotService.placeRobot(commands[1]);
                       //Incrementing the robotCount once robot placed on table to track no of robots and use it for REPORT.
                       robotCount++;
                       robotModel.setRobotIdentifier("ROBOT " + robotCount);
                       System.out.println(robotModel.getRobotIdentifier() + " is successfully placed on table top");
                       robotsList.add(robotModel);
                       //Displaying a message whenever the 1st Robot is placed on table to start the simulation
                       if(robotCount == 1) {
                           System.out.println(RobotCommonConstants.DISPLAY_MENU_AFTER_PLACE);
                           /*System.out.println("Hurray!!Now you can enjoy simulating your robot using any of the below commands\n" +
                                   "PLACE X.Y,F \n" +
                                   "MOVE \n" +
                                   "LEFT \n" +
                                   "RIGHT \n" +
                                   "REPORT \n" +
                                   "ROBOT <number> \n" +
                                   "STOP\n");*/
                           //By default, setting the first placed robot as active robot.
                           activeRobot = robotModel;
                       }
                       break;
                   case "MOVE":
                       robotService.moveRobot(activeRobot);
                       break;
                   case "LEFT":
                       robotService.moveLeft(activeRobot);
                       break;
                   case "RIGHT":
                       robotService.moveRight(activeRobot);
                       break;
                   case "REPORT":
                       robotService.report(activeRobot, robotCount);
                       break;
                   case "ROBOT":
                       //Filter through the list of robots for the robotIdentifier and activate the robot whose identifier matches the ROBOT command
                       Optional<RobotModel> activeRobotModel = robotsList.stream().filter(robot -> robot.getRobotIdentifier().equals("ROBOT " + commands[1])).findFirst();
                       if (activeRobotModel.isPresent()) {
                          activeRobot = activeRobotModel.get();
                          System.out.println(activeRobot.getRobotIdentifier() + " is now activated");
                       } else {
                           System.out.println("No active robot found with name as " + input);
                       }
                       break;
                   case "STOP":
                       System.out.println("Terminating the program!!");
                       System.exit(0);
                       break;

               }
           }else {
               System.out.println("ERROR:: Invalid command.Please try again with the valid commands mentioned in the menu.\n");
           }

       }
   }

}
