#Robot-Simulation-Challenge
    This project simulates multiple toy robots on a square tabletop of dimensions 5 units x 5 units.

#Description
    This application can read the below commands:
    
    1.PLACE X,Y,F --> where X,Y are position coordinates and F is the direction facing(NORTH,SOUTH,EAST,WEST)
      PLACE is always the first command to put the robot on the table and start the simulation.
          Application discards all other commands until a valid PLACE command is issued.
          
    2.MOVE --> Moves the robot one step forward in the same direction it is facing
    3.LEFT --> Turns the robot 90 degrees towards left from the direction it is facing 
    4.RIGHT --> Turns the robot 90 degrees towards right from the direction it is facing
    5.REPORT --> Displays the total number of robots, active robot, position and direction of the active robot
    6.ROBOT <number> --> Makes the ROBOT <number> active. By default, First placed robot is active.
    7.STOP --> To terminate the program

#Prerequisites
    1. Java 17.0.1
    2. Maven 3.8.4

#Build and Run application

    1.In home directory m2 folder, add settings.xml file pointing to the public maven repository to download all dependencies required.
    2.Run the command 'mvn clean install'.
    3.Run the application using RobotSimulationApplication main class

#Locally tested output

#Output 1:
    Welcome to the Robot Simulation!! 
    You can simulate robot using the following commands 

    1. PLACE X,Y,F --> where X,Y are positions on table top and F is direction(i.e NORTH,EAST,WEST,SOUTH) 
    2. MOVE    --> moves the robot one step forward in the direction it is facing 
    3. LEFT    --> rotates the robot in 90 degrees towards left without changing position 
    4. RIGHT   --> rotates the robot in 90 degrees towards right without changing position 
    5. REPORT  --> Displays the current position of the robot 
    6. STOP    --> To Stop and Exit from the program 
    7. ROBOT <NUMBER> --> Makes the robot identified by as active.

    To start with, Please enter the 'PLACE X,Y,F' command to place the robot on the square table top and then proceed with other commands. 
    Example: PLACE 1,1,NORTH

    PLACE 2,2,NORTH
    ROBOT 1 is successfully placed on table top
    Hurray!!Now you can enjoy simulating your robot using any of the below commands
    PLACE X.Y,F 
    MOVE 
    LEFT 
    RIGHT 
    REPORT 
    ROBOT <number> 
    STOP

    MOVE
    RIGHT
    REPORT
    ******ROBOT STATUS REPORT******
    Total no of robots present on table: 1
    Active Robot: ROBOT 1
    Output: 2,3,EAST 

    PLACE 2,3,WEST
    ROBOT 2 is successfully placed on table top
    MOVE
    LEFT
    REPORT
    ******ROBOT STATUS REPORT******
    Total no of robots present on table: 2
    Active Robot: ROBOT 1
    Output: 3,3,NORTH 

    ROBOT 2
    ROBOT 2 is now activated
    MOVE
    LEFT
    REPORT
    ******ROBOT STATUS REPORT******
    Total no of robots present on table: 2
    Active Robot: ROBOT 2
    Output: 1,3,SOUTH 

    MOVE1
    ERROR:: Invalid command.Please try again with valid commands mentioned at start of the program.
    
    STOP
    Terminating the program!!


#Output 2:

    Welcome to the Robot Simulation!! 
    You can simulate robot using the following commands 

    1. PLACE X,Y,F --> where X,Y are positions on table top and F is direction(i.e NORTH,EAST,WEST,SOUTH) 
    2. MOVE    --> moves the robot one step forward in the direction it is facing 
    3. LEFT    --> rotates the robot in 90 degrees towards left without changing position 
    4. RIGHT   --> rotates the robot in 90 degrees towards right without changing position 
    5. REPORT  --> Displays the current position of the robot 
    6. STOP    --> To Stop and Exit from the program 
    7. ROBOT <NUMBER> --> Makes the robot identified by as active.

    NOTE: To start with, Please enter the 'PLACE X,Y,F' command to place the robot on the square table top and then proceed with other commands. 
    Example: PLACE 1,1,NORTH
    
    MOVE
    ERROR:: Invalid command. Please position the robot on table using PLACE command
    LEFT
    ERROR:: Invalid command. Please position the robot on table using PLACE command
    REPORT
    ERROR:: Invalid command. Please position the robot on table using PLACE command
    PLACE 1,3
    ERROR:: Invalid command.Please try again with the valid commands mentioned in the menu.
    
    PLACE 1,2,NORTH
    ROBOT 1 is successfully placed on table top
    Hurray!!Now you can enjoy simulating your robot using any of the below commands
    PLACE X.Y,F 
    MOVE 
    LEFT 
    RIGHT 
    REPORT 
    ROBOT <number> 
    STOP

    MOVE
    LEFT
    REPORT
    ******ROBOT STATUS REPORT******
    Total no of robots present on table: 1
    Active Robot: ROBOT 1
    Output: 1,3,WEST 
    
    STOP
    Terminating the program!!







