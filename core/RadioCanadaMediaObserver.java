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
public class RadioCanadaMediaObserver extends Observer {    
    //Récupération de l'instance de LaPresse    
    private RadioCanada instance = RadioCanada.getInstance();
    
    public RadioCanadaMediaObserver(Subject subject){
       this.subject = subject;
       this.subject.attach(this);
    }

    @Override
    public void update() {
        switch(this.subject.getState()){
            case Referendum.OUVERT:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.OUVERT was handle.");
                instance.debutElection();
            case Referendum.TERMINE:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.TERMINE was handle.");
                instance.finElection();                 
            case 3:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.NEWVOTE was handle.");
                instance.unNouveauVote();
           default:
               Log.log("RadioCanadaObserver-update(); The receive state: "+this.subject.getState()+" isn't handle.");
       } 
    }
}

