package maxqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 此处在原生java栈的基础上增加了一个求取当前栈中的最大值方法
 *
 * @author tantexian
 * @since 2018/11/16
 */
public class MyStack {
    /**
     * 此处直接使用原生java栈
     */
    Stack<Integer> stack = new Stack();

    /**
     * 使用一个数组列表记录当前stack在当前元素下的最大值记录列表
     * 其中stackMaxValList.get(3)中index为3的元素表示stack的size==3，此时stack所有元素中的最大值是多少
     */
    List<Integer> stackMaxValList = new ArrayList();

    /**
     * 当前的最大值，默认初始化为整数最小值
     */
    int maxVal = Integer.MIN_VALUE;

    MyStack() {
        // 初始化第0个元素表示stack中没有元素即size=0时候，此时最大值为整数最大负数
        stackMaxValList.add(Integer.MIN_VALUE);
    }

    public void push(int i) {
        // 如果当前值大于stack中的最大值
        if (i > max()) {
            // 则当前栈中最大值索引为当前值所在索引
            stackMaxValList.add(i);
            maxVal = i;
        } else {
            // 否则保存之前的最大值
            stackMaxValList.add(maxVal);
        }

        stack.push(i);
    }

    public int pop() {
        Integer retVal = stack.pop();
        // 如果当前出栈的元素为当前最大值索引，则需要更新最大值为stack剩余数中的最大值
        if (retVal == maxVal) {
            maxVal = stackMaxValList.indexOf(stack.size());
        }
        return retVal;
    }

    public boolean empty() {
        return stack.empty();
    }

    public int max() {
        return stackMaxValList.get(stack.size());

    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int x : stack) {
            stringBuffer.append(x);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
