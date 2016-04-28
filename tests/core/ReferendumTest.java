/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.core;

import core.Electeur;
import core.IReferendumState;
import core.MediaObserverFactory;
import core.Observer;
import core.Referendum;
import core.ReferendumStateFactory;
import core.Subject;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JUASP-G73-Android
 */
public class ReferendumTest {
    private Referendum r;    
    public ReferendumTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        r = new Referendum();        
    }
    
    @After
    public void tearDown() {
        r = null;
    }
    
    /**
     * Test of fermer method, with bad state value
     */
    @Test
    public void testInvalideStateMsgForFermer() {
        System.out.println("Start - InvalideStateMsgForFermer");        
        r.fermer();
        System.out.println("End - InvalideStateMsgForFermer");        
    }
    
     /**
     * Test of voting method, with bad state value
     */
    @Test
    public void testInvalideStateMsgForVotation() {
        System.out.println("Start - InvalideStateMsgForVotation");        
        r.votation();
        System.out.println("End - InvalideStateMsgForVotation");        
    }
    
     /**
     * Test of depouiller method, with bad state value
     */
    @Test
    public void testInvalideStateMsgForDepouiller() {
        System.out.println("Start - InvalideStateMsgForDepouiller");        
        r.depouiller();
        System.out.println("End - InvalideStateMsgForDepouiller");        
    }
    
     /**
     * Test of ouvrir method, with bad state value
     */
    @Test
    public void testInvalideStateMsgForOuvrir() {
        System.out.println("Start - InvalideStateMsgForOuvrir");
        Referendum instance = new Referendum();
        instance.ouvrir();
        instance.fermer();
        instance.ouvrir();
        System.out.println("End - InvalideStateMsgForOuvrir");        
    }

    /**
     * Test of getState method, of class Referendum.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Referendum instance = new Referendum();
        IReferendumState expResult = ReferendumStateFactory.getReferendumState("INITIALISE");
        IReferendumState result = instance.getState();
        assertEquals(expResult.getStateCode(), result.getStateCode());     
    }

    /**
     * Test of setState method, of class Referendum.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        IReferendumState state = null;
        Referendum instance = new Referendum();
        instance.setState(state);
        assertEquals(state, instance.getState());     
    }

    /**
     * Test of getSubject method, of class Referendum.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Referendum instance = new Referendum();
        Subject expResult = null;
        instance.setSubject(null);
        Subject result = instance.getSubject();
        assertEquals(expResult, result);    
    }

    /**
     * Test of setSubject method, of class Referendum.
     */
    @Test
    public void testSetSubject() {
        System.out.println("setSubject");
        Subject subject = null;
        Referendum instance = new Referendum();
        instance.setSubject(subject);
        assertEquals(subject, instance.getSubject());    
    }

    /**
     * Test of ouvrir method, of class Referendum.
     */
    @Test
    public void testOuvrir() {
        System.out.println("ouvrir");
        Referendum instance = new Referendum();
        instance.ouvrir();    
    }

    /**
     * Test of fermer method, of class Referendum.
     */
    @Test
    public void testFermer() {
        System.out.println("fermer");
        Referendum instance = new Referendum();
        instance.fermer();
    }

    /**
     * Test of votation method, of class Referendum.
     */
    @Test
    public void testVotation() {
        System.out.println("votation");
        Referendum instance = new Referendum();
        instance.votation();    
    }

    /**
     * Test of depouiller method, of class Referendum.
     */
    @Test
    public void testDepouiller() {
        System.out.println("depouiller");
        Referendum instance = new Referendum();
        Object expResult = null;
        Object result = instance.depouiller();
        assertEquals(expResult, result);     
    }
}
