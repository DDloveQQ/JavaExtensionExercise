package ExceptionCodeWrite.UserSystem;

import java.util.Scanner;

public class MainTest {
    private static Scanner input = new Scanner(System.in);
    private static UserManager um = new UserManager();

    public static void main(String[] args) {
        boolean flag  = true;
        while(flag){
            System.out.println("--------尚硅谷----------");
            System.out.println("\t\t1、注册");
            System.out.println("\t\t2、登录");
            System.out.println("\t\t3、退出");
            System.out.print("\t请选择：");
            int select = input.nextInt();
            switch (select){
                case 1:
                    regist();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    flag = false;
            }
        }

        input.close();
    }

    private static void login() {
        System.out.print("用户名：");
        String username = input.next();

        System.out.print("密码：");
        String password = input.next();

        User user = new User(username,password);
        try {
            um.login(user);
            System.out.println("登录成功");
        } catch (LoginFailException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void regist(){
        String username;
        while(true) {
            System.out.print("用户名：");
            username = input.next();
            try {
                um.checkUsernameExists(username);
                break;
            } catch (UsernameAlreadyExistsException e) {
                System.err.println(e.getMessage());
                input.nextLine();
            }
        }

        System.out.print("密码：");
        String password = input.next();

        User user = new User(username, password);
        um.add(user);
        System.out.println("注册成功");
    }

}
