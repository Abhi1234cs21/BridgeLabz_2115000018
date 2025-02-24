import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class DependencyInjector {
    private final Map<Class<?>, Object> instances = new HashMap<>();
    
    public void register(Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);
    }
    
    public void injectDependencies(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = instances.get(field.getType());
                if (dependency != null) {
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
        }
    }
}

class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;
    
    public void execute() {
        service.serve();
    }
}

public class DIContainerExample {
    public static void main(String[] args) throws Exception {
        DependencyInjector di = new DependencyInjector();
        di.register(Service.class);
        
        Client client = new Client();
        di.injectDependencies(client);
        client.execute();
    }
}
