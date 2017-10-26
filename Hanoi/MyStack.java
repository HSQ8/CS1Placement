import java.util.ArrayList;
import java.util.EmptyStackException;
public class MyStack<T> extends ArrayList<T>{
  private ArrayList<T> stack; // implemented stack based on arrayList
  private int mSize;
  public MyStack(){
    stack = new ArrayList<T>();
    mSize = stack.size();
  }
  // isEmpty checks whether the stack is empty
  // @param
  // @return  whether the stack is empty or not
  public boolean isEmpty(){
    return (mSize == 0);
  }
  // examines the top element of the stack
  // @param
  // @return the top element of the stack
  public T peek(){
    if (isEmpty())
      throw new EmptyStackException();
    return stack.get(mSize-1);
  }
  //retrives the top element of the stack
  // @param
  // @return the top element of the stack
  public T pop(){
    if (isEmpty())
      throw new EmptyStackException();
    T temp = stack.get(mSize-1);
    stack.remove(mSize-1);
    --mSize;
    return temp;
  }
  //add element to the top of the stack
  // @param _obj object to be added to the top of the stack
  // @return void
  public void push(T _obj){
    stack.add(_obj);
    ++mSize;

  }
  //return index of object to search in stack, -1 if object not found
  // @param   _obj object to e searched for in the stack
  // @return       position of the result in the stack, if not found, -1
  public int search(T _obj){
    if (!isEmpty()){
      for (int i = 0; i < mSize; i++){
        if( stack.get(i).equals(_obj))
          return i;
      }
    }
    return -1;
  }
  //returns size of stack
  //@param
  //@return  size of the stack
  public int size(){
    return mSize;
  }
  @Override
  // toString turns the object to a string
  //@param
  //@return      a string that has all the objects in order
  public String toString(){
    String temp = "";
    for (T _t: stack)
      temp = (temp + _t.toString()+ " ");
    return temp;
  }
}
