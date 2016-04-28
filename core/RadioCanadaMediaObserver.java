/*
 * USED FOR :
 * DESIGN PATTERN : Observer 
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
            case Election.OUVERT:
                Log.log("RadioCanadaObserver-update(); The receive state: Election.OUVERT was handle.");
                instance.debutElection();
                break;
            case Election.TERMINE:
                Log.log("RadioCanadaObserver-update(); The receive state: Election.TERMINE was handle.");
                instance.finElection(); 
                break;
            case 3:
                Log.log("RadioCanadaObserver-update(); The receive state: Election.NEWVOTE was handle.");
                instance.unNouveauVote();
                break;
           default:
               Log.log("RadioCanadaObserver-update(); The receive state: "+this.subject.getState()+" isn't handle.");
               break;
       } 
    }
}

