package com.tutorialspoint;

public class TextEditor {
   private SpellChecker spellChecker;
   private String name;
   
   public TextEditor( SpellChecker spellChecker, String name ) {
	      this.spellChecker = spellChecker;
	      this.name = name;
	   }
   
   public void setSpellChecker( SpellChecker spellChecker ){
	   System.out.println("in setter");
      this.spellChecker = spellChecker;
   }
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}