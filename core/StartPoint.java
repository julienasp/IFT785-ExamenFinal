package core;
public class StartPoint {       
    public static void main(String[] args) {
        Referendum r = new Referendum();
        
        r.fermer(); // Test pour msg d'erreur
        r.votation(); // Test pour msg d'erreur
        r.depouiller(); // Test pour msg d'erreur
        
        
        MediaObserverFactory mof = new MediaObserverFactory();
        
        Observer lpo = mof.getMediaObserver("LaPresse", r.getSubject());
        Observer rco = mof.getMediaObserver("RadioCanada", r.getSubject());
                
        r.ouvrir();        
        for(int i = 0; i < 10 ; i++){
            r.votation();
        }
        r.fermer();
        
        
        r.ouvrir(); // Test pour msg d'erreur
	}

}
