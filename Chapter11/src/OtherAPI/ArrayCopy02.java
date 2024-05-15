package OtherAPI;

import java.util.Arrays;

public class ArrayCopy02 {
    public static int indexOf(int[] arr,int moveCount, int value) {
        if (moveCount < 0) {
            System.out.println("输出参数错误");
            return -1;
        }
        while(moveCount>arr.length) {
            moveCount = moveCount - arr.length;
        }
        while (moveCount > 0) {
            int temp = arr[arr.length - 1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0] = temp;
            moveCount--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int moveCount = 3;
        int value = 4;
        System.out.println(indexOf(arr, moveCount, value));
    }
}
