public class cellRunner{
  // main method parses parameters, then creates an array that represents the
  // environment and does the cell evolution on it
  public static void main(String[] args){
    int[] params = parseParams(args);
    if (params == null){
      System.out.println("not enough arguments");
      System.exit(0);
    }
    new cell(params).run();
  }
  //method that parses the inputs and determines whether they are valid
  //@param args   a string array of arguments entered from the terminal
  //@return       an array of arguments as integers
  private static int[] parseParams(String[] args){
    int[] params = new int[args.length];
    if (args.length == 6){ //checks for number of arguments entered
      for (int i = 0; i<6; i++){
        try{
          params[i] = Integer.parseInt(args[i]);
        }catch(NumberFormatException e){ //catch for strings of letters
          System.out.println("error, you didn't enter integers"+
              " or you overflowed the int datatype");
          System.exit(1);
        }
        if (0 > Integer.parseInt(args[i])){
          System.out.println("negative number entered");
          System.exit(1);
        }
      }
      return params;
    }
    System.out.println("you didn't enter 6 integer arguments");
    System.exit(1);
    return null;
  }

}
