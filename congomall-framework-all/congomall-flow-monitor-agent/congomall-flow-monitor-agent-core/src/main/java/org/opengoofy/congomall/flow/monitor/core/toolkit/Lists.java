

package org.opengoofy.congomall.flow.monitor.core.toolkit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * List 工具类
 *
 * @author JavaEdge
 * @github <a href="https://github.com/Java-Edge" />
 * @公众号 JavaEdge，关注回复：架构师，领取后端架构师成长手册
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Lists {
    
    @SafeVarargs
    public static <E extends Object> ArrayList<E> newArrayList(E... elements) {
        if (elements == null) {
            throw new NullPointerException();
        }
        int capacity = computeArrayListCapacity(elements.length);
        ArrayList<E> list = new ArrayList<>(capacity);
        Collections.addAll(list, elements);
        return list;
    }
    
    private static int computeArrayListCapacity(int arraySize) {
        checkNonnegative(arraySize, "arraySize");
        return saturatedCast(5L + arraySize + (arraySize / 10));
    }
    
    private static int checkNonnegative(int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative but was: " + value);
        }
        return value;
    }
    
    private static int saturatedCast(long value) {
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }
}
