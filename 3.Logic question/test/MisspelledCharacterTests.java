import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
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

        BinarySearchTree mockBinarySearchTree = _misspelledCharacter.createMisspelledTree(mockString);
        Assert.assertEquals("First latter of tree set is 'A'",mockBinarySearchTree..toString(), "A");
        Assert.assertEquals("Size of Tree is one",mockTreeSet.size(), 1);

    }

}