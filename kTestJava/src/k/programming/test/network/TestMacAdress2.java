package k.programming.test.network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TestMacAdress2 {

	public static void main(String[] args) {

		try {
			InetAddress ip = InetAddress.getLocalHost();
		    InetAddress add = InetAddress.getByName(ip.getHostAddress());
		    NetworkInterface ni1 = NetworkInterface.getByInetAddress(add);

		    System.out.println("k>TestMacAdress2.main - ip:" + ip);	//test+++
		    if (ni1 != null) {
		        byte[] mac1 = ni1.getHardwareAddress();
		        String mac = "";
		        System.out.println("k>TestMacAdress2.main - mac1.toString():" + mac1.toString() );	//test+++
		        if (mac1 != null) {
		            for (int k = 0; k < mac1.length; k++) {
		                mac += String.format("%02X%s", mac1[k], (k < mac1.length - 1) ? "-" : "");
		            }
		            System.out.println("k>TestMacAdress2.main - mac:" + mac);	//test+++
		        } else {
		            System.out.println("Address doesn't exist ");
		        }
		        System.out.println();
		    } else {
		        System.out.println("address is not found.");
		    }
		} catch (UnknownHostException e) {
		    e.printStackTrace();
		} catch (SocketException e) {
		    e.printStackTrace();
		}
		
	}

}
