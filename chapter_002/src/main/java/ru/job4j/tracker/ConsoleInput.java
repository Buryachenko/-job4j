package ru.job4j.tracker;
import java.util.*;
/**
 *  Class Класс используется для ввода пользовательских данных из консоли.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}