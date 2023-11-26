package com.iweb.test3;

/**
 * volatile
 * 保证变量的可见性
 * 禁止指令重排序
 * 每个线程操作数据的时候，会把数据从主内存读取到自己的工作内存，如果线程操作了数据并且写回，其他线程的变量副本会失效，并且立即看到最新的值
 * 不要大量使用，避免出现总线风暴
 *
 * JMM
 * java内存模型，java内存虚拟机规范中所定义的一种内存模型
 * 为了屏蔽底层不同的计算机区别
 *
 * 计算机的内存模型
 * 高速缓存，作为内存和CPU之间的缓冲
 * 将运算需要使用到的数据赋值到缓存中
 * 让运算能够快速运行，等运算结束后再从缓存中同步回内存中
 * cpu就不需要在等待内存读写完成之后再继续运行指令了
 * 在多核cpu出现之后，引入了一个新问题：缓存一致性问题
 * 每一个cpu都有自己的高速缓存，而所有cpu又共享同一个主内存
 * 必须遵循一致性协议
 * @author Min
 * @date 2023/11/23 20:12
 */
public class Test {
    public static void main(String[] args) {
        lyh ldt = new lyh();
        ldt.start();
        while (true){
            if(ldt.isFlag()){
                System.out.println("flag值变化了");
                break;
            }
        }
    }
}
