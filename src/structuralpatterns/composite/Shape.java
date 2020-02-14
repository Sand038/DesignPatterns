package structuralpatterns.composite;

/*
    1. Base Component – Base component is the interface for all objects in the composition, client program uses base 
    component to work with the objects in the composition. It can be an interface or an abstract class with some 
    methods common to all the objects.
    2. Leaf – Defines the behaviour for the elements in the composition. It is the building block for the composition 
    and implements base component. It doesn’t have references to other Components.
    3. Composite – It consists of leaf elements and implements the operations in base component.
    4. Composite pattern should be applied only when the group of objects should behave as the single object.
    5 Composite pattern can be used to create a tree like structure.
 */
public interface Shape
{
  public void draw(String fillColor);
}
