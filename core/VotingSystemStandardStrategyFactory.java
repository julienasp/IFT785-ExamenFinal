/*
 * USED FOR :
 * DESIGN PATTERN : Factory pattern
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public class VotingSystemStandardStrategyFactory {
    public static IVotingSystemStandardStrategy getVotingSystemStandardStrategy(String typeVotingSystemStandardStrategy){
        
	switch (typeVotingSystemStandardStrategy.toUpperCase()) {
            case "REFERENDUMVOTINGSYSTEMSTANDARDSTRATEGY":  Log.log("ReferendumStateFactory-getVotingSystemStandardStrategy(): new ReferendumVotingSystemStandardStrategy returned"); return new ReferendumVotingSystemStandardStrategy(); 
            case "REFERENDUMVSSS":  Log.log("ReferendumStateFactory-getVotingSystemStandardStrategy(): new ReferendumVotingSystemStandardStrategy returned"); return new ReferendumVotingSystemStandardStrategy(); 
            default: Log.log("ReferendumStateFactory-getVotingSystemStandardStrategy(): null returned");return null;                     
        }
        
    }    
}
