package com.itbuzzpress.cdi.bean;

import com.itbuzzpress.cdi.model.Word;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class WordInventory {

	private List<Word> listWords = new ArrayList();

	public void addWord(@Observes Word word) {
		System.out.println("Added new anagram " + word.getAnagram());
 
		listWords.add(word);

	}
	
}