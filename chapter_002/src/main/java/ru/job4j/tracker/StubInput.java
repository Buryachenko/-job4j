package ru.job4j.tracker;
/**
 *  Class Класс для эмуляции поведения пользователя.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;
    public StubInput(final String[] answers) {
        this.answers = answers;
    }
    @Override
    public String ask(String question) {
        return this.answers[this.position++];
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
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
