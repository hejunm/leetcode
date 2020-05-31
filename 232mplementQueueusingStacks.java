class MyQueue {
    
    Stack<Integer> s1 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
       Stack<Integer> s2 = new Stack<Integer>();
        while(!s1.empty()){
          s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.empty()){
          s1.push(s2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
      s1.pop();
    }

    // Get the front element.
    public int peek() {
      return s1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
      return s1.empty();
    }
  }

