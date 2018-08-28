package org.github.caishijun;

import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import java.io.PrintWriter;

/**
 * CheckClassAdapter是为了防止创建非法的类而生的。有校验的功能。如果类或者方法有错误会抛出IllegalStateException 或者 IllegalArgumentException异常。
 */
public class TestCheckClassAdapter003 {

    public static void main(String args[]) {

        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        CheckClassAdapter checkClassAdapter = new CheckClassAdapter(cv);
        checkClassAdapter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "org/github/caishijun/Comparable", null, "java/lang/Object",
                new String[]{"org/github/caishijun/Mesurable"});
        checkClassAdapter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1)).visitEnd();
        checkClassAdapter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, new Integer(0)).visitEnd();
        checkClassAdapter.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, new Integer(1)).visitEnd();
        checkClassAdapter.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        checkClassAdapter.visitEnd();

    }
}
