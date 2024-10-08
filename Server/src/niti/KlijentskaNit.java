/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.AbstractDomainObject;
import domen.Ekvivalenti;
import domen.EkvivalentiRazmena;
import domen.Predmet;
import domen.Radnik;
import domen.Razmena;
import domen.Student;
import domen.Univerzitet;
import gui.frame.ServerFrame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import konstante.Operacije;
import kontroleri.EkvivalentiKontroler;
import kontroleri.PredmetKontroler;
import kontroleri.RadnikKontroler;
import kontroleri.RazmenaKontroler;
import kontroleri.StudentKontroler;
import kontroleri.UniverzitetKontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author jovana
 */
public class KlijentskaNit extends Thread {

    private Socket klijentskiSocket;
    private boolean signal;
    private final ServerFrame frame;

    public KlijentskaNit(Socket klijentskiSocket, ServerFrame frame) {
        this.klijentskiSocket = klijentskiSocket;
        this.frame = frame;
    }

    public Socket getKlijentskiSocket() {
        return klijentskiSocket;
    }

    public void setKlijentskiSocket(Socket klijentskiSocket) {
        this.klijentskiSocket = klijentskiSocket;
    }

    @Override
    public void run() {
        signal = true;

        while (signal && !isInterrupted()) {
            KlijentskiZahtev kz = primiZahtev();
            if (kz == null) {
                break;
            }

            ServerskiOdgovor so = new ServerskiOdgovor();
            boolean uspeh;

            AbstractDomainObject radnik;
            AbstractDomainObject student;
            AbstractDomainObject razmena;
            List<AbstractDomainObject> lista;

            switch (kz.getOperacija()) {
                case Operacije.PRIJAVI_RADNIKA:
                    radnik = RadnikKontroler.getInstancе().prijaviRadnika((Radnik) kz.getParametar());
                    if (radnik != null) {
                        frame.dodajRadnika((Radnik) radnik, getKlijentskiSocket());
                        so.setOdgovor(radnik);
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setOdgovor(null);
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
//                case Operacije.UCITAJ_RADNIKA:
//                    radnik = RadnikKontroler.getInstancе().ucitajRadnika((Radnik) kz.getParametar());
//                    so.setOdgovor(radnik);
//                    break;
                case Operacije.DODAJ_STUDENTA:
                    uspeh = StudentKontroler.getInstance().dodajStudenta((Student) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je dodao studenta");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da doda studenta");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;

                case Operacije.PRETRAZI_STUDENTE:
                    lista = StudentKontroler.getInstance().nadjiStudente((String) kz.getParametar());
                    so.setOdgovor(lista);

                    if (lista.isEmpty()) {
                        so.setPoruka("Sistem ne moze da nadje studenta po zadatoj vrednosti");
                    }
                    break;
                case Operacije.UCITAJ_LISTU_STUDENATA:
                    lista = StudentKontroler.getInstance().ucitajListuStudenata();
                    so.setOdgovor(lista);
                    break;
                case Operacije.UCITAJ_STUDENTA:
                    student = StudentKontroler.getInstance().ucitajStudenta((Student) kz.getParametar());
                    so.setOdgovor(student);
                    break;
                case Operacije.DODAJ_UNIVERZITET:
                    uspeh = UniverzitetKontroler.getInstance().dodajUniverzitet((Univerzitet)kz.getParametar());
                    if(uspeh){
                        so.setPoruka("Sistem je dodao univerzitet");
                        so.setUspeh(Operacije.USPEH);
                    }else {
                        so.setPoruka("Sistem ne moze da doda univerzitet");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.UCITAJ_LISTU_UNIVERZITETA:
                    lista = UniverzitetKontroler.getInstance().ucitajListuUniverziteta();
                    so.setOdgovor(lista);
                    break;
                case Operacije.DODAJ_PREDMET:
                    uspeh = PredmetKontroler.getInstance().dodajPredmet((Predmet) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je dodao predmet");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da doda predmet");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.VRATI_PRED_FON:
                    lista = PredmetKontroler.getInstance().vratiPredmeteFon();
                    so.setOdgovor(lista);
                    break;
                case Operacije.VRATI_PRED_DRUGI:
                    lista = PredmetKontroler.getInstance().vratiPredmeteDrugi();
                    so.setOdgovor(lista);
                    break;
                case Operacije.PRETRAZI_PREDMETE:
                    lista = PredmetKontroler.getInstance().nadjiPredmete((String) kz.getParametar());
                    so.setOdgovor(lista);
                    break;
                case Operacije.UCITAJ_LISTU_PREDMETA:
                    lista = PredmetKontroler.getInstance().ucitajListuPredmeta();
                    so.setOdgovor(lista);
                    break;
                case Operacije.AZURIRAJ_PREDMET:
                    uspeh = PredmetKontroler.getInstance().azurirajPredmet((Predmet) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je azurirao predmet");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da azurira predmet");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.DODAJ_EKVIVALENTE:
                    uspeh = EkvivalentiKontroler.getInstance().dodajEkvivalente((Ekvivalenti) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je dodao ekvivalente");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da doda ekvivalente");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.VRATI_EKVIVALENTE:
                    lista = EkvivalentiKontroler.getInstance().vratiEkvivalente();
                    so.setOdgovor(lista);
                    break;
                case Operacije.DODAJ_RAZMENU:
                    uspeh = RazmenaKontroler.getInstance().dodajRazmenu((Razmena) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je dodao razmenu");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da doda razmenu");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.PRETRAZI_RAZMENU:
                    lista = RazmenaKontroler.getInstance().pretraziRazmene((String) kz.getParametar());
                    so.setOdgovor(lista);

                    if (lista.isEmpty()) {
                        so.setPoruka("Sistem ne moze da nadje razmenu po zadatoj vrednosti");
                    }
                    break;
                case Operacije.UCITAJ_LISTU_RAZMENA:
                    lista = RazmenaKontroler.getInstance().ucitajListuRazmena();
                    so.setOdgovor(lista);
                    break;
                case Operacije.OBRISI_RAZMENU:
                    uspeh = RazmenaKontroler.getInstance().obrisiRazmenu((Razmena) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je obrisao razmenu");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da obrise razmenu");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.AZURIRAJ_RAZMENU:
                    uspeh = RazmenaKontroler.getInstance().azurirajRazmenu((Razmena) kz.getParametar());
                    if (uspeh) {
                        so.setPoruka("Sistem je azurirao razmenu");
                        so.setUspeh(Operacije.USPEH);
                    } else {
                        so.setPoruka("Sistem ne moze da azurira razmenu");
                        so.setUspeh(Operacije.NEUSPEH);
                    }
                    break;
                case Operacije.ZATVORI_KONEKCIJU: 
                    try {
                    System.out.println("Klijentski program zatvoren: " + getKlijentskiSocket());
                    frame.ukloniRadnika(getKlijentskiSocket());

                    so.setUspeh(Operacije.USPEH);
                    so.setPoruka("KLIJENT_ZATVOREN");
                    posaljiOdgovor(so);

                    this.interrupt();
                    getKlijentskiSocket().close();
                    break;
                } catch (IOException ex) {
                    System.err.println("ZATVORI_KONEKCIJU: " + ex.getMessage());
                }

                default:
                    throw new AssertionError();
            }
            if (!getKlijentskiSocket().isClosed()) {
                posaljiOdgovor(so);
            }
        }
    }

    public KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(klijentskiSocket.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Klijentski socket je zatvoren. Nije moguce primati zahteve.");
        }
        return null;
    }

    public void posaljiOdgovor(ServerskiOdgovor o) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(klijentskiSocket.getOutputStream());
            oos.writeObject(o);
        } catch (IOException ex) {
            System.err.println("Klijentski socket je zatvoren. Nije moguce slati odgovore.");
        }
    }

}
