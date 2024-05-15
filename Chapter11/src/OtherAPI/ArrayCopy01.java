package OtherAPI;

import java.util.Arrays;

public class ArrayCopy01 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,4,5,6,7};
        arr = changPosition(2,6,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] changPosition(int n1, int n2, int[] ii) {
        int indexN1 = -1;
        int indexN2 = -1;
        for (int i = 0; i < ii.length; i++) {
            if (ii[i] == n1) {
                indexN1 = i;
            }
        }
        for (int i = 0; i < ii.length; i++) {
            if (ii[i] == n2) {
                indexN2 = i;
            }
        }
        // System.arraycopy:
        // src:源数组;
        // srcPos:源数组要复制的起始位置;
        // dest:目的数组;
        // destPos:目的数组放置的起始位置;
        // length:复制的长度.

        // 目的：将(N1,N2]内容复制，并覆盖住N1,此时N1被删除但N2有两个，且原先的N2索引不变
        System.arraycopy(ii, indexN1+1, ii, indexN1, indexN2 - indexN1);
        // 随后将多余的N2变为N1
        ii[indexN2] = n1;


        // 假设字符串为：1，3，4，8，9，10，5, 我想将3移到9后面
        // 步骤1：复制(3,9]的内容：    1，3，【4，8，9】，10，5
        // 步骤2：用复制的内容覆盖3：   1，【4，8，9】，9，10，5
        // 步骤3：用3替换多余的9：     1，4，8，9，【3】，10，5
        // 获得结果：1，4，8，9，3，10，5

        return ii;
    }
}
