package service;

import constants.RobotCommonConstants;
import model.RobotModel;

import java.util.Arrays;


public class RobotSimulateService {

    public RobotModel placeRobot(String positionInput) {
           //Set the robot position coordinates and direction as specified in the PLACE command.
           String[] coordinatesList = positionInput.split(",");
           RobotModel robotModel = new RobotModel(Integer.parseInt(coordinatesList[0]),Integer.parseInt(coordinatesList[1]),coordinatesList[2], null);
          return robotModel;
    }

    public boolean validateRobotCommand(String input) {
        String[] commands = {"MOVE","LEFT","RIGHT","REPORT","STOP"};

        /* 1. Verify if command matches the PLACE command using regex pattern ^PLACE\s[0-4],[0-4],(NORTH|SOUTH|EAST|WEST)$
              OR
              Verify if the command is STOP
           2. For all further commands after the initial, verify if the input matches any of the commands below:
              PLACE,MOVE,LEFT,RIGHT,REPORT,ROBOT,STOP */

        if(input.matches(RobotCommonConstants.PLACE_COMMAND_REGEX) || input.equals(RobotCommonConstants.STOP_COMMAND)) {
            return true;
        }else if(input.matches(RobotCommonConstants.PLACE_COMMAND_REGEX) || input.matches(RobotCommonConstants.ROBOT_COMMAND_REGEX) ||
                Arrays.stream(commands).anyMatch(input::matches)) {
            return true;
        }
        else {
           return false;
        }
    }

    public void moveRobot(RobotModel robotModel) {
        /*Verify if the robotModel is not null which indicates a PLACE command is executed first already.
          Else,display an error message to place the robot on the table */

        if (robotModel != null) {
            String directionPlaced = robotModel.getDirection();
            //MOVE command forwards the robot with one unit in the direction the robot is placed
            //A check is added here for each case condition position coordinates to prevent robot falling from the table.
            switch (directionPlaced) {
                case "NORTH":

                    if (robotModel.getY_co_ordinate() < (RobotCommonConstants.TABLE_MAX_SIZE - 1)) {
                        robotModel.setY_co_ordinate(robotModel.getY_co_ordinate() + 1);
                    } else {
                        System.out.println(RobotCommonConstants.CAUTION_MESSAGE + " NORTH");
                    }
                    break;
                case "EAST":
                    if (robotModel.getX_co_ordinate() < (RobotCommonConstants.TABLE_MAX_SIZE - 1)) {
                        robotModel.setX_co_ordinate(robotModel.getX_co_ordinate() + 1);
                    } else {
                        System.out.println(RobotCommonConstants.CAUTION_MESSAGE + " EAST");
                    }
                    break;
                case "SOUTH":
                    if (robotModel.getY_co_ordinate() > RobotCommonConstants.TABLE_MIN_SIZE) {
                        robotModel.setY_co_ordinate(robotModel.getY_co_ordinate() - 1);
                    } else {
                        System.out.println(RobotCommonConstants.CAUTION_MESSAGE + " SOUTH");
                    }
                    break;
                case "WEST":
                    if (robotModel.getX_co_ordinate() > RobotCommonConstants.TABLE_MIN_SIZE) {
                        robotModel.setX_co_ordinate(robotModel.getX_co_ordinate() - 1);
                    } else {
                        System.out.println(RobotCommonConstants.CAUTION_MESSAGE + " WEST");
                    }
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("ERROR:: Invalid command. Please position the robot on table using PLACE command");
        }

    }

    public void moveLeft(RobotModel robotModel) {
        //LEFT command rotates the robot in 90 degrees towards left without moving.
        //Null check for the robotModel verifies if a PLACE command executed initially
        if(robotModel != null) {
            String directionPlaced = robotModel.getDirection();
            switch (directionPlaced) {
                case "NORTH":
                    robotModel.setDirection("WEST");
                    break;
                case "WEST":
                    robotModel.setDirection("SOUTH");
                    break;
                case "SOUTH":
                    robotModel.setDirection("EAST");
                    break;
                case "EAST":
                    robotModel.setDirection("NORTH");
                    break;
            }
        }else{
            System.out.println("ERROR:: Invalid command. Please position the robot on table using PLACE command");
        }
    }

    public void moveRight(RobotModel robotModel) {
        //RIGHT command rotates the robot in 90 degrees towards RIGHT without moving.
        //Null check for the robotModel verifies if a PLACE command executed initially
        if(robotModel != null) {
            String directionPlaced = robotModel.getDirection();
            switch (directionPlaced) {
                case "NORTH":
                    robotModel.setDirection("EAST");
                    break;
                case "EAST":
                    robotModel.setDirection("SOUTH");
                    break;
                case "SOUTH":
                    robotModel.setDirection("WEST");
                    break;
                case "WEST":
                    robotModel.setDirection("NORTH");
                    break;
            }
        }else{
                System.out.println("ERROR:: Invalid command. Please position the robot on table using PLACE command");
        }
    }

    public void report(RobotModel robotModel, int robotCount) {
        //REPORT will display total count of robots, current active robot, its position and direction.
        //Null check for the robotModel verifies if a PLACE command executed initially
          if(robotModel != null) {
              System.out.println("******ROBOT STATUS REPORT******");
              System.out.println("Total no of robots present on table: " + robotCount);
              System.out.println("Active Robot: " + robotModel.getRobotIdentifier());
              System.out.println("Output: " + robotModel.getX_co_ordinate() + "," + robotModel.getY_co_ordinate() +
                      "," + robotModel.getDirection() +" \n");
          }else{
              System.out.println("ERROR:: Invalid command. Please position the robot on table using PLACE command");
          }
    }

}
