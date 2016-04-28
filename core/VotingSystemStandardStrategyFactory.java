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
            case "REFERENDUMVOTINGSYSTEMSTANDARDSTRATEGY":  Log.log("VotingSystemStandardStrategyFactory-getVotingSystemStandardStrategy(): new ReferendumVotingSystemStandardStrategy returned"); return new ReferendumVotingSystemStandardStrategy(); 
            case "REFERENDUMVSSS":  Log.log("VotingSystemStandardStrategyFactory-getVotingSystemStandardStrategy(): new ReferendumVotingSystemStandardStrategy returned"); return new ReferendumVotingSystemStandardStrategy(); 
            case "NOMINATIVEVOTINGSYSTEMSTANDARDSTRATEGY":  Log.log("VotingSystemStandardStrategyFactory-getVotingSystemStandardStrategy(): new NominativeVotingSystemStandardStrategy returned"); return new NominativeVotingSystemStandardStrategy(); 
            case "NOMINATIVEVSSS":  Log.log("VotingSystemStandardStrategyFactory-getVotingSystemStandardStrategy(): new NominativeVotingSystemStandardStrategy returned"); return new NominativeVotingSystemStandardStrategy(); 
            default: Log.log("VotingSystemStandardStrategyFactory-getVotingSystemStandardStrategy(): null returned");return null;                     
        }
        
    }    
}
