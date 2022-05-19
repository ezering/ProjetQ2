package be.helha.server;

import be.helha.common.networks.ObjectSocket;

import java.io.IOException;

public class ClientThread extends Thread{
    private final ObjectSocket objectSocket;
    private Server server;

    public ClientThread(Server server, ObjectSocket objectSocket) {
        this.objectSocket = objectSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            boolean isRunning = true;
            while (isRunning) {
              /*  AbstractMessage message = objectSocket.read();
                if(message instanceof LogoutUser) {
                    objectSocket.write(message);
                    isRunning = false;
                } else {
                    server.broadcast(message);
                }*/


                server.broadcast("This is a broadcast!");
                isRunning = false;

            }
            try {
                objectSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception e) {
            server.deconnect(this);
            e.printStackTrace();
        }
    }

    public void write(Object object) throws IOException {
        objectSocket.write(object);
    }
}