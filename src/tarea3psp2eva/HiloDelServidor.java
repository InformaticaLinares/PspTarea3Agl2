/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3psp2eva;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class HiloDelServidor extends Thread {

    private Cliente cliente;
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public HiloDelServidor(Socket s) {
        try {
            socket = s;
            //flujos de entrada y salida
            entrada = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(HiloDelServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void envioMensajes(String texto) {
        
    }

}
