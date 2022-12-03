package com.itbuzzpress.websocket.endpoint;

import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@ServerEndpoint(value = "/hellobinary")
public class HelloWorldBinaryEndpoint {

	@OnOpen
	public void hello(Session session) {

	}

	@OnMessage
	public ByteBuffer message(String fileName) {

		File fi = new File(fileName);

		ByteBuffer buf = null;
		try {

			BufferedImage image = ImageIO.read(fi);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

	               
			ImageIO.write(image, "png", baos);
			byte[] byteArray = baos.toByteArray();
			buf = ByteBuffer.wrap(byteArray);
			System.out.println("Sent binary " + byteArray.length);
        

		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}

	@OnError
	public void error(Throwable t) {
		System.out.println("Oops! " + t.getMessage());
	}

}
