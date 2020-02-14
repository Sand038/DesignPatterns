package creationalpatterns.abstractfactory.factory;

public class ComputerFactory
{
  public static Computer getComputer(ComputerAbstractFactory factory)
  {
    return factory.createComputer();
  }
}
