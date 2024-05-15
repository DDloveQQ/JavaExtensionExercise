package StringExp.CodeWrite;

import java.sql.SQLOutput;

public class PasswordCheck {

    public static boolean Check(String password) {
        if (password.length() < 9) {
            System.out.println("密码长度不足9个字符");
            return false;
        }
        char[] c = password.toCharArray();
        int upperCount = 0;
        boolean isContainLowerChar = false;
        boolean isContainNumber = false;
        for (char value : c) {
            // 可以不用记住ASCii码，直接使用字符即可，程序会自动转成ASCii码
            if (value >= 'A' && value <= 'Z') upperCount++;
            if (value >= '0' && value <= '9') isContainNumber = true;
            if (value >= 'a' && value <= 'z' ) isContainLowerChar = true;
        }
        if (upperCount < 1) {
            System.out.println("密码需要包含至少一个大写字符");
            return false;
        }
        if (!isContainNumber) {
            System.out.println("密码需要包含数字");
            return false;
        }
        if (!isContainLowerChar) {
            System.out.println("密码需要包含小写字母");
            return false;
        }
        System.out.println("密码格式正确");
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Check("1207804129Zx"));
    }
}
