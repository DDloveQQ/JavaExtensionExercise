package ComprehensiveExercises;

import java.io.Serial;
import java.io.Serializable;

public class AtguiguDemo implements Serializable, Comparable<AtguiguDemo> {
    @Serial
    private static final long serialVersionUID = 1L;
    private static String school = "尚硅谷";
    private String className;

    public AtguiguDemo(String className) {
        super();
        this.className = className;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        AtguiguDemo.school = school;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "AntiguaDemo{" +
                "className='" + className + '\'' +
                '}';
    }

    @Override
    public int compareTo(AtguiguDemo o) {
        return this.className.compareTo(o.getClassName());
    }
}
