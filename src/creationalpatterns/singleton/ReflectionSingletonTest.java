package creationalpatterns.singleton;

import java.lang.reflect.Constructor;

/*
    Reflection can be used to destroy all the above singleton implementation
    approaches.  hashCode of both the instances are not same that destroys the singleton pattern.
    Reflection is very powerful and used in a lot of frameworks like Spring and Hibernate
    
    To overcome this situation with Reflection, Joshua Bloch suggests the use of
    Enum to implement Singleton design pattern as Java ensures that any enum
    value is instantiated only once in a Java program. Since Java Enum values
    are globally accessible, so is the singleton. The drawback is that the enum
    type is somewhat inflexible; for example, it does not allow lazy
    initialization.
*/
public class ReflectionSingletonTest
{
  public static void main(String[] args)
  {
    EagerInitialization instanceOne = EagerInitialization.getInstance();
    EagerInitialization instanceTwo = null;
    try
    {
      Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
      for (Constructor constructor : constructors)
      {
        //Below code will destroy the singleton pattern
        constructor.setAccessible(true);
        instanceTwo = (EagerInitialization) constructor.newInstance();
        break;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    System.out.println(instanceOne.hashCode());
    System.out.println(instanceTwo.hashCode());
  }
}
