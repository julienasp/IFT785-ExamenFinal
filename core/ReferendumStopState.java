/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumStopState implements IReferendumState {
    @Override
    public int getStateCode() {
        return Referendum.TERMINE;	
    }
    
     @Override
    public Object getReferendumResult(Referendum r) {
        Log.log("ReferendumStopState-getReferendumResult(): invalide state, the Referendum need to be stop first.");
        
        //Refactoring : Replace Temp with Query
        if (r.getVotes(BulletinReferendum.OUI).size() > r.getVotes(BulletinReferendum.NON).size())
            return BulletinReferendum.OUI;
        else
            return BulletinReferendum.NON; 
    }

    @Override
    public void doVoting(Referendum r){
        Log.log("ReferendumStopState-doVoting(): invalide state, the Referendum need to be ongoing to vote.");
    }
    
    @Override
    public void doStateAction(Referendum r) {
        if(r.getState().getStateCode() == Referendum.OUVERT){
            Log.log("ReferendumStopState-doStateAction(): doing action relative to the end of the Referendum");
            
            //We set the new State
            r.setState(this);
            
            //We change the state on the Subject, so he can notify all the observers
            r.getSubject().setState(this.getStateCode()); 
            
            //We proceed
            r.depouiller();
        }
        else{
            Log.log("ReferendumStopState-doStateAction(): invalide state, the Referendum need to be started first.");  
        }
    }
}
