package core;
public class StartPoint {       
    public static void main(String[] args) {
        Referendum r = new Referendum();
        
        MediaObserverFactory mof = new MediaObserverFactory();
        
        Observer lpo = mof.getMediaObserver("LaPresse", r.getSubject());
        Observer rco = mof.getMediaObserver("RadioCanada", r.getSubject());
                
        r.ouvrir();        
        for(int i = 0; i < 10 ; i++){
            r.votation();
        }
        r.fermer();
        
	}

}
