/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.core;

import core.Electeur;
import core.IReferendumState;
import core.Referendum;
import core.ReferendumStateFactory;
import core.Subject;
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
    }
    
    @After
    public void tearDown() {
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSubject method, of class Referendum.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        Referendum instance = new Referendum();
        Subject expResult = null;
        Subject result = instance.getSubject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ouvrir method, of class Referendum.
     */
    @Test
    public void testOuvrir() {
        System.out.println("ouvrir");
        Referendum instance = new Referendum();
        instance.ouvrir();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fermer method, of class Referendum.
     */
    @Test
    public void testFermer() {
        System.out.println("fermer");
        Referendum instance = new Referendum();
        instance.fermer();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of votation method, of class Referendum.
     */
    @Test
    public void testVotation() {
        System.out.println("votation");
        Referendum instance = new Referendum();
        instance.votation();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isoloir method, of class Referendum.
     */
    @Test
    public void testIsoloir() {
        System.out.println("isoloir");
        Electeur electeur = null;
        Referendum instance = new Referendum();
        instance.isoloir(electeur);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
