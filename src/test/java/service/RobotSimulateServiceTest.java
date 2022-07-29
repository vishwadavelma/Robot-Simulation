package service;

import model.RobotModel;
import org.junit.Assert;
import org.junit.Test;

public class RobotSimulateServiceTest {

    RobotSimulateService roboService = new RobotSimulateService();


    @Test
    public void testCommandsValidation() {
        //Positive validation
        Assert.assertTrue(roboService.validateRobotCommand("PLACE 1,1,NORTH"));
        Assert.assertTrue(roboService.validateRobotCommand("MOVE"));
        Assert.assertTrue(roboService.validateRobotCommand("LEFT"));
        Assert.assertTrue(roboService.validateRobotCommand("RIGHT"));
        Assert.assertTrue(roboService.validateRobotCommand("STOP"));
        Assert.assertTrue(roboService.validateRobotCommand("ROBOT 1"));
        //Negative validation
        Assert.assertFalse(roboService.validateRobotCommand("MOVE LEFT"));
        Assert.assertFalse(roboService.validateRobotCommand("PLACE NORTH 1,1"));

    }


    @Test
    public void placeRobotTest() {
        RobotModel robotModel = new RobotModel(1, 1, "NORTH", null);
        robotModel = roboService.placeRobot("1,1,NORTH");
        Assert.assertEquals(robotModel.getX_co_ordinate(), 1);
        Assert.assertEquals(robotModel.getY_co_ordinate(), 1);
        Assert.assertEquals(robotModel.getDirection().toString(), "NORTH");

    }


    @Test
    public void moveRobot() {
        RobotModel robotModelNorthSuccess = new RobotModel(2, 2, "NORTH", "ROBOT 3");
        RobotModel robotModelNorthFailure = new RobotModel(2, 4, "NORTH", "ROBOT 3");
        RobotModel robotModelSouthSuccess = new RobotModel(2, 2, "SOUTH", "ROBOT 2");
        RobotModel robotModelSouthFailure = new RobotModel(2, 0, "SOUTH", "ROBOT 2");
        RobotModel robotModelEastSuccess = new RobotModel(2, 2, "EAST", "ROBOT 1");
        RobotModel robotModelEastFailure = new RobotModel(4, 2, "EAST", "ROBOT 1");
        RobotModel robotModelWestSuccess = new RobotModel(2, 2, "WEST", "ROBOT 1");
        RobotModel robotModelWestFailure = new RobotModel(0, 2, "WEST", "ROBOT 1");

        //Success Validations
        roboService.moveRobot(robotModelNorthSuccess);
        roboService.moveRobot(robotModelSouthSuccess);
        roboService.moveRobot(robotModelEastSuccess);
        roboService.moveRobot(robotModelWestSuccess);

        Assert.assertEquals(robotModelNorthSuccess.getY_co_ordinate(), 3);
        Assert.assertEquals(robotModelSouthSuccess.getY_co_ordinate(), 1);
        Assert.assertEquals(robotModelEastSuccess.getX_co_ordinate(), 3);
        Assert.assertEquals(robotModelWestSuccess.getX_co_ordinate(), 1);

        //Failure Validations
        roboService.moveRobot(robotModelNorthFailure);
        roboService.moveRobot(robotModelSouthFailure);
        roboService.moveRobot(robotModelEastFailure);
        roboService.moveRobot(robotModelWestFailure);

        Assert.assertSame(robotModelNorthFailure.getY_co_ordinate(), 4);
        Assert.assertSame(robotModelSouthFailure.getY_co_ordinate(), 0);
        Assert.assertSame(robotModelEastFailure.getX_co_ordinate(), 4);
        Assert.assertSame(robotModelWestFailure.getX_co_ordinate(), 0);


    }


    @Test
    public void testLeftCommand() {
        RobotModel robotModelNorth = new RobotModel(2, 2, "NORTH", "ROBOT 2");
        RobotModel robotModelSouth = new RobotModel(2, 2, "SOUTH", "ROBOT 2");
        RobotModel robotModelEast = new RobotModel(2, 2, "EAST", "ROBOT 2");
        RobotModel robotModelWest = new RobotModel(2, 2, "WEST", "ROBOT 2");

        roboService.moveLeft(robotModelNorth);
        roboService.moveLeft(robotModelSouth);
        roboService.moveLeft(robotModelEast);
        roboService.moveLeft(robotModelWest);

        Assert.assertEquals(robotModelNorth.getDirection(), "WEST");
        Assert.assertEquals(robotModelSouth.getDirection(), "EAST");
        Assert.assertEquals(robotModelEast.getDirection(), "NORTH");
        Assert.assertEquals(robotModelWest.getDirection(), "SOUTH");
    }


    @Test
    public void testRightCommand() {
        RobotModel robotModelNorth = new RobotModel(2, 2, "NORTH", "ROBOT 2");
        RobotModel robotModelSouth = new RobotModel(2, 2, "SOUTH", "ROBOT 2");
        RobotModel robotModelEast = new RobotModel(2, 2, "EAST", "ROBOT 2");
        RobotModel robotModelWest = new RobotModel(2, 2, "WEST", "ROBOT 2");

        roboService.moveRight(robotModelNorth);
        roboService.moveRight(robotModelSouth);
        roboService.moveRight(robotModelEast);
        roboService.moveRight(robotModelWest);

        Assert.assertEquals(robotModelNorth.getDirection(), "EAST");
        Assert.assertEquals(robotModelSouth.getDirection(), "WEST");
        Assert.assertEquals(robotModelEast.getDirection(), "SOUTH");
        Assert.assertEquals(robotModelWest.getDirection(), "NORTH");
    }


    @Test
    public void testReportCommand() {
        RobotModel robotModelNorth = new RobotModel(2, 2, "NORTH", "ROBOT 2");
        RobotModel robotModelSouth = new RobotModel(2, 2, "SOUTH", "ROBOT 2");
        RobotModel robotModelEast = new RobotModel(2, 2, "EAST", "ROBOT 2");
        RobotModel robotModelWest = new RobotModel(2, 2, "WEST", "ROBOT 2");

        roboService.moveRight(robotModelNorth);
        roboService.moveRight(robotModelSouth);
        roboService.moveRight(robotModelEast);
        roboService.moveRight(robotModelWest);

        Assert.assertEquals(robotModelNorth.getDirection(), "EAST");
        Assert.assertEquals(robotModelSouth.getDirection(), "WEST");
        Assert.assertEquals(robotModelEast.getDirection(), "SOUTH");
        Assert.assertEquals(robotModelWest.getDirection(), "NORTH");
    }
}