package org.github.caishijun;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


/**
package org.github.caishijun;

public class Tester
{
	public void run()
	{
		System.out.println("This is my first ASM test");
	}
}
*/
public class ASMGettingStarted {


    /**
     * 动态创建一个类，有一个无参数的构造函数
     */
    static ClassWriter createClassWriter(String className) {

        /*
        ClassWriter(int flags)
        构造一个新的ClassWriter对象。

        static int	COMPUTE_FRAMES
        自动从头计算方法堆栈映射帧的标志。

        static int	COMPUTE_MAXS
        自动计算方法的最大堆栈大小和最大局部变量数的标志。
        */
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        //声明一个类，使用JDK1.8版本，public的类，父类是java.lang.Object，没有实现任何接口
        /*
        public void visit(int version,
        int access,
        java.lang.String name,
        java.lang.String signature,
        java.lang.String superName,
        java.lang.String[] interfaces)
        访问类的标题。
        Parameters:
        version - 类版本。次要版本存储在16个最重要的位中，而主要版本存储在16个最不重要的位中。
        access - 类的访问标志(参见操作码)。这个参数还指示类是否不赞成使用。
        name - 类的内部名称(请参阅Type.getInternalName())。
        signature - 这个类的签名。如果类不是泛型类，并且没有扩展或实现泛型类或接口，则可能为null。
        superName - 超类的内部名称(请参阅Type.getInternalName())。对于接口，超类是Object。可能为空，但仅针对对象类。
        interfaces - 类接口的内部名称(请参阅Type.getInternalName())。可能是null。
        */
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);

