/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.core;

import core.BulletinReferendum;
import core.Electeur;
import core.Referendum;
import java.util.Vector;
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
     * Test of ouvrir method, of class Referendum.
     */
    @Test
    public void testOuvrir() {
        System.out.println("ouvrir");
        Referendum instance = new Referendum();
        instance.ouvrir();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of estEligible method, of class Referendum.
     */
    @Test
    public void testEstEligible() {
        System.out.println("estEligible");
        Electeur electeur = null;
        Referendum instance = new Referendum();
        boolean expResult = false;
        boolean result = instance.estEligible(electeur);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElecteurSuivant method, of class Referendum.
     */
    @Test
    public void testGetElecteurSuivant() {
        System.out.println("getElecteurSuivant");
        Referendum instance = new Referendum();
        Electeur expResult = null;
        Electeur result = instance.getElecteurSuivant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVotes method, of class Referendum.
     */
    @Test
    public void testGetVotes_0args() {
        System.out.println("getVotes");
        Referendum instance = new Referendum();
        Vector[] expResult = null;
        Vector[] result = instance.getVotes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVotes method, of class Referendum.
     */
    @Test
    public void testGetVotes_int() {
        System.out.println("getVotes");
        int i = 0;
        Referendum instance = new Referendum();
        Vector<BulletinReferendum> expResult = null;
        Vector<BulletinReferendum> result = instance.getVotes(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVotes method, of class Referendum.
     */
    @Test
    public void testSetVotes_VectorArr() {
        System.out.println("setVotes");
        Vector[] votes = null;
        Referendum instance = new Referendum();
        instance.setVotes(votes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVotes method, of class Referendum.
     */
    @Test
    public void testSetVotes_int_Vector() {
        System.out.println("setVotes");
        int i = 0;
        Vector<BulletinReferendum> v = null;
        Referendum instance = new Referendum();
        instance.setVotes(i, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
