package ExceptionCodeWrite.UserSystem;

import java.util.Objects;

public class UserManager {
    private static User[] arr ; //存储已经注册的用户
    private static int total; //存储实际注册的用户数量

    public UserManager() {
        arr = new User[5];
    }

    public void checkUsernameExists(String username) throws UsernameAlreadyExistsException {
        if (total == 0) return;
        for (int i = 0; i < total; i++) {
            if (username.equals(arr[i].getName())) {
                throw new UsernameAlreadyExistsException("用户名已存在");
            }
        }
    }
    public void add(User user) {
        if (total >= arr.length) {
            System.out.println("用户已满");
        } else {
            arr[total++] = user;
        }
    }

    public void login(User user) throws LoginFailException{
        for (int i = 0; i < total; i++) {
            if (arr[i].getName().equals(user.getName())) {
                if (arr[i].getPassword().equals(user.getPassword())) {
                    System.out.println("密码正确");
                    return;
                } else {
                    throw new LoginFailException("密码错误");
                }
            }
        }
        throw new LoginFailException("用户名错误");
    }
}
