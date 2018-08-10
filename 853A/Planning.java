import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Planning {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader sc = new Reader();
		int n = sc.nextInt();
		int d = sc.nextInt();
		PriorityQueue<node> data = new PriorityQueue<node>(n, new Comparator<node>() {
			@Override
			public int compare(node a, node b) {
				// TODO Auto-generated method stub
				if (a.getPenalty() < b.getPenalty())
					return 1;
				else if (a.getPenalty() > b.getPenalty())
					return -1;
				return 0;
			}
		});
		int[] answer = new int[n];
		Long totalPenalty = (long) 0;
		for (int i = 0; i < n; i++) {
			data.add(new node(sc.nextInt(), i));
			if (i < d)
				continue;
			node a = data.poll();
			answer[a.getI()] = i + 1;
			totalPenalty += ((long) (i - a.getI()) * (long) a.getPenalty());
		}
		int k = n;
		while (data.isEmpty() == false) {
			node a = data.poll();
			answer[a.getI()] = k + 1;
			totalPenalty += ((long) (k - a.getI()) * (long) a.getPenalty());
			k++;
		}
		OutputStream out = new BufferedOutputStream(System.out);

		System.out.println(totalPenalty);
		for (int i : answer) {
			String temp = String.valueOf(i) + " ";
			out.write(temp.getBytes());
		}
		out.flush();
	}

}

class node {
	private int i;
	private int penalty;

	public node(int penalty, int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
		this.penalty = penalty;
	}

	public int getI() {
		return i;
	}

	public int getPenalty() {
		return penalty;
	}

}

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}
