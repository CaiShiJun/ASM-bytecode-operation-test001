package org.github.caishijun;

/*
类型对象表示Java类型

        Type.getType(String.class).getInternalName() ：结果是 java/lang/String
        Type.getType(String.class).getDescriptor() ：其实就是 Ljava/lang/String;
        Type.INT_TYPE.getDescriptor() ：就是类型描述符 I
        Type.getArgumentTypes(“(I)V”) ：获取参数类型
        Type.getReturnType(“(I)V”) ： 获取返回值类型
*/

public class TestType001 {
}
