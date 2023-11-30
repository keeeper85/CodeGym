package com.codegym.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Mastering ClassLoader and Reflection

The Solution class constructor's parameter is the absolute path to a package.
The package name may include the File.separator.
In addition to compiled classes (.class), the package may have other files (for example: .java).
We know that every class has a no-argument constructor and implements the HiddenClass interface.
Read all the classes from the file system. Create a factory.
Implement the getHiddenClassObjectByKey method.
Note: The package can only have one class whose simple name starts with the String key (not case sensitive).

*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/codegym/task/task36/task3606/data/second");
        solution.scanFileSystem();

        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(packageName).listFiles();
        ClassLoaderFromPath classLoader = new ClassLoaderFromPath();

        for (File f : files) {
            Class<?> clazz = classLoader.load(f.toPath());
            if (clazz != null)
                hiddenClasses.add(clazz);
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {

        for (Class<?> clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    public static class ClassLoaderFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                if (path.getFileName().toString().lastIndexOf(".class") == -1)
                    return null;

                byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
