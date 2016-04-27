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
public class RadioCanadaObserver extends Observer {    
    //Récupération de l'instance de LaPresse    
    private RadioCanada instance = RadioCanada.getInstance();
    
    public RadioCanadaObserver(Subject subject){
       this.subject = subject;
       this.subject.attach(this);
    }

    @Override
    public void update() {
        switch(this.subject.getState()){
            case Referendum.OUVERT:
                instance.debutElection();
            case Referendum.TERMINE:
                instance.finElection();                 
            case 3:
                instance.unNouveauVote();
           default:
               Log.log("The receive state value isn't handle.");
       } 
    }
}

