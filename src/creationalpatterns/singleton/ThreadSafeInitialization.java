package creationalpatterns.singleton;

/*
    The easier way to create a thread-safe singleton class is to make the global
    access method synchronized, so that only one thread can execute this
    method at a time. General implementation of this approach is like the below
    class.
*/
public class ThreadSafeInitialization
{
  private static ThreadSafeInitialization instance;
  
  private ThreadSafeInitialization()
  {
  }
  
  public static synchronized ThreadSafeInitialization getInstance()
  {
    if (instance == null)
    {
      instance = new ThreadSafeInitialization();
    }
    return instance;
  }
  
  /*
      Above implementation works fine and provides thread-safety but it reduces
      the performance because of cost associated with the synchronized method,
      although we need it only for the first few threads who might create the
      separate instances (Read: Java Synchronization). To avoid this extra
      overhead every time, double checked locking principle is used. In this
      approach, the synchronized block is used inside if condition with an
      additional check to ensure that only one instance of singleton class is
      created.
  */
  public static ThreadSafeInitialization getInstanceUsingDoubleLocking()
  {
    if (instance == null)
    {
      synchronized (ThreadSafeInitialization.class)
      {
        if (instance == null)
        {
          instance = new ThreadSafeInitialization();
        }
      }
    }
    return instance;
  }
  
}
