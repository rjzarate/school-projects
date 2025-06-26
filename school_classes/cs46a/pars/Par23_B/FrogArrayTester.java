/**
 * A Java tester program for class FrogArray.
 *
 * @author  Qi Yang
 * @version 2022-11-29
 */
public class FrogArrayTester
{
    public static void main(String[] args)
    {
        Frog[] arrayTwo = new Frog[10];
        arrayTwo[0] = new Frog("xyz1", 5);
        arrayTwo[1] = new Frog("xyz2", 25);
        arrayTwo[2] = new Frog("xyz3", 12);
        FrogArray frogArray = new FrogArray(arrayTwo, 3);

        System.out.println("Before sorting:");
        System.out.println(frogArray);
        System.out.println("Expected: [Frog[ID:xyz1,Weight:5,Legs:0], " +
                                      "Frog[ID:xyz2,Weight:25,Legs:4], " +
                                      "Frog[ID:xyz3,Weight:12,Legs:2]]");
        
        frogArray.sort();
        
        System.out.println("After sorting:");
        System.out.println(frogArray);
        System.out.println("Expected: [Frog[ID:xyz1,Weight:5,Legs:0], " +
                                      "Frog[ID:xyz3,Weight:12,Legs:2], " +
                                      "Frog[ID:xyz2,Weight:25,Legs:4]]");

        frogArray.add(new Frog("uvw1", 10));
        frogArray.add(new Frog("uvw2", 5));
        frogArray.add(new Frog("xyz0", 12));
        
        System.out.println("Before sorting:");
        System.out.println(frogArray);
        System.out.println("Expected: [Frog[ID:xyz1,Weight:5,Legs:0], " +
                                      "Frog[ID:xyz3,Weight:12,Legs:2], " +
                                      "Frog[ID:xyz2,Weight:25,Legs:4], " +
                                      "Frog[ID:uvw1,Weight:10,Legs:2], " +
                                      "Frog[ID:uvw2,Weight:5,Legs:0], " +
                                      "Frog[ID:xyz0,Weight:12,Legs:2]]");
        
        frogArray.sort();
        
        System.out.println("After sorting:");
        System.out.println(frogArray);
        System.out.println("Expected: [Frog[ID:uvw2,Weight:5,Legs:0], " +
                                      "Frog[ID:xyz1,Weight:5,Legs:0], " +
                                      "Frog[ID:uvw1,Weight:10,Legs:2], " +
                                      "Frog[ID:xyz0,Weight:12,Legs:2], " +
                                      "Frog[ID:xyz3,Weight:12,Legs:2], " +
                                      "Frog[ID:xyz2,Weight:25,Legs:4]]");
    }
}
