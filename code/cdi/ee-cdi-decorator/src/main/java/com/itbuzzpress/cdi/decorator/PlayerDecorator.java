package com.itbuzzpress.cdi.decorator;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;

import java.io.Serializable;


@Decorator
public class PlayerDecorator implements PlayerItf,Serializable {
	 
	
	@Inject @Delegate PlayerItf player;

	
	public void check()  {	 
	    System.out.println("[Decorator] User check with "+player.getGuess());
	    player.check();
	    
	}
	public String getGuess() {
		return player.getGuess();
	}
	public void setGuess(String guess) {
		player.setGuess(guess.toUpperCase());
	}   

}
