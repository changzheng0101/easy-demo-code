package com.weixiao;

import java.time.LocalDate;

/**
 * @author changzheng
 * @date 2025年10月31日 16:54
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().minusDays(1).toString());
    }
}
