// package src;


import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MisspelledCharacterTests {
    
    private String mockString;
    private MisspelledCharacter _misspelledCharacter;

    @Before
    public void initMockString(){
        mockString = "ABCTXTA";
    }

    @After
    public void deleteMockString(){
        mockString = "";
    }

    @Test
    public void testCreateMisspelledTree(){
        TreeSet<String> mockTreeSet = _misspelledCharacter.createMisspelledTree(mockString);
         assertEquals("First latter of tree set is 'A'",mockTreeSet.first(), "A");
         assertEquals("Size of Tree is one",mockTreeSet.size(), 1);
    }

}