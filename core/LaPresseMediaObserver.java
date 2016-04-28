/*
 * USED FOR :
 * DESIGN PATTERN : Observer
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
            case Election.OUVERT:{
                Log.log("LaPresseObserver-update(): The receive state: Election.OUVERT was handle.");
                instance.ouverteElection();
                break;
            }
            case Election.TERMINE:{
                Log.log("LaPresseObserver-update(): The receive state: Election.TERMINE was handle.");
                instance.fermetureElection();
                break;
            }              
            case 3:{
                Log.log("LaPresseObserver-update(): The receive state: Election.NEWVOTE was handle.");
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

