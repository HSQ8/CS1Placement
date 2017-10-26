import java.lang.Math;
public class cell{
  public static void main(String[] args){
    // main method parses parameters, then creates an array that represents the
    // environment and does the cell evolution on it
    int[] params = parseParams(args);
    if (params == null){
      System.out.println("not enough arguments");
      System.exit(1);
    }
    int[] ecosystem = populateArray(params[0]);
    for (int i = 0; i< params[1]; i++){
      printArray(ecosystem);
      ecosystem = performGeneration(ecosystem, params);
    }
  }
  //argument reading and validation
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
        try{
          if (0 > Integer.parseInt(args[i]))
            throw new IllegalArgumentException();
        }catch(IllegalArgumentException e){ //catch for negative numbers
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
  // printArray prints the array of each generation
  private static void printArray(int[] _arr){
    for (int i = 0; i < _arr.length; i++)
      System.out.print(_arr[i]);
    System.out.println();
  }
  //populate array populates an empty array with random 0 and 1s
  private static int[] populateArray(int cellCount){
    int[] _arr = new int[cellCount];
    for(int i = 0; i< cellCount; i++)
      _arr[i] = (int) (Math.random()*2);
    return _arr;
  }
  //performGeneration computes new generation based on rule passed in @params
  private static int[] performGeneration(int[] _arr, int[] _rule){
    int[] _output = new int[_arr.length];
    for (int i = 0; i < _arr.length; i++){
      if (i == 0)
        _output[i] = _rule[2 + _arr[i] + _arr[i+1]];
      else if (i == _arr.length-1)
        _output[i] = _rule[2 + _arr[i] + _arr[i-1]];
      else
        _output[i] = _rule[2 + _arr[i] + _arr[i-1] + _arr[i+1]];
    }
    return _output;
  }
}
