package core;
import java.util.Vector;
public class StartPoint {       
    public static void main(String[] args) {
        MediaObserverFactory mof = new MediaObserverFactory();
        
        /**************************************************/
        /**********  REFERENDUM ELECTION TESTING  *********/
        /**************************************************/
        Referendum r = new Referendum();
        
        r.fermer(); // Test pour msg d'erreur
        r.votation(); // Test pour msg d'erreur
        r.depouiller(); // Test pour msg d'erreur
        
        mof.getMediaObserver("LaPresse", r.getSubject());
        mof.getMediaObserver("RadioCanada", r.getSubject());
                
        r.ouvrir();        
        for(int i = 0; i < 10 ; i++){
            if(i == 4){
                // New Strategy after execution 
                r.setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("ReferendumVotingSystemStandardStrategy")); 
            }
            r.votation(); // Include Election.isoloir()
        }
        r.fermer(); // Include Referendum.depouiller()
        
        //Print the result
        String result = (Integer.parseInt(r.depouiller().toString()) == 1) ? "Non":"Oui";
        System.out.println("The result are : " + result);
        
        
        r.ouvrir(); // Test pour msg d'erreur
        
        /**************************************************/
        /**********  NOMINATIVE ELECTION TESTING  *********/
        /**************************************************/
        
        NominativeElection ne = new NominativeElection();
        
        ne.fermer(); // Test pour msg d'erreur
        ne.votation(); // Test pour msg d'erreur
        ne.depouiller(); // Test pour msg d'erreur
        
        mof.getMediaObserver("LaPresse", ne.getSubject());
        mof.getMediaObserver("RadioCanada", ne.getSubject());
                
        ne.ouvrir();        
        for(int i = 0; i < 10 ; i++){
            if(i == 4){
                // New Strategy after execution 
                ne.setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("NominativeVotingSystemStandardStrategy")); 
            }
            ne.votation(); // Include Election.isoloir()
        }
        ne.fermer(); // Include Referendum.depouiller()
        
        //Print the result
        System.out.println("The nominate are: " + ne.extractNomiate().toString());
        String nominativeResult = ne.depouiller().toString();
        System.out.println("The result are : " + nominativeResult); 
        
        r.ouvrir(); // Test pour msg d'erreur
        
        /************************************************************************/
        /**********  NOMINATIVE ELECTION TESTING WITH CUSTOM NOMINATES  *********/
        /************************************************************************/
        
        Vector<String> randomNamesVector = new Vector<String>();
        
        randomNamesVector.add("Julien");
        randomNamesVector.add("Sylvain");
        randomNamesVector.add("Luc");
        randomNamesVector.add("Karine");
        
        
        NominativeElection neRandomNominates = new NominativeElection(randomNamesVector);
        
        neRandomNominates.fermer(); // Test pour msg d'erreur
        neRandomNominates.votation(); // Test pour msg d'erreur
        neRandomNominates.depouiller(); // Test pour msg d'erreur
        
        mof.getMediaObserver("LaPresse", neRandomNominates.getSubject());
        mof.getMediaObserver("RadioCanada", neRandomNominates.getSubject());
                
        neRandomNominates.ouvrir();        
        for(int i = 0; i < 10 ; i++){
            if(i == 4){
                // New Strategy after execution 
                neRandomNominates.setVotingSystemStandard(VotingSystemStandardStrategyFactory.getVotingSystemStandardStrategy("NominativeVotingSystemStandardStrategy")); 
            }
            neRandomNominates.votation(); // Include Election.isoloir()
        }
        neRandomNominates.fermer(); // Include Referendum.depouiller()
        
        //Print the result
        System.out.println("The nominate are: " + neRandomNominates.extractNomiate().toString());
        String nominativeCustomResult = neRandomNominates.depouiller().toString();
        System.out.println("The result are : " + nominativeCustomResult); 
        
        neRandomNominates.ouvrir(); // Test pour msg d'erreur
        
        
        
	}

}
