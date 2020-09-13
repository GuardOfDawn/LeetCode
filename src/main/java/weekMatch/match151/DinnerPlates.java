package weekMatch.match151;

import java.util.*;

class DinnerPlates {

    private List<Integer[]> stackList = new ArrayList<>();
    private List<Integer> countList = new ArrayList<>();
    private int capacity = 0;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        boolean pushed = false;
        for (int i=0;i<stackList.size();i++) {
            int curCount = countList.get(i);
            if (curCount<capacity) {
                stackList.get(i)[curCount] = val;
                curCount++;
                pushed = true;
                countList.set(i, curCount);
                break;
            }
        }
        if (!pushed) {
            Integer[] newStack = new Integer[capacity];
            newStack[0] = val;
            stackList.add(newStack);
            countList.add(1);
        }
    }

    public int pop() {
        int res = -1;
        for (int i=stackList.size()-1;i>=0;i--) {
            int curCount = countList.get(i);
            if (curCount>0) {
                curCount--;
                res = stackList.get(i)[curCount];
                countList.set(i, curCount);
                break;
            }
        }
        for (int i=stackList.size()-1;i>=0;i--) {
            int curCount = countList.get(i);
            if (curCount==0) {
                stackList.remove(i);
                countList.remove(i);
            } else {
                break;
            }
        }
        return res;
    }

    public int popAtStack(int index) {
        int res = -1;
        if (index<stackList.size()) {
            int curCount = countList.get(index);
            if (curCount>0) {
                curCount--;
                res = stackList.get(index)[curCount];
                countList.set(index, curCount);
            }
            for (int i=stackList.size()-1;i>=0;i--) {
                curCount = countList.get(i);
                if (curCount==0) {
                    stackList.remove(i);
                    countList.remove(i);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
