package com.itbuzzpress.cdi.bean;


import com.itbuzzpress.cdi.model.Word;
import com.itbuzzpress.cdi.qualifier.Anagram;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class GenerateWord {

	@Produces
	@Anagram
	public Word createAnagram(){
		List<String> wordList = new ArrayList();
		wordList.add("house");
		wordList.add("garden");
		wordList.add("doorway");
		wordList.add("window");

		return shuffle(wordList);
	}

	public Word shuffle(List<String> wordList){

		Random rand = new Random();

		int  index = rand.nextInt(wordList.size());
		String word = wordList.get(index);
		List<Character> characters = new ArrayList<Character>();
		for(char c:word.toCharArray()){
			characters.add(c);
		}
		StringBuilder output = new StringBuilder(word.length());
		while(characters.size()!=0){
			int randPicker = (int)(Math.random()*characters.size());
			output.append(characters.remove(randPicker));
		}
		System.out.println("Secret word is "+word);
		return new Word(word, output.toString());
	}

}