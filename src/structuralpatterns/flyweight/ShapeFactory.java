package structuralpatterns.flyweight;

import java.util.HashMap;

/*
  Flyweight design pattern is used when we need to create a lot of Objects of a class. Since every object consumes
  memory space that can be crucial for low memory devices, such as mobile devices or embedded systems, flyweight design
  pattern can be applied to reduce the load on memory by sharing objects.
  
  To apply flyweight pattern, we need to divide Object property into intrinsic and extrinsic properties. Intrinsic
  properties make the Object unique whereas extrinsic properties are set by client code and used to perform different
  operations. For example, an Object Circle can have extrinsic properties such as color and width
  
  extrinsic - state that belongs to the context of the object (external) or unique to that instance
  intrinsic - state that naturally belongs to the 'FlyWeight' object and thus should be permanent or immutable
  (internal) or context free.
 */
public class ShapeFactory
{
  private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();
  
  public static Shape getShape(ShapeType type)
  {
    Shape shapeImpl = shapes.get(type);
    if (shapeImpl == null)
    {
      if (type.equals(ShapeType.OVAL_FILL))
      {
        shapeImpl = new Oval(true);
      }
      else if (type.equals(ShapeType.OVAL_NOFILL))
      {
        shapeImpl = new Oval(false);
      }
      else if (type.equals(ShapeType.LINE))
      {
        shapeImpl = new Line();
      }
      shapes.put(type, shapeImpl);
    }
    return shapeImpl;
  }
  
  public static enum ShapeType
  {
    OVAL_FILL, OVAL_NOFILL, LINE;
  }
}
