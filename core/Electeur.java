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
    private int sexe;
    private int age;

    /***************************************/
    /********  GETTER AND SETTER ***********/
    /***************************************/
    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Electeur() {
        this.sexe = Electeur.WOMAN; // Default is WOMAN, because i'm a feminist ;)
        this.age = 21;
    }

    public Electeur(int sexe, int age) {
        this.sexe = sexe;
        this.age = age;
    }
    
    /***************************************/
    /*************  METHODS ****************/
    /***************************************/
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
