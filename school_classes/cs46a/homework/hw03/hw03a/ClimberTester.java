/**
 * Tests the Climber class.
 * 
 * @author Qi Yang
 * @version 2022-09-01
 *
 */
public class ClimberTester
{
    public static void main(String[] arg)
    {
        Climber climber1 = new Climber("Carlos", 5);
        Climber climber2 = new Climber("Thong", 9);

        System.out.println(climber1.getName());
        System.out.println("Expected: Carlos");
        System.out.println(climber1.getPosition());
        System.out.println("Expected: 5");

        climber1.climb();
        climber1.climb();
        climber1.climb();
        System.out.println(climber1.getPosition());
        System.out.println("Expected: 8");

        climber1.slide();
        System.out.println(climber1.getPosition());
        System.out.println("Expected: 0");
        
        climber1.setName("Maria");
        System.out.println(climber1.getName()); 
        System.out.println("Expected: Maria");
        
        climber1.slide();
        climber1.slide();
        System.out.println(climber1.getPosition());
        System.out.println("Expected: 0");

        System.out.println(climber2.getName());
        System.out.println("Expected: Thong");
        System.out.println(climber2.getPosition());
        System.out.println("Expected: 9");

        climber2.climb();
        System.out.println(climber2.getPosition());
        System.out.println("Expected: 10");
        
        climber2.slide();
        System.out.println(climber2.getPosition());
        System.out.println("Expected: 0");
    }
}