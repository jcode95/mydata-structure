package org.buptdavid.datastructure.zj.thread.asm;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiezhou
 * @CalssName: ASMTest
 * @Package org.buptdavid.datastructure.zj.thread.asm
 * @Description:ASM字节码插桩详解
 * @date 2021/12/30/15:19
 */
public class ASMTest {

    public static void redefineHelloWorldClass(){
        try {
            InputStream inputStream  = new FileInputStream("F:\\develop\\self-data\\data-structure\\my-datastructure\\src\\main\\java\\org\\buptdavid\\datastructure\\zj\\thread\\asm\\HelloWorld.class");
            // 1. 创建 ClassReader 读入 .class 文件到内存中
            ClassReader reader = new ClassReader(inputStream);
            // 2. 创建 ClassWriter 对象，将操作之后的字节码的字节数组回写
            ClassWriter classWriter = new ClassWriter(reader, ClassWriter.COMPUTE_MAXS);
            // 3. 创建自定义的 ClassVisitor 对象
            ClassVisitor change = new ChangeVisitor(classWriter);
            // 4. 将 ClassVisitor 对象传入 ClassReader 中
            reader.accept(change, ClassReader.EXPAND_FRAMES);
            System.out.println("Success!");
            // 获取修改后的 class 文件对应的字节数组
            byte[] code = classWriter.toByteArray();
            try {
                // 将二进制流写到本地磁盘上
                FileOutputStream fos = new FileOutputStream("F:\\develop\\self-data\\data-structure\\my-datastructure\\src\\main\\java\\org\\buptdavid\\datastructure\\zj\\thread\\asm\\OutputHelloWorld.class");
                fos.write(code);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static class ChangeVisitor extends ClassVisitor {

        ChangeVisitor(ClassVisitor classVisitor) {
            super(Opcodes.ASM5, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
            if (name.equals("<init>")) {
                return methodVisitor;
            }
            return new ChangeAdapter(Opcodes.ASM4, methodVisitor, access, name, desc);
        }
    }
    static class ChangeAdapter extends AdviceAdapter {
        private int startTimeId = -1;

        private String methodName = null;

        ChangeAdapter(int api, MethodVisitor mv, int access, String name, String desc) {
            super(api, mv, access, name, desc);
            methodName = name;
        }

        @Override
        protected void onMethodEnter() {
            super.onMethodEnter();
            startTimeId = newLocal(Type.LONG_TYPE);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitIntInsn(LSTORE, startTimeId);
        }

        @Override
        protected void onMethodExit(int opcode) {
            super.onMethodExit(opcode);
            int durationId = newLocal(Type.LONG_TYPE);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J", false);
            mv.visitVarInsn(LLOAD, startTimeId);
            mv.visitInsn(LSUB);
            mv.visitVarInsn(LSTORE, durationId);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitLdcInsn("The cost time of " + methodName + "() is ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitVarInsn(LLOAD, durationId);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false);
            mv.visitLdcInsn(" ms");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        }
    }

}
