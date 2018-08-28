package org.github.caishijun;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 删除方法、修改权限修饰符
 */
public class Generator {

    public static void main(String args[]) {

        try {
            //读取类文件
            ClassReader classReader = new ClassReader("org/github/caishijun/Account");
            ClassWriter classWriter = new ClassWriter(0);
            ClassVisitor classVisitor = new MyClassAdapter(classWriter, "main", "([Ljava/lang/String;)V");      //使用自定义的 MyClassAdapter 类，删除 main 方法。
            classReader.accept(classVisitor, 0);

            //将修改后的类文件写出成 .class 文件
            byte[] data = classWriter.toByteArray();
            File file = new File("Account.class");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class MyClassAdapter extends ClassVisitor {

        private String mDesc;
        private String methodName;

        public MyClassAdapter(ClassVisitor cv, String methodName, String mDesc) {
            super(Opcodes.ASM4, cv);
            this.mDesc = mDesc;
            this.methodName = methodName;
        }

        @Override
        public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
            // 删除方法
            if (s.equals(methodName) && s1.equals(mDesc)) {
                return null;
            }
            // 修改方法的权限修饰符
            return cv.visitMethod(Opcodes.ACC_PRIVATE, s, s1, s2, strings);
        }
    }

}