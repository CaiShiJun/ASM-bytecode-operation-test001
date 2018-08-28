package org.github.caishijun;

import org.objectweb.asm.*;

public class ClassPrinter extends ClassVisitor {

    /*
    public ClassVisitor(int api)
    构造一个新的ClassVisitor。
    Parameters:
    这个访问者实现的ASM api版本。必须是操作码之一。ASM4, Opcodes.ASM5, Opcodes.ASM6 or Opcodes.ASM7_EXPERIMENTAL.
    */
    public ClassPrinter() {
        super(Opcodes.ASM4);
    }

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
    public void visit(int version, int access, String name,
                      String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    /*
    public void visitSource(java.lang.String source,
                            java.lang.String debug)
    访问类源。
    Parameters:
    source - 编译该类的源文件的名称。可能是null。
    debug - 用于计算类的源元素和已编译元素之间的对应关系的其他调试信息。可能是null。
    */
    public void visitSource(String source, String debug) {
    }

    /*
    public void visitOuterClass(java.lang.String owner,
                                java.lang.String name,
                                java.lang.String descriptor)
    访问类的封闭类。只有当类有一个封闭的类时，才必须调用此方法。
    Parameters:
    owner - 类的封闭类的内部名称。
    name - 包含类的方法的名称，如果类没有包含在其封闭类的方法中，则为null。
    descriptor - 包含类的方法的描述符，如果类没有包含在类的方法中，则为null。
    */
    public void visitOuterClass(String owner, String name, String desc) {
    }

    /*
    public AnnotationVisitor visitAnnotation(java.lang.String descriptor,
                                             boolean visible)
    访问类的注释。
    Parameters:
    descriptor - 注释类的类描述符。
    visible - 如果注释在运行时可见，则为真。
    Returns:
    访问注释值的访问者，如果该访问者对访问该注释不感兴趣，则为null。
    */
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    /*
    public void visitAttribute(Attribute attribute)
    访问类的非标准属性。
    Parameters:
    attribute - 属性。
    */
    public void visitAttribute(Attribute attr) {
    }

    /*
    public void visitInnerClass(java.lang.String name,
                                java.lang.String outerName,
                                java.lang.String innerName,
                                int access)
    访问关于内部类的信息。这个内部类不一定是被访问的类的成员。
    Parameters:
    name - 内部类的内部名称(请参阅Type.getInternalName())。
    outerName - 内部类所属的类的内部名称(请参阅Type.getInternalName())。对于非成员类可能为空。
    innerName - 封闭类中的内部类的(简单)名称。对于匿名内部类可能为空。
    access - 内部类的访问标志，最初在封闭类中声明。
    */
    public void visitInnerClass(String name, String outerName,
                                String innerName, int access) {
    }

    /*
    public FieldVisitor visitField(int access,
                                   java.lang.String name,
                                   java.lang.String descriptor,
                                   java.lang.String signature,
                                   java.lang.Object value)
    访问类的一个领域。
    Parameters:
    access - 字段的访问标志(参见操作码)。此参数还指示字段是合成的还是废弃的。
    name - 字段的名称。
    descriptor - 字段的描述符(请参阅类型)。
    signature - 字段的签名。如果字段的类型不使用泛型类型，则可能为null。
    value - 字段的初始值。如果字段没有初始值，这个参数可能为空，必须是整数、浮点数、长、双精度数或字符串(分别用于int、浮点数、长或字符串字段)。此参数仅用于静态字段。对于非静态字段，它的值被忽略，而非静态字段必须通过构造函数或方法中的字节码指令初始化。
    Returns:
    访问字段注释和属性的访问者，如果这个类访问者对访问这些注释和属性不感兴趣，则为null。
    */
    public FieldVisitor visitField(int access, String name, String desc,
                                   String signature, Object value) {
        System.out.println(" " + desc + " " + name);
        return null;
    }

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
    public MethodVisitor visitMethod(int access, String name,
                                     String desc, String signature, String[] exceptions) {
        System.out.println(" " + name + desc);
        return null;
    }

    /*
    public void visitEnd()
    访问类结束。这个方法是最后一个被调用的方法，用于通知访问者该类的所有字段和方法都已被访问。
    */
    public void visitEnd() {
        System.out.println("}");
    }
}
