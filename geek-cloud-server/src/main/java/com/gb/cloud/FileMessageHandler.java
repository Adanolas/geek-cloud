package com.gb.cloud;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class FileMessageHandler implements Runnable {
    private final File dir;

    private final DataInputStream is;
    private final DataOutputStream os;

    public FileMessageHandler(Socket socket) throws IOException {
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());
        System.out.println("Client accepted");
        dir = new File("Files");
        String[] files = dir.list();
        os.writeUTF("#list#");
        os.writeLong(files.length);
        for (String file: files) {
            os.writeUTF(file);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String utf = is.readUTF();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
