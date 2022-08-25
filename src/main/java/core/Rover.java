/**
 * 
 */
package core;

/**
 * @author AD
 *
 */
public class Rover {
	
	private int x;
	private int y;
	private int planetSize = 5;
	private char direction;
	
	public Rover(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public char getDirection() {
		return this.direction;
	}
	
	public String getPosition() {
		return "(" + x + "," + y + ")";
	}
	
	public void moveForward() {
		
		switch(direction){
		   
	      case 'N':
	    	  if(y == (planetSize/2)) {
	    		  y = y * -1;
	    	  }else {
	    		  y = y + 1;  
	    	  }
	    	  break;
	   
	       case 'S':
	    	  if(y == -(planetSize/2)) {
	    		  y = y * -1;
	    	  }else {
	    		  y = y - 1;  
	    	  }
	          break;
	           
	       case 'E':
	    	  if(x == (planetSize/2)) {
	    		  x = x * -1;
	    	  }else {
	    		  x = x + 1;  
	    	  }
	          break;
	           
	       case 'W':
	    	  if(x == -(planetSize/2)) {
	    		  x = x * -1;
	    	  }else {
	    		  x = x - 1;
	    	  }
	          break;
		}
	}
	
	public void moveBackward() {
		
		switch(direction){
		   
	      case 'N': 
	    	  if(y == -(planetSize/2)) {
	    		  y = y * -1;
	    	  }else {
	    		  y = y - 1;
	    	  }
	          break;
	   
	       case 'S':
	    	  if(y == (planetSize/2)) {
	    		  y = y * -1;
	    	  }else {
	    		  y = y - 1;
	    	  }
	          break;
	           
	       case 'E':
	    	  if(x == -(planetSize/2)) {
	    		  x = x * -1;
	    	  }else {
	    		  x = x - 1;
	    	  }
	          break;
	           
	       case 'W':
	    	  if(x == (planetSize/2)) {
	    		  x = x * -1;
	    	  }else {
	    		  x = x - 1;
	    	  }
	          break;
		}
	}
	
	public void turnRight() {
		
		switch(direction){
		   
	      case 'N':
	    	  direction = 'E';
	          break;
	   
	       case 'S':
	    	  direction = 'W';
	          break;
	           
	       case 'E':
	    	  direction = 'S';
	          break;
	           
	       case 'W':
	    	  direction = 'N';
	          break;
		}
	}
	
	public void turnLeft() {
		
		switch(direction){
		   
	      case 'N':
	    	  direction = 'W';
	          break;
	   
	       case 'S':
	    	  direction = 'E';
	          break;
	           
	       case 'E':
	    	  direction = 'N';
	          break;
	           
	       case 'W':
	    	  direction = 'S';
	          break;
		}
	}
	
}
