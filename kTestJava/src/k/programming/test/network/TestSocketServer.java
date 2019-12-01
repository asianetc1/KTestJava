/**
 * 
 */
package k.programming.test.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author k
 *
 */
public class TestSocketServer {

		//소켓 포트
		private static final int IF_SERVER_SOCKET_PORT = 8000;
		//소켓 스레드 풀의 최대 스레드 개수
		private static final int IF_SERVER_MAX_SOCKET_THREAD_CNT = 500;
		
		private static ExecutorService threadPool = Executors.newFixedThreadPool(IF_SERVER_MAX_SOCKET_THREAD_CNT);
		
		/**
		 * 
		 * @param args
		 */
		public static void main(String[] args) {

			try {
				// 서버소켓 생성
				ServerSocket serverSocket = new ServerSocket(IF_SERVER_SOCKET_PORT);

				// 소켓서버가 종료될때까지 무한루프
				while(true){
					System.out.println("k>TestSocketServer.main - : SERVER SOCKET CONNECT START" );	//t+++
					// 소켓 접속 요청이 올때까지 대기합니다.
					Socket socket = serverSocket.accept();
					try{
						// 요청이 오면 스레드 풀의 스레드로 소켓을 넣어줍니다.
						// 이후는 스레드 내에서 처리합니다.
						threadPool.execute(new ConnectionWrapper(socket));
					}catch(Exception e){
						e.printStackTrace();
					}
					System.out.println("k>TestSocketServer.main - : SERVER SOCKET CONNECT END" );	//t+++
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}


class ConnectionWrapper implements Runnable{

	private Socket socket = null;

	public ConnectionWrapper(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			System.out.println("k>ConnectionWrapper.run - LocalPort:" + socket.getLocalPort());	//t+++
			System.out.println("k>ConnectionWrapper.run - Port:" + socket.getPort());	//t+++
			
			//client-->server
			int receiveDataSize = 0;
			byte[] commBuffer = new byte[1024];
			byte[] receiveData;
			receiveDataSize = socket.getInputStream().read(commBuffer);
			if(receiveDataSize != 0){
			    receiveData = new byte[receiveDataSize];
			    for(int j=0; j < receiveDataSize; ++j){
			        receiveData[j] = commBuffer[j];
			        System.out.print("k>ConnectionWrapper.run - commBuffer[j]:" + commBuffer[j] + "\t");	//t+++
			        System.out.format("%02X ", commBuffer[j]);
			    }
			}
			
			//server-->client
			OutputStream stream = socket.getOutputStream();
			stream.write("Y".getBytes());	//!!!

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}