package ru.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ObjectComposer {
    private Map<String, Object> objects = new HashMap<>();

    public ObjectComposer(String packageName) {
        try {
            System.out.println("packageName = " + packageName);
            String filePackageName = '/' + packageName.replace('.', '/');
            File f = new File("." + filePackageName);
            System.out.println("f = " + f);
            for (File file : f.listFiles()) {
                //System.out.println("Filename = " + file.getName());
                System.out.println("Filename = ");
                if (!file.getName().endsWith("class")) continue;
                String clzName = file.getName().split("\\.")[0];
                Class clz = Class.forName(packageName + "." + clzName);
                if (!clz.isAnnotationPresent(Component.class)) continue;
                Component component = (Component) clz.getAnnotation(Component.class);
                if (!component.value().equals("")) clzName = component.value();
                objects.put(clzName, clz.newInstance());
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public Object getObjectByName(String name) {
        return objects.get(name);
    }

    public <T> T getObjectByNameAndType(String name, Class<T> clz) {
        return (T)objects.get(name);
    }
}