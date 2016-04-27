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
public class RadioCanada {
    /********************************/
    /*DEBUT DESIGN PATTERN SINGLETON*/
    /********************************/
    
    //create an object of SingleObject
    private static RadioCanada instance = new RadioCanada();

    //make the constructor private so that this class cannot be
    //instantiated
    private RadioCanada(){}
    
    synchronized static public RadioCanada getInstance() { 
        return instance;
    }
    
    /*******************************/
    /* FIN DESIGN PATTERN SINGLETON*/
    /*******************************/
    public void debutElection(){ 
        Log.log("RadioCanada-debutElection(): Debut élection");
    }
    public void unNouveauVote(){ 
        Log.log("RadioCanada-unNouveauVote(): Un nouveau vote");
    }
    public void finElection(){ 
        Log.log("RadioCanada-finElection():Fin élection");
    }

}
