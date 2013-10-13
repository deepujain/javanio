package com.javanio;

import java.nio.ByteBuffer;

public class ByteBufferExample {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(100);
		BufferFillDrain d = new BufferFillDrain();
		while (d.fillBuffer(buffer)) {
			buffer.flip();
			d.drainBuffer(buffer);
			buffer.clear();
			d.index++;
		}
	}
}

class BufferFillDrain {
	String strings[] = new String[] { "This is a byte buffer string 1", "This is a byte buffer string 2",
			"This is a byte buffer string 3", "This is a byte buffer string 4" };
	int index = 0;

	public void drainBuffer(ByteBuffer b) {
		while (b.hasRemaining()) {
			System.out.print((char) b.get());
		}
		System.out.println("");
	}

	public boolean fillBuffer(ByteBuffer b) {
		if (index >= strings.length) {
			return false;
		}
		String data = strings[index];
		for (int i = 0; i < data.length(); i++) {
			b.put((byte) data.charAt(i));
		}
		return true;
	}
}
