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
    public void voter(BulletinReferendum b) {
        //We could add an InputStream here to retreive the vote from the userInput
        //But i'm a Federalist so every voter are voting no 
        b.voter(BulletinReferendum.NON);
        if(b.isValide()){
            Log.log("Electeur à voter et son vote est valide");
        }
        else{
            Log.log("Electeur à voter et son vote est non valide");
        }        
    ;}
}
