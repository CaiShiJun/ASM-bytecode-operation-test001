package org.github.caishijun;

import org.objectweb.asm.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 为类增加字段
 */
public class AddFieldAdapter extends ClassVisitor {

    private String fName;
    private int fAcc;
    private String fDesc;
    private boolean isFieldPresent;

    public AddFieldAdapter(ClassVisitor classVisitor, int fAcc, String fDesc, String fName) {
        super(Opcodes.ASM4, classVisitor);
        this.fAcc = fAcc;
        this.fDesc = fDesc;
        this.fName = fName;
    }

    public static void main(String args[]) {
        try {
            //读取类文件
            ClassReader classReader = new ClassReader("org/github/caishijun/Account");
            ClassWriter classWriter = new ClassWriter(0);
            ClassVisitor classVisitor = new AddFieldAdapter(classWriter, Opcodes.ACC_PRIVATE, "I", "added");        //使用自定义的 AddFieldAdapter 类，删除m
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

    @Override
    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        if (s.equals(fName)) {
            isFieldPresent = true;
        }
        return super.visitField(i, s, s1, s2, o);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        if (!isFieldPresent) {
            FieldVisitor fieldVisitor = cv.visitField(fAcc, fName, fDesc, null, null);
            if (fieldVisitor != null) {
                fieldVisitor.visitEnd();
            }
        }
        cv.visitEnd();
    }
}
