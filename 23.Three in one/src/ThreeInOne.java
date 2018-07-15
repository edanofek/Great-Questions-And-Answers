import java.util.ArrayList;

public class Stack<T>{

    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top; //top of the stack

    public T pop() {
         if (top == null) throw new EmptystackException();
         T item = top.data;
         top = top.next;
         return top;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top== null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}

public class ThreeInOne {

    public ThreeInOne(){

    }
   
    public static void main(String[] args) {

        ThreeInOne _ThreeInOne = new ThreeInOne();
        //TODO:Con't here

    }
}
