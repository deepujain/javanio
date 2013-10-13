package com.javanio;

import java.nio.CharBuffer;

public class CharBufferExample {
	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(100);
		CharBufferFillDrain d = new CharBufferFillDrain();
		while (d.fillBuffer(buffer)) {
			buffer.flip();
			d.drainBuffer(buffer);
			buffer.clear();
			d.index++;
		}
	}
}

class CharBufferFillDrain {
	String strings[] = new String[] { "This is a char buffer string 1", "This is a char buffer string 2",
			"This is a char buffer string 3", "This is a char buffer string 4" };
	int index = 0;

	public void drainBuffer(CharBuffer b) {
		while (b.hasRemaining()) {
			System.out.print(b.get());
		}
		System.out.println("");
	}

	public boolean fillBuffer(CharBuffer b) {
		if (index >= strings.length) {
			return false;
		}
		String data = strings[index];
		for (int i = 0; i < data.length(); i++) {
			b.put(data.charAt(i));
		}
		return true;
	}
}