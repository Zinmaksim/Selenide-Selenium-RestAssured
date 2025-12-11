package reflectionAPI;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ReflectionTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        MyClass myClass = new MyClass();
        Field userName = myClass.getClass().getDeclaredField("name");
        System.out.println("allFields: " + Arrays.toString(myClass.getClass().getDeclaredFields()));

        // выдать разрешение на работу с private полем
        userName.setAccessible(true);

        String name = (String) userName.get(myClass);
        // установить нов значение поля
        userName.set(myClass, "new value");
        String nameNew = (String) userName.get(myClass);

        System.out.println("nameNew: " + nameNew);
    }

    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        MyClass myClass = null;
        Class<?> clazz = Class.forName(MyClass.class.getName());
        //System.out.println("newInstance: " + clazz.newInstance().);


    }
}









