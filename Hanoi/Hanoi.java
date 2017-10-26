public class Hanoi {
  //member variables 3 peg stacks to contain the problem
  private MyStack<Integer> peg_A;
  private MyStack<Integer> peg_B;
  private MyStack<Integer> peg_C;
  //constructor to make three pegs
  public Hanoi (int _numDisk){
    peg_A = new MyStack<Integer>();
    peg_B = new MyStack<Integer>();
    peg_C = new MyStack<Integer>();
    for (int i = 0; i < _numDisk; i++){
      peg_A.push(new Integer(_numDisk - i));
    }
  }
  //prints current state of problem
  // @param
  // @return void
  public void display(){
    System.out.println("A:  " + peg_A.toString());
    System.out.println("B:  " + peg_B.toString());
    System.out.println("C:  " + peg_C.toString());
    System.out.println();
  }

  //allows outside program to initiate solve process
  // @param
  // @return void
  public void solve(){
    move(peg_A.size(),peg_A, peg_B, peg_C);
  }
  //recursively move one disk at a time
  // @param  _topDisks how many disks are there
  //         _originPeg the original Peg from which we get disks
  //         _targetPeg the target Peg at which we move disks towards
  //         _sparePeg  the spare peg with which we use to complete moves
  // @return void
  private void move(int _topDisks,
      MyStack<Integer> _originPeg,
      MyStack<Integer> _targetPeg,
      MyStack<Integer> _sparePeg){
    //check base condition and move disk when needed
    if (_topDisks == 1){
      if (!_targetPeg.isEmpty()){
        if (_targetPeg.peek() > _originPeg.peek()){
          _targetPeg.push(_originPeg.pop());
        }
      }else if (_targetPeg.isEmpty()){
        _targetPeg.push(_originPeg.pop());
      }
      display();
    }
    //recursively move smaller pieces of the problem
    else {
      move(_topDisks - 1, _originPeg, _sparePeg, _targetPeg);
      move(1,             _originPeg, _targetPeg, _sparePeg);
      move(_topDisks - 1, _sparePeg, _targetPeg, _originPeg);
    }
  }
}
