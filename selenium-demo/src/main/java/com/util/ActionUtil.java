package com.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil extends BaseUtil {
    private static Actions act() {
        return new Actions(driver);
    }

    public static void dragAndDrop(WebElement source, int x, int y) {
        act().dragAndDropBy(source, x, y).perform();
    }

    /**
     * 模拟键盘按下
     *
     * @param target 目标元素
     * @param keys   键盘按下的键
     */
    public static void sendKeys(WebElement target, CharSequence keys) {
        act().sendKeys(target, keys).perform();
    }
}
