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
        return Referendum.OUVERT;	
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
        Log.log("ReferendumStartState-doStateAction(): The start of the Referendum");
        r.setState(this);	
    }
}
