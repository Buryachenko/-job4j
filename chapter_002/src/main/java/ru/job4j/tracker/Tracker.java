package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Date;
/**
 *  Class Класс обертка для Item.
 *  @author Buryachenko
 *  @since 10.01.2019
 *  @version 1
 */
public class Tracker {
	private final Item[] items = new Item[100];
	private int position = 0;

	public int getPosition() {
		return position;
	}
	public Item add(Item item) {
		item.setId(this.generateId());
		if (this.position < items.length) {
			this.items[this.position++] = item;
		} else {
			item = null;
		}
		return item;
	}
	public boolean replace(String id, Item item) {
		boolean result = false;
		item.setId(id);
		for (int i = 0; i < position; i++) {
			if (id.equals(items[i].getId())) {
				items[i] = item;
				result = true;
				break;
			}
		}
		return result;
	}
	public boolean delete(String id) {
		boolean result = false;
		for (int i = 0; i < position; i++) {
			if (id.equals(items[i].getId())) {
				if (i < position - 1) {
					System.arraycopy(items, i + 1, items, i, position - (i + 1));
				}
				items[position - 1] = null;
				this.position--;
				result = true;
				break;
			}
		}
		return result;
	}
	public Item[] findAll() {
		return Arrays.copyOf(items, position);
	}
	public Item[] findByName(String key) {
		int pos = 0;
		Item[] result = new Item[items.length];
		for (int i = 0; i < position; i++) {
			if (key.equals(items[i].getName())) {
				result[pos++] = items[i];
			}
		}
		return Arrays.copyOf(result, pos);
	}
	public Item findById(String id) {
		Item result = null;
		for (int i = 0; i < position; i++) {
			if (id.equals(items[i].getId())) {
				result = items[i];
				break;
			}
		}
		return result;
	}
	private String generateId() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Error Sleep");
		}
		return "11111" + Long.toString(System.currentTimeMillis());
	}
}