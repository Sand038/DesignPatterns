package creationalpatterns.singleton;

import java.io.Serializable;

/*
    Sometimes in distributed systems, we need to implement Serializable
    interface in Singleton class so that we can store its state in file system and
    retrieve it at later point of time. Here is a small singleton class that
    implements Serializable interface also.
*/
public class SerializedSingletonInitialization implements Serializable
{
  private static final long serialVersionUID = 1219922400036754207L;
  
  private SerializedSingletonInitialization()
  {
  }
  
  protected Object readResolve()
  {
    return getInstance();
  }
  
  private static class SingletonHelper
  {
    private static final SerializedSingletonInitialization instance = new SerializedSingletonInitialization();
  }
  
  public static SerializedSingletonInitialization getInstance()
  {
    return SingletonHelper.instance;
  }
}
