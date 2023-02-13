package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data = message.getData();
		
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		segment = new byte[SEGMENTSIZE];
		segment[0] = (byte) data.length;
		if (segment.length + 1 >= data.length) {
			for (int x = 0; x < segment[0]; x++) {
				segment[x+1] = data[x];
			}
		}
			
			
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
		byte[] temp = new byte[segment[0]];
		if (segment.length <= 128) {
			for (int x = 0; x < segment[0]; x++) {
				temp[x] = segment[x+1];
			}
			message = new Message(temp);
		}
			
		
		// TODO - END
		
		return message;
		
	}
	
}