        //初始化一个无参的构造函数
        /*
        public MethodVisitor visitMethod(int access,
        java.lang.String name,
        java.lang.String descriptor,
        java.lang.String signature,
        java.lang.String[] exceptions)
        访问类的一个方法。这个方法每次被调用时都必须返回一个新的MethodVisitor实例(或null)，即，它不应该返回以前返回的访问者。
        Parameters:
        access - 方法的访问标志(参见操作码)。此参数还指示该方法是合成的还是废弃的。
        name - 方法的名称。
        descriptor - 方法的描述符(请参阅类型)。
        signature - 方法的签名。如果方法参数、返回类型和异常不使用泛型类型，则可能为空。
        exceptions - 方法异常类的内部名称(请参阅Type.getInternalName())。可能是null。
        Returns:
        要访问该方法的字节码的对象，如果该类访问者对访问该方法的代码不感兴趣，则为null。
        */
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);

        //这里请看截图
        /*
        public void visitVarInsn(int opcode,
        int var)
        访问本地变量指令。局部变量指令是加载或存储局部变量值的指令。
        Parameters:
        opcode - 要访问的局部变量指令的操作码。这个操作码可以是ILOAD、LLOAD、FLOAD、DLOAD、ALOAD、ISTORE、LSTORE、FSTORE、DSTORE、ASTORE或RET。
        var - 要访问的指令的操作数。这个操作数是一个局部变量的索引。
        */
        constructor.visitVarInsn(Opcodes.ALOAD, 0);

        //执行父类的init初始化
        /*
        public void visitMethodInsn(int opcode,
        java.lang.String owner,
        java.lang.String name,
        java.lang.String descriptor,
        boolean isInterface)
        访问方法指导。方法指令是调用方法的指令。
        Parameters:
        opcode - 要访问的类型指令的操作码。这个操作代码可以是INVOKEVIRTUAL、invokspecial、INVOKESTATIC或INVOKEINTERFACE。
        owner - 方法所有者类的内部名称(请参阅Type.getInternalName())。
        name - 方法的名称。
        descriptor - 方法的描述符(请参阅类型)。
        isInterface - 如果方法的所有者类是接口。
        */
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        //从当前方法返回void
        /*
        public void visitInsn(int opcode)
        访问零操作数指令。
        Parameters:
        操作码——要访问的指令的操作码。这个操作码是 NOP, ACONST_NULL, ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5, LCONST_0, LCONST_1, FCONST_0, FCONST_1, FCONST_2, DCONST_0, DCONST_1, IALOAD, LALOAD, FALOAD, DALOAD, AALOAD, BALOAD, CALOAD, SALOAD, IASTORE, LASTORE, FASTORE, DASTORE, AASTORE, BASTORE, CASTORE, SASTORE, POP, POP2, DUP, DUP_X1, DUP_X2, DUP2, DUP2_X1, DUP2_X2, SWAP, IADD, LADD, FADD, DADD, ISUB, LSUB, FSUB, DSUB, IMUL, LMUL, FMUL, DMUL, IDIV, LDIV, FDIV, DDIV, IREM, LREM, FREM, DREM, INEG, LNEG, FNEG, DNEG, ISHL, LSHL, ISHR, LSHR, IUSHR, LUSHR, IAND, LAND, IOR, LOR, IXOR, LXOR, I2L, I2F, I2D, L2I, L2F, L2D, F2I, F2L, F2D, D2I, D2L, D2F, I2B, I2C, I2S, LCMP, FCMPL, FCMPG, DCMPL, DCMPG, IRETURN, LRETURN, FRETURN, DRETURN, ARETURN, RETURN, ARRAYLENGTH, ATHROW, MONITORENTER, or MONITOREXIT.
        */
        constructor.visitInsn(Opcodes.RETURN);

        /*
        public void visitMaxs(int maxStack,
        int maxLocals)
        访问方法的最大堆栈大小和最大局部变量数。
        Parameters:
        maxStack - 方法的最大堆栈大小。
        maxLocals - 该方法的最大局部变量数。
        */
        constructor.visitMaxs(1, 1);

        /*
        public void visitEnd()
        访问方法的末尾。这个方法是最后一个被调用的方法，用于通知访问者该方法的所有注释和属性已经被访问。
        */
        constructor.visitEnd();

        return cw;
    }


    /**
     * 创建一个run方法，里面只有一个输出
     * public void run()
     * {
     * 		System.out.println(message);
     * }
     * @return
     * @throws Exception
     */
    static byte[] createVoidMethod(String className, String message) throws Exception {

        //注意，这里需要把classname里面的.改成/，如com.asm.Test改成com/asm/Test
        ClassWriter cw = createClassWriter(className.replace('.', '/'));

        //创建run方法
        //()V表示函数，无参数，无返回值
        /*
        public MethodVisitor visitMethod(int access,
        java.lang.String name,
        java.lang.String descriptor,
        java.lang.String signature,
        java.lang.String[] exceptions)
        访问类的一个方法。这个方法每次被调用时都必须返回一个新的MethodVisitor实例(或null)，即，它不应该返回以前返回的访问者。
        Parameters:
        access - 方法的访问标志(参见操作码)。此参数还指示该方法是合成的还是废弃的。
        name - 方法的名称。
        descriptor - 方法的描述符(请参阅类型)。
        signature - 方法的签名。如果方法参数、返回类型和异常不使用泛型类型，则可能为空。
        exceptions - 方法异常类的内部名称(请参阅Type.getInternalName())。可能是null。
        Returns:
        要访问该方法的字节码的对象，如果该类访问者对访问该方法的代码不感兴趣，则为null。
        */
        MethodVisitor runMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, "run", "()V", null, null);

        //先获取一个java.io.PrintStream对象
        /*
        public void visitFieldInsn(int opcode,
        java.lang.String owner,
        java.lang.String name,
        java.lang.String descriptor)
        访问现场指导。字段指令是加载或存储对象字段值的指令。
        Parameters:
        opcode - 要访问的类型指令的操作码。这个操作代码可以是 GETSTATIC, PUTSTATIC, GETFIELD 或者 PUTFIELD.
        owner - 字段所有者类的内部名称(参见Type.getInternalName())。
        name - 字段的名称。
        descriptor - 字段的描述符(请参阅类型)。
        */
        runMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

        //将int, float或String型常量值从常量池中推送至栈顶  (此处将message字符串从常量池中推送至栈顶[输出的内容])
        /*
        public void visitLdcInsn(java.lang.Object value)
        访问LDC指令。注意，在Java虚拟机的未来版本中可能会添加新的常量类型。为了轻松检测新的常量类型，该方法的实现应该检查意外的常量类型，如下所示:
        if (cst instanceof Integer) {
            // ...
        } else if (cst instanceof Float) {
            // ...
        } else if (cst instanceof Long) {
            // ...
        } else if (cst instanceof Double) {
            // ...
        } else if (cst instanceof String) {
            // ...
        } else if (cst instanceof Type) {
            int sort = ((Type) cst).getSort();
            if (sort == Type.OBJECT) {
                // ...
            } else if (sort == Type.ARRAY) {
                // ...
            } else if (sort == Type.METHOD) {
                // ...
            } else {
                // throw an exception
            }
        } else if (cst instanceof Handle) {
            // ...
        } else if (cst instanceof ConstantDynamic) {
            // ...
        } else {
            // throw an exception
        }
        Parameters:
        值——要加载到堆栈上的常量。该参数必须是一个非零的整数,浮点数,一个长,双,一个字符串,一种类型的对象或数组的. class常数,是49的类版本,一种类型的方法,MethodType MethodHandle常数处理,对类的版本是51或ConstantDynamic持续动态的类版本是55。
        */
        runMethod.visitLdcInsn(message);

        //执行println方法（执行的是参数为字符串，无返回值的println函数）
        /*
        public void visitMethodInsn(int opcode,
        java.lang.String owner,
        java.lang.String name,
        java.lang.String descriptor,
        boolean isInterface)
        访问方法指导。方法指令是调用方法的指令。
        Parameters:
        opcode - 要访问的类型指令的操作码。这个操作代码可以是INVOKEVIRTUAL、invokspecial、INVOKESTATIC或INVOKEINTERFACE。
        owner - 方法所有者类的内部名称(请参阅Type.getInternalName())。
        name - 方法的名称。
        descriptor - 方法的描述符(请参阅类型)。
        isInterface - 如果方法的所有者类是接口。
        */
        runMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        /*
        public void visitInsn(int opcode)
        访问零操作数指令。
        Parameters:
        操作码——要访问的指令的操作码。这个操作码是 NOP, ACONST_NULL, ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5, LCONST_0, LCONST_1, FCONST_0, FCONST_1, FCONST_2, DCONST_0, DCONST_1, IALOAD, LALOAD, FALOAD, DALOAD, AALOAD, BALOAD, CALOAD, SALOAD, IASTORE, LASTORE, FASTORE, DASTORE, AASTORE, BASTORE, CASTORE, SASTORE, POP, POP2, DUP, DUP_X1, DUP_X2, DUP2, DUP2_X1, DUP2_X2, SWAP, IADD, LADD, FADD, DADD, ISUB, LSUB, FSUB, DSUB, IMUL, LMUL, FMUL, DMUL, IDIV, LDIV, FDIV, DDIV, IREM, LREM, FREM, DREM, INEG, LNEG, FNEG, DNEG, ISHL, LSHL, ISHR, LSHR, IUSHR, LUSHR, IAND, LAND, IOR, LOR, IXOR, LXOR, I2L, I2F, I2D, L2I, L2F, L2D, F2I, F2L, F2D, D2I, D2L, D2F, I2B, I2C, I2S, LCMP, FCMPL, FCMPG, DCMPL, DCMPG, IRETURN, LRETURN, FRETURN, DRETURN, ARETURN, RETURN, ARRAYLENGTH, ATHROW, MONITORENTER, or MONITOREXIT.
        */
        runMethod.visitInsn(Opcodes.RETURN);

        /*
        public void visitMaxs(int maxStack,
        int maxLocals)
        访问方法的最大堆栈大小和最大局部变量数。
        Parameters:
        maxStack - 方法的最大堆栈大小。
        maxLocals - 该方法的最大局部变量数。
        */
        runMethod.visitMaxs(1, 1);

        /*
        public void visitEnd()
        访问方法的末尾。这个方法是最后一个被调用的方法，用于通知访问者该方法的所有注释和属性已经被访问。
        */
        runMethod.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        String className = "org.github.caishijun.Tester";
        byte[] classData = createVoidMethod(className, "This is my first ASM test");
        Class<?> clazz = new MyClassLoader().defineClassForName(className, classData);
        clazz.getMethods()[0].invoke(clazz.newInstance());
    }
}
