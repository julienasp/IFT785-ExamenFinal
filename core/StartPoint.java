package core;
public class StartPoint {       
    public static void main(String[] args) {
        Referendum r = new Referendum();

        LaPresseObserver lpo = new LaPresseObserver(r.getSubject());
        RadioCanadaObserver rco = new RadioCanadaObserver(r.getSubject());
                
        r.ouvrir();        
        
        r.fermer();
       
        

        
		
	}

}
