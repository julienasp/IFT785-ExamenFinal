/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public interface IReferendumState {
    public int getStateCode();
    public void doStateAction(Referendum r);
    public void doVoting(Referendum r);
    public Object getReferendumResult(Referendum r);
}
