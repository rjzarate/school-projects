package tiktoks;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearcherTest {
	
	static TikToker[] even = new TikToker[10];
	static TikToker[] odd = new TikToker[9];
	static TikToker[] empty = new TikToker[0];
	static TikToker notFound; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		even[0] = odd[0] = new TikToker("@spencerx",54900000);
		even[1] = odd[1] = new TikToker("@cznburak",56600000);
		even[2] = odd[2] = new TikToker("@dixiedamelio",57100000);
		even[3] = odd[3] = new TikToker("@kimberly.loaiza",59900000);
		even[4] = odd[4] = new TikToker("@willsmith",66300000);
		even[5] = odd[5] = new TikToker("@zachking",67400000);
		even[6] = odd[6] = new TikToker("@addisonre",86700000);
		even[7] = odd[7] = new TikToker("@bellapoarch",88100000);
		even[8] = odd[8] = new TikToker("@charlidamelio",137000000);
		even[9] = new TikToker("@khaby.lame",137000000);
		
		notFound = new TikToker("@rumpledeater",18);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void iterativeFoundOdd() {
        //fill this in and add the other test cases
	}
	

}
