package StaticExp;

import java.util.Scanner;

public class ArrayTools {
    // 二分查找
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;  //mid已经不满足条件，因此不包含mid
            } else if (arr[mid] < value) {
                left = mid + 1; //mid已经不满足条件，因此不包含mid
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] copyOf(int[] arr, int newLength) {
        int[] newArr = new int[newLength];
        if (newLength <= arr.length) {
            for (int i = 0; i < newLength; i++) {
                newArr[i] = arr[i];
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
        }
        return newArr;
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static String toString(int[] arr) {
        String out = "{";
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                out += arr[i];
            } else {
                out += "," + arr[i];
            }
        }
        return out + "}";
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
        System.out.println(ArrayTools.toString(arr));

        ArrayTools.sort(arr);
        System.out.println(ArrayTools.toString(arr));

        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个[0,100)范围的整数：");
        int num = input.nextInt();
        input.close();

        int index = ArrayTools.binarySearch(arr, num);
        if(index==-1){
            System.out.println(num +"在arr中不存在");
        }else{
            System.out.println(num +"在arr的下标是：" + index);
        }

        int[] fiveElements = ArrayTools.copyOf(arr, 5);
        System.out.println(ArrayTools.toString(fiveElements));

        int[] tenElements = ArrayTools.copyOf(arr, 10);
        System.out.println(ArrayTools.toString(tenElements));

        int[] fifteenElements = ArrayTools.copyOf(arr, 15);
        System.out.println(ArrayTools.toString(fifteenElements));
    }
}
