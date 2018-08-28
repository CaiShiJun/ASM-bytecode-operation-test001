package org.github.caishijun;

/*
在 asm-all-5.1.jar 包所在路径的终端输入命令： java -classpath asm-all-5.1.jar org.objectweb.asm.util.ASMifier java.lang.Runnable
*/

public class TestASMifier004 {
}

/*
输出：

        package asm.java.lang;
        import java.util.*;
        import org.objectweb.asm.*;
public class RunnableDump implements Opcodes {

    public static byte[] dump () throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "java/lang/Runnable", null, "java/lang/Object", null);

        {
            av0 = cw.visitAnnotation("Ljava/lang/FunctionalInterface;", true);
            av0.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "run", "()V", null, null);
            mv.visitEnd();
        }
        cw.visitEnd();
        return cw.toByteArray();
    }
}
*/
