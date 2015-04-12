package org.beatific.daram.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferedFile {

	private static int MAX_STRING_LENGTH = 1024;
	private static String DEFAULT_MODE = "rw";
	private ByteBuffer buffer = ByteBuffer.allocateDirect(MAX_STRING_LENGTH);
	private RandomAccessFile seqFile = null;
	private FileChannel channel = null;
	private String filepath = null;
	private String mode = null;
	private static BufferedFile file = null;

	public synchronized void createSequenceFile(String filepath, String mode)
			throws IOException {
		if (seqFile != null)
			if (filepath != null && filepath.equals(this.filepath)
					&& mode != null && mode.equals(this.mode))
				return;

		this.filepath = filepath;
		this.mode = mode;

		close();

		seqFile = new RandomAccessFile(filepath, mode);
		channel = seqFile.getChannel();
		buffer.clear();
	}

	public static BufferedFile getNewInstance(String filepath)
			throws IOException {
		return getNewInstance(filepath, DEFAULT_MODE);
	}

	public static BufferedFile getNewInstance(String filepath, String mode)
			throws IOException {
		if (file == null)
			file = new BufferedFile();
		file.createSequenceFile(filepath, mode);
		return file;
	}

	public synchronized void write(String value) throws IOException {
		if (value == null)
			return;

		buffer.put(value.getBytes());

		if (buffer.capacity() == buffer.limit()) {
			buffer.flip();
			channel.write(buffer);
			buffer.clear();
		}
		buffer.put((byte)10);
	}

	public synchronized void close() throws IOException {
		if (channel != null)
			channel.close();
		if (seqFile != null)
			seqFile.close();
	}

}
