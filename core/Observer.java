/*
 * USED FOR :
 * DESIGN PATTERN : Observer 
 */
package core;

/**
 *
 * @author JUASP-G73-Android
 */
public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}
