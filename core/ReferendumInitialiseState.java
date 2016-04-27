/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumInitialiseState implements ReferendumState{
    @Override
    public int getStateCode() {
        return Referendum.INITIALISE;	
    }
    
    @Override
    public void doStateAction(Referendum r) {
        System.out.println("Player is in start state");
        r.setState(this);	
    }
}
