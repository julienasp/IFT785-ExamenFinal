/*
 * USED FOR :
 * DESIGN PATTERN : State
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public interface INominativeElectionState {
    public int getStateCode();
    public void doStateAction(NominativeElection ne);
    public void doVoting(NominativeElection ne);
    public Object getNominativeElectionResult(NominativeElection ne);
}
