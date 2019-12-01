/**
 * 
 */
package k.programming.test.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author k
 *
 */
public class TestSocketClient {

		// 연결할 포트를 지정합니다.
		private static final String IF_SERVER_IP = "127.0.0.1";
		private static final int IF_SERVER_SOCKET_PORT = 8000;
		
		/**
		 * 
		 * @param args
		 */
		public static void main(String[] args) {

				try {
					// 소켓 생성
					Socket socket = new Socket(IF_SERVER_IP, IF_SERVER_SOCKET_PORT);

					//
					byte[] data  = new byte[2];  //배열을 생성한다.
					data[0] = 0x02;
					data[1] = 0x0f;
					socket.getOutputStream().write(data);
					
					//
					InputStream stream = socket.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(stream));
					String response = br.readLine();
					System.out.print("리턴값:"+response); // 결과물 출력
					
					socket.close(); // 소켓을 닫습니다.
						
					System.exit(0); // 프로그램 종료

				} catch(Exception e) {
					e.printStackTrace();
				}
			
		}
}
