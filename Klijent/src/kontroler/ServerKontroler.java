/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.ServerskiOdgovor;
import transfer.KlijentskiZahtev;

/**
 *
 * @author jovana
 */
public class ServerKontroler {

    private Socket socket;
    private static ServerKontroler instanca;

    private ServerKontroler() {
    }

    public static ServerKontroler getInstanca() {
        if (instanca == null) {
            instanca = new ServerKontroler();
        }
        return instanca;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void posaljiZahtev(KlijentskiZahtev z) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(z);
        } catch (IOException ex) {
            System.exit(0);
        }
    }

    public ServerskiOdgovor primiOdgovor() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return (ServerskiOdgovor) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Ugasen klijent");
            System.exit(0);
        }
        return null;
    }

}
