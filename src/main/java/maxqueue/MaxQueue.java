package maxqueue;

/**
 * 用常规的两个栈来实现一个队列
 *
 * @author tantexian
 * @since 2018/11/16
 */
public class MaxQueue {
    MyStack stack1 = new MyStack();
    MyStack stack2 = new MyStack();

    public void EnQueue(int i) {
        stack2.push(i);
    }

    public int DeQueue() {
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

    public int maxElement() {
        if (stack1.max() > stack2.max()) {
            return stack1.max();
        }
        return stack2.max();
    }

    public static void main(String[] args) {
        // testStackMax();
        // testMaxQueue();
        testEnDEQueue();
    }

    private static void testStackMax() {
        // 测试stack max
        MyStack myStack = new MyStack();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(3);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(4);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(9);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(8);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(2);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.push(1);
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.pop();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.pop();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.pop();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.pop();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());

        myStack.pop();
        System.out.println("stack == " + myStack.toString());
        System.out.println(myStack.max());
    }

    private static void testMaxQueue() {
        // 测试queue
        MaxQueue queue = new MaxQueue();

        queue.EnQueue(4);

        System.out.println(queue.maxElement());

        queue.EnQueue(1);

        System.out.println(queue.maxElement());

        queue.EnQueue(5);

        System.out.println(queue.maxElement());

        queue.EnQueue(3);

        System.out.println(queue.maxElement());

        System.out.println(queue.DeQueue());

        System.out.println(queue.maxElement());

        System.out.println(queue.DeQueue());

        System.out.println(queue.maxElement());

        System.out.println(queue.DeQueue());

        System.out.println(queue.maxElement());
    }

    private static void testEnDEQueue() {
        // 测试queue
        MaxQueue queue = new MaxQueue();

        queue.EnQueue(8);
        queue.EnQueue(7);
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        queue.EnQueue(4);
        queue.EnQueue(1);
        queue.EnQueue(5);
        queue.EnQueue(2);
        queue.EnQueue(0);
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        queue.EnQueue(1);
        queue.EnQueue(3);
        queue.EnQueue(1);
        queue.EnQueue(4);
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
        System.out.println(queue.DeQueue());
    }
}
