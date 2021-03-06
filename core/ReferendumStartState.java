/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;



/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumStartState implements IReferendumState{
    @Override
    public int getStateCode() {
        return Election.OUVERT;	
    }
    
    @Override
    public Object getReferendumResult(Referendum r) {
        Log.log("ReferendumStartState-getReferendumResult(): invalide state, the Referendum need to be stop first.");
        return null;
    }
    
    @Override
    public void doVoting(Referendum r){
        Log.log("ReferendumStartState-doVoting(): A new vote is being process.");        
        Electeur unElecteur = r.getElecteurSuivant();
        r.isoloir(unElecteur);
        r.getSubject().setState(3); // 3 is the state for a new vote        
    }
    
    @Override
    public void doStateAction(Referendum r) {
        if(r.getState().getStateCode() == Election.INITIALISE){
            Log.log("ReferendumStartState-doStateAction(): The start of the Referendum");
            
            //We set the new State
            r.setState(this);
            
            //We change the state on the Subject, so he can notify all the observers
            r.getSubject().setState(this.getStateCode());           
        }
        else{
             Log.log("ReferendumStartState-doStateAction(): invalide state, the Referendum must be initialise first.");
        }
    }
}
