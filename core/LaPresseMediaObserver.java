/*
 * USED FOR :
 * DESIGN PATTERN : OBSERVER 
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class LaPresseMediaObserver extends Observer {    
    //Récupération de l'instance de LaPresse    
    private LaPresse instance = LaPresse.getInstance();
    
    public LaPresseMediaObserver(Subject subject){
       this.subject = subject;
       this.subject.attach(this);
    }

    @Override
    public void update() {
        switch(this.subject.getState()){
            case Referendum.OUVERT:{
                Log.log("LaPresseObserver-update(): The receive state: Referendum.OUVERT was handle.");
                instance.ouverteElection();
                break;
            }
            case Referendum.TERMINE:{
                Log.log("LaPresseObserver-update(): The receive state: Referendum.TERMINE was handle.");
                instance.fermetureElection();
                break;
            }              
            case 3:{
                Log.log("LaPresseObserver-update(): The receive state: Referendum.NEWVOTE was handle.");
                instance.nouveauVote();
                break;
            }
           default:{
               Log.log("LaPresseObserver-update(): The receive state: "+this.subject.getState()+" isn't handle.");
               break;
           }
       } 
    }
}

