package creationalpatterns.singleton;

/*
    Static block initialization implementation is similar to eager initialization,
    except that instance of class is created in the static block that provides option
    for exception handling.
        
    Both eager initialization and static block initialization creates the instance
    even before it’s being used and that is not the best practice to use. So in
    further sections, we will learn how to create Singleton class that supports
    lazy initialization.
*/
public class StaticBlockInitialization
{
  private static StaticBlockInitialization instance;
  
  private StaticBlockInitialization()
  {
  }
  
  //static block initialization for exception handling
  static
  {
    try
    {
      instance = new StaticBlockInitialization();
    }
    catch (Exception e)
    {
      throw new RuntimeException("Exception occurred in creating singleton instance");
    }
  }
  
  public static StaticBlockInitialization getInstance()
  {
    return instance;
  }
}
