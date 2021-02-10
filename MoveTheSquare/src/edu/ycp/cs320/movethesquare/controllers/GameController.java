package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	private double lastFrame, currFrame, deltaTime;
	
	public GameController()
	{		
		currFrame = System.currentTimeMillis();
		lastFrame = System.currentTimeMillis();
		deltaTime = 0;
	}
	
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST * deltaTime;
			} else if(dx < 0){
				moveX = -Game.MOVE_DIST * deltaTime;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST * deltaTime;
			} else if(dy < 0){
				moveY = -Game.MOVE_DIST * deltaTime;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
		currFrame = System.currentTimeMillis();
		deltaTime = (currFrame - lastFrame) / 1000; //	time between frames in seconds
		lastFrame = currFrame;
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
}
