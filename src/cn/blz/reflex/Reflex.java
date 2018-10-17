package cn.blz.reflex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * java反射
 */
public class Reflex {
    private Map<String, Object> map = new HashMap<>();

    private Object createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> blz_class = Class.forName(className);
        return blz_class.newInstance();
    }

    public void initPool(String fileName) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(in);

        for (String className : properties.stringPropertyNames()){
            Object object = this.createObject(properties.getProperty(className));
            this.map.put(className, object);
        }
    }

    public Object getObject (String name){
        return this.map.get(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Reflex reflex = new Reflex();
        reflex.initPool("./classes.properties");
        System.out.println(reflex.getObject("name"));
    }

}
