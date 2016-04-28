/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;



/**
 *
 * @author JUASP-G73-Android
 */
public class NominativeElectionStartState implements INominativeElectionState{
    @Override
    public int getStateCode() {
        return Election.OUVERT;	
    }
    
    @Override
    public Object getNominativeElectionResult(NominativeElection ne) {
        Log.log("NominativeElectionStartState-getNominativeElectionResult(): invalide state, the Nominative Election needs to be stop first.");
        return null;
    }
    
    @Override
    public void doVoting(NominativeElection ne){
        Log.log("NominativeElectionStartState-doVoting(): A new vote is being process.");        
        Electeur unElecteur = ne.getElecteurSuivant();
        ne.isoloir(unElecteur);
        ne.getSubject().setState(3); // 3 is the state for a new vote        
    }
    
    @Override
    public void doStateAction(NominativeElection ne) {
        if(ne.getState().getStateCode() == Election.INITIALISE){
            Log.log("NominativeElectionStartState-doStateAction(): The start of the Nominative Election");
            
            //We set the new State
            ne.setState(this);
            
            //We change the state on the Subject, so he can notify all the observers
            ne.getSubject().setState(this.getStateCode());           
        }
        else{
             Log.log("NominativeElectionStartState-doStateAction(): invalide state, the Nominative Election must be initialise first.");
        }
    }
}
