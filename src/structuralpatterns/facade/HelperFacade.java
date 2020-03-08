package structuralpatterns.facade;

import java.sql.Connection;

/*
Facade pattern hides the complexities of the system and provides an interface to the client using which the client can
access the system. This type of design pattern comes under structural pattern as this pattern adds an interface to
existing system to hide its complexities.

This pattern involves a single class which provides simplified methods required by client and delegates calls to
methods of existing system classes.
 */
public class HelperFacade
{
  public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName)
  {
    Connection con = null;
    switch (dbType)
    {
      case MYSQL:
        con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        switch (reportType)
        {
          case HTML:
            mySqlHelper.generateMySqlHTMLReport(tableName, con);
            break;
          case PDF:
            mySqlHelper.generateMySqlPDFReport(tableName, con);
            break;
        }
        break;
      case ORACLE:
        con = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        switch (reportType)
        {
          case HTML:
            oracleHelper.generateOracleHTMLReport(tableName, con);
            break;
          case PDF:
            oracleHelper.generateOraclePDFReport(tableName, con);
            break;
        }
        break;
    }
    
  }
  
  public static enum DBTypes
  {
    MYSQL, ORACLE;
  }
  
  public static enum ReportTypes
  {
    HTML, PDF;
  }
}
