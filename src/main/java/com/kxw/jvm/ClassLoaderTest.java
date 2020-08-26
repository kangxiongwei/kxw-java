package com.kxw.jvm;

/**
 * @author kangxiongwei
 * @date 2020-06-15 16:20
 */
public class ClassLoaderTest {



    private static final class MyClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            ClassLoader parent = this.getParent();
            return super.loadClass(name);
        }
    }


}
