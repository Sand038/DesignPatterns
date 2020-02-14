package structuralpatterns.adapter;

/*
    1. Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.
    2. Object Adapter – This form uses Java Composition and adapter contains the source object.
 */
public interface SocketAdapter
{
  public Volt get120Volt();
  
  public Volt get12Volt();
  
  public Volt get3Volt();
}
