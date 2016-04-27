/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumStopState implements ReferendumState {
    @Override
    public int getStateCode() {
        return Referendum.TERMINE;	
    }
    
    @Override
    public void doStateAction(Referendum r) {
        System.out.println("Player is in start state");
        r.setState(this);	
    }
}
