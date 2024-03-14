package ru.project;

import java.util.HashMap;
import java.util.Map;

public class ObjectComposer {
    private Map<String, Object> objects = new HashMap<>();
    public ObjectComposer(String packageName) {
        this.objects = objects;
    }
    public Object getObjectByName(String name) {
        return objects.get(name);
    }
    public <T> T getObjectByNameAndType(String name, Class<T> clz) {
        return (T)objects.get(name);
    }
}
