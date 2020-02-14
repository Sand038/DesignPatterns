package creationalpatterns.prototype;

import java.util.List;

public class PrototypePatternTest
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    Employees employees = new Employees();
    employees.loadData();
    
    //Use the clone method to get the Employee object
    Employees firstEmployeesList = (Employees) employees.clone();
    Employees secondEmployeesList = (Employees) employees.clone();
    List<String> listOne = firstEmployeesList.getEmpList();
    listOne.add("John");
    List<String> listTwo = secondEmployeesList.getEmpList();
    listTwo.remove("Pankaj");
    
    System.out.println("emps List: " + employees.getEmpList());
    System.out.println("empsNew List: " + listOne);
    System.out.println("empsNew1 List: " + listTwo);
  }
}
