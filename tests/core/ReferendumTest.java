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

   
    

    
    
}
