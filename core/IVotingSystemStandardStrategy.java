/*
 * USED FOR :
 * DESIGN PATTERN : Strategy
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public interface IVotingSystemStandardStrategy {
    public boolean validateEligibility(Electeur e);
    public Bulletin giveBallotPaper();
    public void votingProcess(Electeur e, Bulletin b);    
    public void savingVote(Election e, Bulletin b);
    public Object processingResult(Election e);
}
