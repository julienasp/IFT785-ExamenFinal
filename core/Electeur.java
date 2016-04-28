package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUASP-G73-Android
 */


public class Electeur {
    /******************************/
    /****  PRIVATE ATTRIBUTES *****/
    /******************************/
    final static int MAN = 0;
    final static int WOMAN = 1;
    private int gender;
    private int age;

    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    public int getGender() {
        return gender;
    }

    public void setGender(int g) {
        this.gender = g;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Electeur() {
        this.gender = Electeur.WOMAN; // Default is WOMAN, because i'm a feminist ;)
        this.age = 21;
    }

    public Electeur(int g, int age) {
        this.gender = g;
        this.age = age;
    }
    
    /***************************************/
    /*************  METHODS ****************/
    /***************************************/
    public void voter(NominativeBallot nb) {
        //We could add an InputStream here to retreive the vote from the userInput
        //we'll vote the first element       
        nb.voter(nb.getNominate().lastElement());
        if(nb.isValide()){
            Log.log("Electeur-voter(): Electeur à voter et son vote est valide");
        }
        else{
            Log.log("Electeur-voter(): Electeur à voter et son vote est non valide");
        }        
    ;}
    public void voter(BulletinReferendum b) {
        //We could add an InputStream here to retreive the vote from the userInput
        //But i'm a Federalist so every voter are voting no 
        b.voter(BulletinReferendum.NON);
        if(b.isValide()){
            Log.log("Electeur-voter(): Electeur à voter et son vote est valide");
        }
        else{
            Log.log("Electeur-voter(): Electeur à voter et son vote est non valide");
        }        
    ;}
}
