package rover;

import static org.junit.Assert.*;
import org.junit.*;
import core.Rover;

public class TestRover {
	
    private Rover rover;
    private Rover roverEdge;
    private char[] commande;

    @Before
    public void beforeRoverTest() {
        rover = new Rover(0, 0, 'N');
        roverEdge = new Rover(0, 2, 'N');
        commande = new char[]{'F','R','F','L','B'};
    }

	@Test
	public void RoverIsFacingNorth() {
		assertEquals('N', rover.getDirection());
	}
	
	@Test
	public void RoverAtBase() {
		assertEquals("(0,0)", rover.getPosition());
	}
	
	@Test
	public void RoveReceivedCommandes() {
		assertArrayEquals(new char[]{'F','R','F','L','B'}, commande);
	}
	
	@Test
	public void RoverMovedForward() {
		rover.moveForward();
		assertEquals("(0,1)", rover.getPosition());
	}
	
	@Test
	public void RoverMovedBackwardAndTurnedRight() {
		rover.moveBackward();
		rover.turnRight();
		assertEquals("(0,-1)", rover.getPosition());
		assertEquals('E', rover.getDirection());
	}
	
	@Test
	public void RoverWrappingEdge() {
		roverEdge.moveForward();
		assertEquals("(0,-2)", roverEdge.getPosition());
	}

}
