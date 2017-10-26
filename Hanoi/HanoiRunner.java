public class HanoiRunner{
  public static void main(String[] args){
    Hanoi prob2 = new Hanoi(parseParams(args));
    prob2.display();
    prob2.solve();

  }
  // reads in the arguments from the terminal and checks for validity
  // @param  _args string array of parameters from terminal
  // @return       returns integer number of disks
  private static int parseParams(String[] _args){
    int params = -1;
    if (_args.length == 1){ //checks for number of arguments entered
      try{
        params = Integer.parseInt(_args[0]);
      }catch(NumberFormatException e){ //catch for strings of letters
        System.out.println("error, you didn't enter an Integer"+
            " or you overflowed the int datatype");
        System.exit(0);
      }

      if (!( 0 < Integer.parseInt(_args[0]))){
        System.out.println("must enter a number greater than 0");
        System.exit(0);
      }
      return params;
    }
    System.out.println("You didn't enter 1 argument for the number of disks");
    System.exit(0);
    return params;
  }

}
