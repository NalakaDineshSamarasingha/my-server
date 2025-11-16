package com.nalaka.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {

    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
    
            String html = "<html><head></head><body>Hello world</body></html>";
    
            final String CRLF = "\n\r";
    
            String response
                    = "HTTP/1.1 200 OK" + CRLF
                    + "Content-Length" + html.getBytes().length + CRLF
                    + CRLF
                    + html
                    + CRLF + CRLF;
    
            outputStream.write(response.getBytes());
    
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally{
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch(IOException e){}
            }
            if(outputStream!=null){
                try{
                    outputStream.close();
                }catch(IOException e){}
            }
            if(socket!=null){
                try{
                    socket.close();
                }catch(IOException e){}
            }
        }
    }
}
