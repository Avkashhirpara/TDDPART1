public class Stack{
    private java.util.Stack<Object> stack = new java.util.Stack();

    public void push(Object obj){
         stack.push(obj);
    }
    public Object pop() throws Exception{

        if(stack.empty()){
            throw  new Exception();
        }
        return stack.pop();
    }
}
