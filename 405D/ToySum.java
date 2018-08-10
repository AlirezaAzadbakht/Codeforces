import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.*;

public class ToySum {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader sc = new Reader();
		int n = sc.nextInt();
		int addLater = 0;
		boolean[] data = new boolean[1000001];
		for (int k = 0; k < n; k++) {
			int a = sc.nextInt();
			data[a] = true;
			if (data[1000000 + 1 - a])
				addLater++;
		}
		
		int i = 1;
		int j = 1000000;
		String result="";
		System.out.println(n);
		while (i < 500000 + 1 && n > 0) {
			if (data[i] == true && data[j] == false) {
				result+=(j+" ");
				n--;
			} else if (data[i] == false && data[j] == true) {
				result+=(i+" ");
				n--;
			} else if (addLater > 0 && data[i] == false && data[j] == false) {
				result+=(j+" ");
				result+=(i+" ");
				addLater--;
				n -= 2;
			}
			i++;
			j--;
		}
		OutputStream out = new BufferedOutputStream ( System.out );
        out.write(result.getBytes());
        out.flush();
       

	}
	
	 static class Reader
	    {
	        final private int BUFFER_SIZE = 1 << 16;
	        private DataInputStream din;
	        private byte[] buffer;
	        private int bufferPointer, bytesRead;
	 
	        public Reader()
	        {
	            din = new DataInputStream(System.in);
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public Reader(String file_name) throws IOException
	        {
	            din = new DataInputStream(new FileInputStream(file_name));
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }
	 
	        public String readLine() throws IOException
	        {
	            byte[] buf = new byte[64]; // line length
	            int cnt = 0, c;
	            while ((c = read()) != -1)
	            {
	                if (c == '\n')
	                    break;
	                buf[cnt++] = (byte) c;
	            }
	            return new String(buf, 0, cnt);
	        }
	 
	        public int nextInt() throws IOException
	        {
	            int ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do
	            {
	                ret = ret * 10 + c - '0';
	            }  while ((c = read()) >= '0' && c <= '9');
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public long nextLong() throws IOException
	        {
	            long ret = 0;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        public double nextDouble() throws IOException
	        {
	            double ret = 0, div = 1;
	            byte c = read();
	            while (c <= ' ')
	                c = read();
	            boolean neg = (c == '-');
	            if (neg)
	                c = read();
	 
	            do {
	                ret = ret * 10 + c - '0';
	            }
	            while ((c = read()) >= '0' && c <= '9');
	 
	            if (c == '.')
	            {
	                while ((c = read()) >= '0' && c <= '9')
	                {
	                    ret += (c - '0') / (div *= 10);
	                }
	            }
	 
	            if (neg)
	                return -ret;
	            return ret;
	        }
	 
	        private void fillBuffer() throws IOException
	        {
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	            if (bytesRead == -1)
	                buffer[0] = -1;
	        }
	 
	        private byte read() throws IOException
	        {
	            if (bufferPointer == bytesRead)
	                fillBuffer();
	            return buffer[bufferPointer++];
	        }
	 
	        public void close() throws IOException
	        {
	            if (din == null)
	                return;
	            din.close();
	        }
	    }

}
