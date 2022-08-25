package rover;

import static org.junit.Assert.*;

import org.junit.*;
import core.Rover;

public class TestRover {
	
    private Rover rover;
    private Rover roverEdge;
    private char[] commande;
    private String[] obtacles;

    @Before
    public void beforeRoverTest() {
        rover = new Rover(0, 0, 'N');
        roverEdge = new Rover(0, 2, 'N');
        commande = new char[]{'F','R','F','L','B'};
        obtacles = new String[]{"(1,1)","(2,2)"};
    }
    

	@Test
	public void RoverIsFacingNorth() {
		System.out.println("RoverIsFacingNorth: "+rover.getDirection());
		assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void RoverAtBase() {
		System.out.println("RoverAtBase: "+rover.getPosition());
		assertEquals("(0,0)", rover.getPosition());
	}
	
	@Test
	public void RoveReceivedCommandes() {
		assertArrayEquals(new char[]{'F','R','F','L','B'}, commande);
	}
	
	@Test
	public void RoverMovedForward() {
		rover.moveForward();
		System.out.println("RoverMovedForward ="+ rover.getPosition());
		assertEquals("(0,1)", rover.getPosition());
	}
	
	@Test
	public void RoverMovedBackwardAndTurnedRight() {
		rover.moveBackward();
		rover.turnRight();
		System.out.println("RoverMovedBackwardAndTurnedRight :"+rover.getPosition());
		System.out.println("RoverMovedBackwardAndTurnedRight :"+rover.getDirection());
		assertEquals("(0,-1)", rover.getPosition());
		assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void RoverWrappingEdge() {
		roverEdge.moveForward();
		System.out.println("RoverWrappingEdge: "+roverEdge.getPosition());
		assertEquals("(0,-2)", roverEdge.getPosition());
	}

	@Test
	public void RoverExecutecommand() {
		rover.RoverExecuteCmd(commande);
		System.out.println("RoverExecutecommand: Position"+rover.getPosition()+" Direction: "+rover.getDirection());
		assertEquals("(1,0)", rover.getPosition());
		assertEquals('N', rover.getDirection());
	}

	@Test
	public void RoverObstacleDetectionTest() {
		rover.RoverObstacleDetection(commande, obtacles);
		System.out.println("RoverObstacleDetectionTest: Position"+rover.getPosition()+" Direction: "+rover.getDirection());
		assertEquals("(0,1)", rover.getPosition());
		assertEquals('E', rover.getDirection());
	}

}
