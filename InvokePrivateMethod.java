import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            Class<?> clazz = calculator.getClass();
            
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            
            int result = (int) multiplyMethod.invoke(calculator, 5, 3);
            System.out.println("Multiplication Result: " + result);
            
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}