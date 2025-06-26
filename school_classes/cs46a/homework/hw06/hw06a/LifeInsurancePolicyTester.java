/**
 * A Java tester program for LifeInsurancePolicy.
 * 
 * @author  Qi Yang
 * @version 2022-09-23
 */
public class LifeInsurancePolicyTester
{
    public static void main(String[] args)
    {
        //low crime
        //male 79  
        LifeInsurancePolicy policy = new LifeInsurancePolicy(
                new Person("Carlos", 'm', 79), false);
                
        System.out.println("Age: " + policy.policyHolderAge());
        System.out.println("Expected: 79");
        System.out.println("Gender: " + policy.policyHolderGender());
        System.out.println("Expected: m");
        System.out.printf("m 79 low crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $8690.00");
        
        //male 80
        policy.incrementAge(); //increment to 80
        System.out.println("Age: " + policy.policyHolderAge());
        System.out.println("Expected: 80");
        System.out.println("Gender: " + policy.policyHolderGender());
        System.out.println("Expected: m");
        System.out.printf("Overage : %.2f\n", policy.premium());
        System.out.println("Expected: -1.00");
        
        //male 59
        policy = new LifeInsurancePolicy(
            new Person("Henry", 'm', 59), false);
        System.out.printf("m 59 low crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $2950.00");
        
        //male < 21
        policy = new LifeInsurancePolicy(
            new Person("Tien", 'm', 20), false);
        System.out.printf("male < 20 low crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $400.00");
        
        //high crime
        //male  21
        policy = new LifeInsurancePolicy(
            new Person("Tien", 'm', 21), true);
        System.out.printf("m 21 to 59 high crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $1155.00");
        
        //high crime
        //female 60 
        policy = new LifeInsurancePolicy(
                new Person("Maria", 'f', 60), true);
        System.out.printf("f 60 high crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $6600.00");
        
        //high crime
        //female 10 
        policy = new LifeInsurancePolicy(
                new Person("Dong", 'f', 10), true);
        System.out.printf("f 10 high crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $203.50");
        
        //high crime
        //female 30 
        policy = new LifeInsurancePolicy(
                new Person("Ashwani", 'f', 30), true);
        System.out.println("Age: " + policy.policyHolderAge());
        System.out.println("Expected: 30");
        System.out.println("Gender: " + policy.policyHolderGender());
        System.out.println("Expected: f");
        System.out.printf("f 30 high crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $1485.00");
        
        //female 80
        policy = new LifeInsurancePolicy(
                new Person("Doris", 'f', 80), true);
        System.out.printf("Overage : %.2f\n", policy.premium());
        System.out.println("Expected: -1.00");
        
        //low crime
        //female 21 
        policy = new LifeInsurancePolicy(
                new Person("Ashwani", 'f', 21), false);
        System.out.printf("f 21 low crime: $%.2f\n", policy.premium());
        System.out.println("Expected: $945.00");
    }
}