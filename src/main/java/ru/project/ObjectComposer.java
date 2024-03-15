package ru.project;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ObjectComposer {
    private Map<String, Object> objects = new HashMap<>();

    public ObjectComposer(String packageName) {
        try {
            System.out.println("*******************************************************");
            System.out.println("packageName = " + packageName);
            String filePackageName = '/' + packageName.replace('.', '/');
            System.out.println("filePackageName = " + filePackageName);

            File f = new File("." + filePackageName);
            System.out.println("f = " + f);

            var ff = f.listFiles();
            System.out.println("Кол-во файлов в каталоге: " + ff.length);

            int cnt = 0;
            for (File file : f.listFiles()) {
                cnt++;

                System.out.println(cnt + " --------------------------------");
                System.out.println("Filename = " + file.getName()); // имя исходного файла

                if (!file.getName().endsWith("class")) continue;

                String clzName = file.getName().split("\\.")[0];
                System.out.println("clzName = " + clzName); // получили имя класса

                Class clz = Class.forName("ru.project" + "." + clzName);
                System.out.println("clz = " + clz);

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