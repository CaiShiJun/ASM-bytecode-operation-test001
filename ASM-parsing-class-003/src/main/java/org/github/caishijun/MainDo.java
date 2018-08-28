package org.github.caishijun;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

public class MainDo {
    public static void main(String[] a) {
        try {
            ClassPrinter classPrinter = new ClassPrinter();
            ClassReader classReader = new ClassReader("java.lang.Runnable");

            /*
            public void accept(ClassVisitor classVisitor,
                   int parsingOptions)
            使给定的访问者访问传递给这个类阅读器的构造函数的jvm类文件结构。
            Parameters:
            classVisitor - 必须访问这个类的访问者。
            parsingOptions - 用于解析该类的选项。一个或多个 SKIP_CODE, SKIP_DEBUG, SKIP_FRAMES or EXPAND_FRAMES.
            */
            classReader.accept(classPrinter, 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
