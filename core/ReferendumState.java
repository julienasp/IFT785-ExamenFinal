/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public interface ReferendumState {
    public int getStateCode();
    public void doStateAction(Referendum r);
}
