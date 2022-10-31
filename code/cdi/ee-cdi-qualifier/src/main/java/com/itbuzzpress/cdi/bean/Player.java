package com.itbuzzpress.cdi.bean;

import com.itbuzzpress.cdi.enums.Language;
import com.itbuzzpress.cdi.model.Word;
import com.itbuzzpress.cdi.qualifier.Anagram;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;

@SessionScoped
@Named
public class Player implements Serializable {

	@Inject @Anagram(value=Language.ITALIAN) Word word;	

	int attempt = 1;
	int maxAttempts = 5;
	private String guess;
	private boolean endgame;

	public void check() {
		if (guess.equals(word.getSolution())) {
			endgame = true;
			printMessage("You guessed! Click Restart");
		} else {
			printMessage("Wrong guess!");
			attempt++;
		}
		if (attempt == maxAttempts) {
			printMessage("You lost! Click Restart");
			endgame = true;
		}

	}

	private void printMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, string, string));

	}

	public void restart() {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		ec.invalidateSession();
		try {
			ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isEndgame() {
		return endgame;
	}

	public Word getWord() {
		return word;
	}

	public int getAttempt() {
		return attempt;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}
}