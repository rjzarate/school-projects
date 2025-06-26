/**
 * Models a person with a name, a gender, and an age.
 * 
 * @author  Qi Yang
 * @version 2022-09-23
 */
public class Person
{
    private String name;
    private char gender;
    private int age;
    
    /**
     * Consructs a Person object.
     * 
     * @param name the name of the person
     * @param gender the gender of the person 
     *        either 'm' for male or 'f' for female
     * @param age the age of the person
     */
    public Person(String name, char gender, int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
    /**
     * Gets the age of this person.
     * 
     * @return the age of this person
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Gets the gender of this person.
     * 
     * @return the gender of this person
     */
    public char getGender()
    {
        return gender;
    }
    
    /**
     * Gets the name of this person.
     * 
     * @return the name of this person
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Increases the age of this person by 1 year.
     */
    public void birthday()
    {
        age ++;
    }
}