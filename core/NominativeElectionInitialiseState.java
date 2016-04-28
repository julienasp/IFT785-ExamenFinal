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
        Log.log("NominativeElectionInitialiseState-getReferendumResult(): invalide state, the Referendum need to be stop first.");
        return null;
    }
    
    @Override
    public void doVoting(NominativeElection ne){
        Log.log("NominativeElectionInitialiseState-doVoting(): invalide state, the Referendum need to be start before you can vote.");
    }
    
    @Override
    public void doStateAction(NominativeElection ne) {
        System.out.println("NominativeElectionInitialiseState-doStateAction(): The referendum is being initialise.");
        ne.setState(this);	
    }
}
