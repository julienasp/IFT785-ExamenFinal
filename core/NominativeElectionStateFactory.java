/*
 * USED FOR :
 * DESIGN PATTERN : Factory Pattern
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class NominativeElectionStateFactory {
    public static INominativeElectionState getNominativeElectionState(String typeNominativeElectionState){
        
	switch (typeNominativeElectionState.toUpperCase()) {
            case "INITIALISE":  Log.log("NominativeElectionStateFactory-getNominativeElectionState(): new NominativeElectionInitialiseState returned"); return new NominativeElectionInitialiseState();                    
            case "START":  Log.log("NominativeElectionStateFactory-getNominativeElectionState(): new NominativeElectionStartState returned"); return new NominativeElectionStartState(); 
            case "STOP":  Log.log("NominativeElectionStateFactory-getNominativeElectionState(): new NominativeElectionStopState returned"); return new NominativeElectionStopState();
            default: Log.log("NominativeElectionStateFactory-getNominativeElectionState(): null returned");return null;                     
        }
        
    }    
}
