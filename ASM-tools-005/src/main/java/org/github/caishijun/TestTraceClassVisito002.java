package org.github.caishijun;

import org.objectweb.asm.util.TraceClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import java.io.PrintWriter;

/**
 * TraceClassVisitor能够将java字节码以文本的方式展现出来。
 */
public class TestTraceClassVisito002 {

    public static void main(String args[]) {

        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        cv.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "org/github/caishijun/Comparable", null, "java/lang/Object",
                new String[]{"org/github/caishijun/Mesurable"});
        cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
        cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        cv.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
        cv.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cv.visitEnd();

    }
}

/*
控制台会打印出所创建的类：

// class version 49.0 (49)
// access flags 0x601
public abstract interface test/asm/examples/Comparable implements test/asm/examples/Mesurable  {

    // access flags 0x19
    public final static I LESS = -1

    // access flags 0x19
    public final static I EQUAL = 0

    // access flags 0x19
    public final static I GREATER = 1

    // access flags 0x401
    public abstract compareTo(Ljava/lang/Object;)I
}
*/
