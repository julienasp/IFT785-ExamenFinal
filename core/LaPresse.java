/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class LaPresse {
    /********************************/
    /*DEBUT DESIGN PATTERN SINGLETON*/
    /********************************/
    
    //create an object of SingleObject
    private static LaPresse instance = new LaPresse();

    //make the constructor private so that this class cannot be
    //instantiated
    private LaPresse(){}
    
    synchronized static public LaPresse getInstance() { 
        return instance;
    }
    
    /*******************************/
    /* FIN DESIGN PATTERN SINGLETON*/
    /*******************************/
    
    public void ouverteElection(){ 
        Log.log("LaPresse-ouverteElection(): Debut élection");
    }
    public void nouveauVote(){ 
        Log.log("LaPresse-nouveauVote(): Un nouveau vote");
    }
    public void fermetureElection(){ 
        Log.log("LaPresse-fermetureElection(): Fin élection");
    }
}
