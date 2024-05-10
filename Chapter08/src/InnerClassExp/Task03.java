package InnerClassExp;

import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Selector select = list.select();
        while (select.hasNext()) {
            System.out.print(select.next() + " ");
        }
        System.out.println();

        list.remove(1);
        list.set(1, 5);
        System.out.println(list.get(1));

        Selector select2 = list.select();
        while (select2.hasNext()) {
            System.out.print(select2.next() + " ");
        }
    }
}

interface Selector {
    boolean hasNext();
    Object next();
}

interface Touchable {
    Selector select();
}

class MyArrayList implements Touchable{
    private Object[] all = new Object[2];
    private int total;

    private class MySelector implements Selector {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != total;
        }

        @Override
        public Object next() {
            return all[cursor++];
        }
    }

    public void add(Object element) {
        if (total >= all.length) {
            all = Arrays.copyOf(all, all.length * 2);
        }
        all[total++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= total) {
            System.out.println("没有这个元素");
            return;
        }
        System.arraycopy(all, index + 1, all, index, total - index - 1);
        all[--total] = null;
    }

    public void set(int index, Object value) {
        if (index < 0 || index >= total) {
            System.out.println("没有这个元素");
            return;
        }
        all[index] = value;
    }

    public Object get(int index) {
        if(index < 0 || index >= total){
            System.out.println("没有这个元素");
            return null;
        }
        return all[index];
    }

    @Override
    public Selector select() {
        return new MySelector();
    }
}