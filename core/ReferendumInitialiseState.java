/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumInitialiseState implements IReferendumState{
    @Override
    public int getStateCode() {
        return Election.INITIALISE;	
    }
    
    @Override
    public Object getReferendumResult(Referendum r) {
        Log.log("ReferendumInitialiseState-getReferendumResult(): invalide state, the Referendum need to be stop first.");
        return null;
    }
    
    @Override
    public void doVoting(Referendum r){
        Log.log("ReferendumInitialiseState-doVoting(): invalide state, the Referendum need to be start before you can vote.");
    }
    
    @Override
    public void doStateAction(Referendum r) {
        System.out.println("ReferendumInitialiseState-doStateAction(): The referendum is being initialise.");
        r.setState(this);	
    }
}
