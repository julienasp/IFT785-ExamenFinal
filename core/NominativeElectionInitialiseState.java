/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class NominativeElectionInitialiseState implements INominativeElectionState{
    @Override
    public int getStateCode() {
        return Election.INITIALISE;	
    }
    
    @Override
    public Object getNominativeElectionResult(NominativeElection ne) {
        Log.log("NominativeElectionInitialiseState-getNominativeElectionResult(): invalide state, the Nominative Election needs to be stop first.");
        return null;
    }
    
    @Override
    public void doVoting(NominativeElection ne){
        Log.log("NominativeElectionInitialiseState-doVoting(): invalide state, the Nominative Election needs to be start before you can vote.");
    }
    
    @Override
    public void doStateAction(NominativeElection ne) {
        System.out.println("NominativeElectionInitialiseState-doStateAction(): The Nominative Election is being initialise.");
        ne.setState(this);	
    }
}
