package com.codegym.task.task35.task3507;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

/* 
What is ClassLoader?

Implement the getAllAnimals method.
The method's pathToAnimals parameter is the absolute path to the directory where the compiled classes are saved.
The path doesn't necessarily have a "/" at the end.
Not all classes inherit the Animal interface.
Not all classes have a public no-argument constructor.
Only for classes that both inherit Animal and have a public no-argument constructor, create one object each.
Add the created objects to the resulting set and return it.
The main method is not tested.

*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set = new HashSet<>();
        File[] files = new File(pathToAnimals).listFiles();
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    File file = new File(name);
                    byte[] byteArray = Files.readAllBytes(new File(name).toPath());
                    String s = Solution.class.getPackage().getName() + ".data." +
                            file.getName().substring(0, file.getName().length() -".class".length());
                    return defineClass(s, byteArray, 0, byteArray.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return super.findClass(name);
            }
        };
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                Class clazz = null;
                try {
                    clazz = classLoader.loadClass(file.getPath());
                    Constructor ct = clazz.getConstructor();
                    if (Modifier.isPublic(ct.getModifiers()) && Animal.class.isAssignableFrom(clazz)) {
                        Animal animal = (Animal) clazz.newInstance();
                        set.add(animal);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | ClassNotFoundException ignored) {
                }
            }
        }
        return set;
    }
}
