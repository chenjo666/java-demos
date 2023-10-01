package com.cj.concurrent.testsynchronized;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedUpDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Object o2 = new Object();
        System.out.println(Integer.toHexString(o2.hashCode()));
        System.out.println(ClassLayout.parseInstance(o2).toPrintable());
    }
}
//java.lang.Object object internals:
//OFF  SZ   TYPE DESCRIPTION               VALUE
//  0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
//  8   4        (object header: class)    0x00000d58
// 12   4        (object alignment gap)
//Instance size: 16 bytes
//Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
//
//1936f0f5
//java.lang.Object object internals:
//OFF  SZ   TYPE DESCRIPTION               VALUE
//  0   8        (object header: mark)     0x0000001936f0f501 (hash: 0x1936f0f5; age: 0)
//  8   4        (object header: class)    0x00000d58
// 12   4        (object alignment gap)
//Instance size: 16 bytes
//Space losses: 0 bytes internal + 4 bytes external = 4 bytes total