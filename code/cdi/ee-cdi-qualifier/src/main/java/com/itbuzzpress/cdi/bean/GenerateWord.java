package com.itbuzzpress.cdi.bean;


import com.itbuzzpress.cdi.enums.Language;
import com.itbuzzpress.cdi.model.Word;
import com.itbuzzpress.cdi.qualifier.Anagram;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateWord {



	public void disposeWord(@Disposes @Any Word word) {

		System.out.println("The word was "+word.getSolution());
	}

	@Produces @Anagram(value=Language.ENGLISH)  
	public Word createEnglishAnagram(){
		System.out.println("Generating English Anagram");
		List<String>wordList = getEnglishDictionary();

		return shuffle(wordList);
	}



	@Produces @Anagram(value=Language.ITALIAN)  
	public Word createItalianAnagram(){
                System.out.println("Generating Italian Anagram");
		List<String>wordList = getItalianDictionary();

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
		return new Word(word, output.toString());
	}

	private List<String> getEnglishDictionary() {
		List<String> wordList = new ArrayList();
		wordList.add("house");
		wordList.add("garden");
		wordList.add("door");
		wordList.add("window");
		return wordList;

	}
	private List<String> getItalianDictionary() {

		List<String> wordList = new ArrayList();
		wordList.add("casa");
		wordList.add("giardino");
		wordList.add("porta");
		wordList.add("finestra");
		return wordList;
	}
}
