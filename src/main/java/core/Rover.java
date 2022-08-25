/**
 * 
 */
package core;

import java.util.Arrays;

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
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
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
	
	public String RoverExecuteCmd(char[] cmd) {
		System.out.println("Initial position and direction: "+this.getPosition()+"	"+this.getDirection());
		for(char c : cmd){
			System.out.println("current Cmd: "+c);
			switch(c) {
				case 'F' : 
					this.moveForward();
					break;
				case 'B' : 
					this.moveBackward();
					break;
				case 'L' :
					this.turnLeft();
					break;
				case 'R' : 
					this.turnRight();
					break;
			}
		}
		System.out.println("Final position and direction: "+this.getPosition()+"	"+this.getDirection());
		return this.getPosition();
	}
	
	public String calculateNextPosition(char c,char direction) {
		int possibleX = this.getX();
		int possibleY = this.getY();
		switch(direction) { 
			case 'N':{
				if(c == 'F'){
					 if(possibleY == (planetSize/2)) {
						 possibleY = possibleY * -1;
			    	  }else {
			    		  possibleY = possibleY + 1;  
			    	  }
				}else if(c == 'B') {
					 if(possibleY == -(planetSize/2)) {
						 possibleY = possibleY * -1;
			    	  }else {
			    		  possibleY = possibleY - 1;
			    	  }
			          break;
				}
			}
	          break;
			case 'S':
				if(c == 'F') {
					if(possibleY == -(planetSize/2)) {
			    		  possibleY = possibleY * -1;
			    	  }else {
			    		  possibleY = possibleY - 1;  
			    	  }
				}else if(c == 'B') {
					if(possibleY == (planetSize/2)) {
			    		  possibleY = possibleY * -1;
			    	  }else {
			    		  possibleY = possibleY - 1;
			    	  }
				}
	          break;   
			case 'E':
				if(c == 'F') {
				 if(possibleX == (planetSize/2)) {
		    		  possibleX = possibleX * -1;
		    	  }else {
		    		  possibleX = possibleX + 1;  
		    	  }
				}else if(c == 'B') {
					 if(possibleX == -(planetSize/2)) {
			    		  possibleX = possibleX * -1;
			    	  }else {
			    		  possibleX = possibleX - 1;
			    	  }
				}
	          break;   
			case 'W':
				if(c == 'F') {
					 if(possibleX == -(planetSize/2)) {
			    		  possibleX = possibleX * -1;
			    	  }else {
			    		  possibleX = possibleX - 1;
			    	  }
				}else if(c == 'B') {
					 if(possibleX == (planetSize/2)) {
			    		  possibleX = possibleX * -1;
			    	  }else {
			    		  possibleX = possibleX - 1;
			    	  }
				}
	          break;
		}
		return  "(" + possibleX + "," + possibleY + ")";
	}
	
	
	public String RoverObstacleDetection(char[] cmd,String[] obstacles) {
		String trickyposition="";
		for(char c : cmd) {
			String futurePos = this.calculateNextPosition(c, this.getDirection());
			if(Arrays.asList(obstacles).contains(futurePos)) {
				trickyposition = futurePos;
				break;
			}else {
				char[] cmds= new char[]{c};
				this.RoverExecuteCmd(cmds);
			}
		}
		System.out.println("Obstacle detected at position : "+trickyposition);
		return trickyposition;
	}
	
}
