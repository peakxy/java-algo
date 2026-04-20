package edu.xyf.labuladong.basic;

/**
 * @Author: Xuyifeng
 * @Description:
 * @Date: 2026/4/9 22:14
 */

public class MyBitSet {
    // 使用 long 数组作为位图的底层存储
    private final long[] words;
    // 位图能够存储的最大元素值 + 1
    private final int size;

    public MyBitSet(int size) {
        this.size = size;
        // 根据 size 计算需要多少个 long 来存储
        this.words = new long[size / 64 + 1];
    }

    // 判断指定比特位是否为 1
    public boolean get(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= size) {
            throw new IndexOutOfBoundsException("bitIndex must be between 0 and " + (size - 1));
        }
        // 找到 bitIndex 在 words 数组中的索引
        int wordIndex = bitIndex / 64;
        // 找到 bitIndex 在 long 值中的具体 bit 位
        int bitOffset = bitIndex % 64;
        // 使用 & 操作判断该位是否为 1
        return (words[wordIndex] & (1L << bitOffset)) != 0;
    }

    // 将指定比特位设置为 1
    public void set(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= size) {
            throw new IndexOutOfBoundsException("bitIndex must be between 0 and " + (size - 1));
        }
        // 找到 bitIndex 在 words 数组中的索引
        int wordIndex = bitIndex / 64;
        // 找到 bitIndex 在 long 值中的具体 bit 位
        int bitOffset = bitIndex % 64;
        // 使用 | 操作将该位置 1
        words[wordIndex] |= (1L << bitOffset);
    }

    // 将指定比特位设置为 0
    public void clear(int bitIndex) {
        if (bitIndex < 0 || bitIndex >= size) {
            throw new IndexOutOfBoundsException("bitIndex must be between 0 and " + (size - 1));
        }
//        int wordIndex = bitIndex / 64;
        int wordIndex = bitIndex >> 6;
//        int bitOffset = bitIndex % 64;
        int bitOffset = bitIndex & 63; // 因为当除数是 2 的整数次幂时，取模运算 % 64 等价于位运算 & (64 - 1)
        // 使用 & 和 ~ 操作将该位置 0
        words[wordIndex] &= ~(1L << bitOffset);
    }

    public static void main(String[] args) {
        MyBitSet bitSet = new MyBitSet(1000);

        bitSet.set(10);
        bitSet.set(100);
        bitSet.set(500);

        System.out.println("Get 10: " + bitSet.get(10));   // true
        System.out.println("Get 100: " + bitSet.get(100)); // true
        System.out.println("Get 200: " + bitSet.get(200)); // false

        bitSet.clear(100);
        System.out.println("Get 100 after clear: " + bitSet.get(100)); // false
    }
}
