package structuralpatterns.proxy;

public interface CommandExecutor
{
  public void runCommand(String command) throws Exception;
}
