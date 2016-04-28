/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class NominativeElectionStopState implements INominativeElectionState {
    @Override
    public int getStateCode() {
        return Election.TERMINE;	
    }
    
     @Override
    public Object getNominativeElectionResult(NominativeElection ne) {
        Log.log("NominativeElectionStopState-getNominativeElectionResult(): invalide state, the Referendum need to be stop first.");
        
        //Use of the Strategy pattern inside the state pattern
        return ne.getVotingSystemStandard().processingResult(ne);
    }

    @Override
    public void doVoting(NominativeElection ne){
        Log.log("NominativeElectionStopState-doVoting(): invalide state, the Referendum need to be ongoing to vote.");
    }
    
    @Override
    public void doStateAction(NominativeElection ne) {
        if(ne.getState().getStateCode() == Election.OUVERT){
            Log.log("NominativeElectionStopState-doStateAction(): doing action relative to the end of the Referendum");
            
            //We set the new State
            ne.setState(this);
            
            //We change the state on the Subject, so he can notify all the observers
            ne.getSubject().setState(this.getStateCode()); 
            
            //We proceed
            ne.depouiller();
        }
        else{
            Log.log("NominativeElectionStopState-doStateAction(): invalide state, the Referendum need to be started first.");  
        }
    }
}
