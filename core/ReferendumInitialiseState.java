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
    public void doAction(Referendum r) {
        System.out.println("Player is in start state");
        r.setState(this);	
    }
}
