/*
 * USED FOR :
 * DESIGN PATTERN : Factory Pattern
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumStateFactory {
    public static IReferendumState getReferendumState(String typeReferendumState){
        
	switch (typeReferendumState.toUpperCase()) {
            case "INITIALISE":  Log.log("ReferendumStateFactory-getReferendumState(): new ReferendumInitialiseState returned"); return new ReferendumInitialiseState();                    
            case "START":  Log.log("ReferendumStateFactory-getReferendumState(): new ReferendumStartState returned"); return new ReferendumStartState(); 
            case "STOP":  Log.log("ReferendumStateFactory-getReferendumState(): new ReferendumStopState returned"); return new ReferendumStopState();
            default: Log.log("ReferendumStateFactory-getReferendumState(): null returned");return null;                     
        }
        
    }    
}
