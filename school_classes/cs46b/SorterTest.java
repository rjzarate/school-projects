package tiktoks;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SorterTest {
	
	//hold my test arrays, feel free to add  your own test arrays
	static TikToker[] base = new TikToker[10];
	TikToker[] inOrder = new TikToker[base.length];
	TikToker[] reverse = new TikToker[base.length];
	TikToker[] random = new TikToker[base.length];
	TikToker[] oneElement = new TikToker[1];
	TikToker[] empty = new TikToker[0];

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Note that this array is sorted. Use it to compare to your test arrays
		base[0] = new TikToker("@spencerx",54900000);
		base[1] = new TikToker("@cznburak",56600000);
		base[2] = new TikToker("@dixiedamelio",57100000);
		base[3] = new TikToker("@kimberly.loaiza",59900000);
		base[4] = new TikToker("@willsmith",66300000);
		base[5] = new TikToker("@zachking",67400000);
		base[6] = new TikToker("@addisonre",86700000);
		base[7] = new TikToker("@bellapoarch",88100000);
		base[8] = new TikToker("@charlidamelio",137000000);
		base[9] = new TikToker("@khaby.lame",137000000);
			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//populate in order array
		for(int i=0;i<base.length;i++) {
			inOrder[i]=base[i];
		}
		
		//populate the array in reverse order
		int j = base.length-1;
		for(TikToker t: base) {
			reverse[j] = t;
			j--;
		}

		//populate the array in random order
		Random rand = new Random();
		for(int i=0;i<base.length;i++) {
			random[i]=base[i];
		}
		for (int i = 0; i < random.length; i++) {
			int swapIndex = rand.nextInt(random.length);
			TikToker temp = random[swapIndex];
			random[swapIndex] = random[i];
			random[i] = temp;
		}

		//populate one element array
		oneElement[0] = base[1];
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void interaiveInsertionSortReverseTest() {
		//fill this in and add the other test cases
	}
	
	
}
