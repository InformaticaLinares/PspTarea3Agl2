/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3psp2eva;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 *
 * @author usuario
 */
public class HiloDelServidor extends Thread{
    
    
    
    public HiloDelServidor(Socket sc){
        try{
        InputStream is = sc.getInputStream();
        DataInputStream entradaS = new DataInputStream(is);
        }catch( IOException e){
            
            
        }
        
    }
    
    public void envioMensajes(String texto){
        
        
        
    }
    
}
