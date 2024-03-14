package ru.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ObjectComposer {
    private Map<String, Object> objects = new HashMap<>();
    public ObjectComposer(String packageName) {
        //this.objects = objects;

        try {
            String filePackageName = '/' + packageName.replace('.', '/');
            File f = new File("." + filePackageName);
            for(File file : f.listFiles()) {
                if (!file.getName().endsWith("class")) continue;
                String clzName = file.getName().split("\\.")[0];
                Class clz = Class.forName(packageName + "." + clzName);
                if (!clz.isAnnotationPresent(Component.class)) continue;
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
