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
            case Referendum.OUVERT:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.OUVERT was handle.");
                instance.debutElection();
                break;
            case Referendum.TERMINE:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.TERMINE was handle.");
                instance.finElection(); 
                break;
            case 3:
                Log.log("RadioCanadaObserver-update(); The receive state: Referendum.NEWVOTE was handle.");
                instance.unNouveauVote();
                break;
           default:
               Log.log("RadioCanadaObserver-update(); The receive state: "+this.subject.getState()+" isn't handle.");
               break;
       } 
    }
}

