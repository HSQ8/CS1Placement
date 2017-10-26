import java.lang.Math;
public class cell{
  private int[] params;
  // constructor
  //@param _params an array of parameters
  public cell(int[] _params){
    params = _params;
  }
  //starts the process of cell "evolution"
  //@param
  //@return void
  public void run(){
    int[] ecosystem = populateArray(params[0]);
    for (int i = 0; i< params[1]; i++){
      printArray(ecosystem);
      ecosystem = performGeneration(ecosystem, params);
    }
  }

  // printArray prints the array of each generation
  //@param _arr the array to be printed
  //@return void
  private void printArray(int[] _arr){
    for (int i:_arr)
      System.out.print(i);
    System.out.println();
  }
  //populate array populates an empty array with random 0 and 1s
  //@param cellCount number of cells that are supposed to be there
  //@return          an array that has random 1 and 0 as the cells
  private int[] populateArray(int cellCount){
    int[] _arr = new int[cellCount];
    for(int i = 0; i< cellCount; i++)
      _arr[i] = (int) (Math.random()*2);
    return _arr;
  }
  //performGeneration computes new generation based on rule passed in @params
  //@param _arr   the array that holds the cells
  //@param _rule  the array that holds the rules that the cells divid by
  //@return       the next generation array according to the update rules
  private int[] performGeneration(int[] _arr, int[] _rule){
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
