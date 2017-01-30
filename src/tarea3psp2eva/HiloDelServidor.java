/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3psp2eva;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author usuario
 */
public class HiloDelServidor extends Thread {

    private Cliente cliente;
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;

    public HiloDelServidor(Socket s) {
        try {
            socket = s;
            //flujos de entrada y salida
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HiloDelServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void envioMensajes(String txt) {

        try {
            for (int i = 0; i < Servidor.AlmacenSocket.length; i++) {
                DataOutputStream out = new DataOutputStream(Servidor.AlmacenSocket[i].getOutputStream());
                out.writeUTF(txt);
            }
        } catch (IOException ex) {
            Logger.getLogger(HiloDelServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        envioMensajes(Servidor.getTxtChat().getText());
        while (true) {
            try {
                String leido=entrada.readUTF();
                JTextArea aux = Servidor.getTxtChat();
                aux.setText(aux.getText()+leido + "\n");
                Servidor.setTxtChat(aux);
                envioMensajes(Servidor.getTxtChat().getText());
            } catch (IOException ex) {
                Logger.getLogger(HiloDelServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
