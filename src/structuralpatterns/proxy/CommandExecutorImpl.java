package structuralpatterns.proxy;

public class CommandExecutorImpl implements CommandExecutor
{
  @Override
  public void runCommand(String command) throws Exception
  {
    Runtime.getRuntime().exec(command);
    System.out.println("'" + command + "' command executed");
  }
}
