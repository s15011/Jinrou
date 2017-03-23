package jp.ac.it_college.std.s15011.jinrou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by samuel on 17/03/23.
 */

public class SocketTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_test);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String address =
                        ((EditText)findViewById(R.id.txtIPAdress)).getText().toString();
                String strPort =
                        ((EditText)findViewById(R.id.txtPort)).getText().toString();
                int port = Integer.parseInt(strPort);

                Socket socket = null;

                try {
                    socket = new Socket(address,port);
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

                    String sendTxt =
                            ((EditText)findViewById(R.id.txtSend)).getText().toString();

                    pw.println(sendTxt);

                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if( socket != null){
                    try {
                        socket.close();
                        socket = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
