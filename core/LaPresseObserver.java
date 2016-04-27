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
public class LaPresseObserver extends Observer {    
    //Récupération de l'instance de LaPresse    
    private LaPresse instance = LaPresse.getInstance();
    
    public LaPresseObserver(Subject subject){
       this.subject = subject;
       this.subject.attach(this);
    }

    @Override
    public void update() {
       switch(this.subject.getState()){
           case 1:
                 instance.ouverteElection();
           case 2:
                 instance.nouveauVote();
           case 3:
                instance.fermetureElection();
           default:
               Log.log("The receive state value isn't handle.");

       } 
    }
}

