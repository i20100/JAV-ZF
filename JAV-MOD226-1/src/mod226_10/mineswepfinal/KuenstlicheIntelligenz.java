package mod226_10.mineswepfinal;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("46e5cc34-15f4-4b72-84ad-13048f8e6412")
public class KuenstlicheIntelligenz {
//    Zugriff auf ZellenArray �ndern auf static
    @objid ("31385a50-24ea-46dc-ba35-04b3dd09c5e1")
     int letzteSpalte = Spielfeld.zellenArray[0].length-1;

    @objid ("a42f17a0-80dc-45f1-858e-8dfecb661c61")
     int letzteZeile = Spielfeld.zellenArray.length-1;

    @objid ("73b918c7-b4b3-438c-a653-e29615f82538")
    public int zaehleVerteilteBomben(Spielfeld spielfeld) {
        int verteilteBomben = 0;
        for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
            for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
                if (Spielfeld.zellenArray[i][j].bombe == true)
                    verteilteBomben = verteilteBomben+1;
            }
        }
        return verteilteBomben;
    }

    @objid ("84d57aaf-6dc1-4aec-862c-9c32b9ab5846")
    public void verteileBomben(Spielfeld spielfeld, int gewuenschteBomben) {
        int anzahlZellen = zaehleZellen(spielfeld);
        
        for (int i = 0; i < gewuenschteBomben; i++) {
            int randomInt = (int) (Math.random()*anzahlZellen);
            int zeile = randomInt/Spielfeld.zeilen;
            int spalte = randomInt%Spielfeld.zeilen;
            if (Spielfeld.zellenArray[zeile][spalte].bombe == false) {
                Spielfeld.zellenArray[zeile][spalte].setzeBombe();
                //    System.out.println("Bombe auf zeile, spalte:" + zeile + ", " + spalte); //Kommentar ausblenden f�r detailierte Ausgabe
            } else {
                i = i-1;
            }
        }
    }

    @objid ("6f8525a0-0c81-4856-bf4a-7d4b61fc6294")
    public int zaehleZellen(Spielfeld spielfeld) {
        int anzahlZellen = 0;
        for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
            for (int j = 0; j < Spielfeld.zellenArray[i].length; j++) {
                anzahlZellen += 1;
            }
        }
        return anzahlZellen;
    }

    @objid ("0738a83d-d103-4289-96d6-1de3141c59d4")
    public void beschrifteNachbarzellenZuBomben(Spielfeld spielfeld) {
        // TODO aufteilen der Methode?
        // In hole Liste Bomben und wende Methode waahleVariante an
        // mach etwas mit der Antwort aus waehleVariante
        
        
        //1. Gehe nur von den Feldern aus welche Bomben besitzen
        //2. Gehe f�r jedes Feld welche Eine Bombe hat eine Routine durch
        //3. Routine erh�ht Bombenz�hler auf Zellen
        //4. Es gibt neun Verschiedene Methoden je nach Bombenort
        for (Zelle zelle : spielfeld.listeBombenOrte) {
        
            int zeile = zelle.yKoordinate;
            int spalte = zelle.xKoordinate;
        
            switch (waehleVariante(zelle)) {
            case 1:
                bombeObenLinks(spielfeld);
                break;
            case 2:
                bombeObenMitte(spielfeld, spalte);
                break;
            case 3:
                bombeObenRechts(spielfeld);
                break;
            case 4:
                bombeMitteLinks(spielfeld, zeile);
                break;
            case 5:
                bombeMitteMitte(spielfeld, zeile, spalte);
                break;
            case 6:
                bombeMitteRechts(spielfeld, zeile);
                break;
            case 7:
                bombeUntenLinks(spielfeld);
                break;
            case 8:
                bombeUntenMitte(spielfeld, zeile, spalte);
                break;
            case 9:
                bombeUntenRechts(spielfeld);
                break;
        
            default:
                break;
            }
        }
    }

    @objid ("ef8c618b-173c-4987-8018-7452e85e4b1e")
    public void bombeObenLinks(Spielfeld spielfeld) {
        // gilt nur f�r Zelle[0][0]!
        // Erh�he bombenInNachbarschaft f�r rechts, unten, rechts unten
        Spielfeld.zellenArray[0][1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][0].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][1].bombenInNachbarschaft += 1;
    }

    @objid ("9ffa8cc9-bc73-4dc9-9ffd-7b4ea2c4d24a")
    public void bombeObenMitte(Spielfeld spielfeld, int spalte) {
        // gilt nur f�r Zelle[0][1]-[0][Spielfeld.zellenArray.[0].length-1]!
        // Erh�he bombenInNachbarschaft f�r links, rechts, unten, unten li. u. re.
        // in Bezug auf aktuelle position!
        Spielfeld.zellenArray[0][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[0][spalte+1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][spalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][spalte+1].bombenInNachbarschaft += 1;
    }

    @objid ("1d67b988-0ace-4810-99be-19ab968ab416")
    public void bombeObenRechts(Spielfeld spielfeld) {
        // gilt nur f�r Zelle[0][letzteSpalte]!
        // Erh�he bombenInNachbarschaft f�r links, unten, links unten
        Spielfeld.zellenArray[0][letzteSpalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][letzteSpalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[1][letzteSpalte-1].bombenInNachbarschaft += 1;
    }

    @objid ("77044783-0d3c-42b8-80fa-aa1fb5550161")
    public void bombeUntenLinks(Spielfeld spielfeld) {
        // gilt nur f�r Zelle[letzteZeile][0]!
        // Erh�he bombenInNachbarschaft f�r rechts, oben, rechts oben
        Spielfeld.zellenArray[letzteZeile][1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][0].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][1].bombenInNachbarschaft += 1;
    }

    @objid ("d377ccf7-cbd5-4777-a7b5-e522824525d1")
    public void bombeUntenMitte(Spielfeld spielfeld, int zeile, int spalte) {
        // gilt nur f�r Zelle[letzteZeile][1]-[letzteZeile][Spielfeld.zellenArray.[0].length-1]!
        // Erh�he bombenInNachbarschaft f�r links, rechts, oben, oben li. u. re.
        // in Bezug auf aktuelle position!
        Spielfeld.zellenArray[letzteZeile][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile][spalte+1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][spalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][spalte+1].bombenInNachbarschaft += 1;
    }

    @objid ("fa1b53a9-1c20-4a91-b480-0180cecaa9ad")
    public void bombeUntenRechts(Spielfeld spielfeld) {
        // gilt nur f�r Zelle[0][letzteSpalte]!
        // Erh�he bombenInNachbarschaft f�r links, oben, links oben
        Spielfeld.zellenArray[letzteZeile][letzteSpalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][letzteSpalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[letzteZeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
    }

    @objid ("14417964-d247-45e8-839f-4a9c6f835a11")
    public void bombeMitteLinks(Spielfeld spielfeld, int zeile) {
        // gilt nur f�r Zellen[1][0] - [letzteZeile-1][0]!
        // Erh�he bombenInNachbarschaft f�r rechts, oben, unten, rechts oben und unten
        Spielfeld.zellenArray[zeile][1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][0].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][0].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][1].bombenInNachbarschaft += 1;
    }

    @objid ("75859d58-f758-4741-beca-691f79181b99")
    public void bombeMitteMitte(Spielfeld spielfeld, int zeile, int spalte) {
        // gilt f�r alle Zellen welche keinen Rand ber�hren!
        // Erh�he bombenInNachbarschaft f�r links, rechts, oben, unten, oben und unten li. u. re.
        // in Bezug auf aktuelle position!
        Spielfeld.zellenArray[zeile][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile][spalte+1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][spalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][spalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][spalte+1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][spalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][spalte+1].bombenInNachbarschaft += 1;
    }

    @objid ("ff012d49-7eb0-44cb-940c-184407e11afd")
    public void bombeMitteRechts(Spielfeld spielfeld, int zeile) {
        // gilt nur f�r Zelle[1][letzteSpalte] - [letzteZeile-1][letzteSpalte]
        // Erh�he bombenInNachbarschaft f�r links, oben, unten, links oben unten
        Spielfeld.zellenArray[zeile][letzteSpalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][letzteSpalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][letzteSpalte].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile-1][letzteSpalte-1].bombenInNachbarschaft += 1;
        Spielfeld.zellenArray[zeile+1][letzteSpalte-1].bombenInNachbarschaft += 1;
    }

//    public int waehleVarianteOLD(int[][] ersteBombe) {
//        return waehleVariante(ersteBombe);
//    }
    @objid ("b99664e7-1281-4e05-800a-776f3b0cc22d")
    public int waehleVariante(Zelle zelle) {
        int zeile = zelle.yKoordinate;
        int spalte = zelle.xKoordinate;
        
        if (zeile == 0) {
            if (spalte == 0) {
                return 1;
            } 
            if (spalte == Spielfeld.spalten-1) {
                return 3;
            }
            else {
                return 2;
            }
        }
        
        if (zeile == Spielfeld.zeilen-1) {
            if (spalte == 0) {
                return 7;
            } 
            if (spalte == Spielfeld.spalten-1) {
                return 9;
            }
            else {
                return 8;
            }
        }
        
        if (zeile < Spielfeld.zeilen-1 && zeile > 0) {
            if (spalte == 0) {
                return 4;
            } 
            if (spalte == Spielfeld.spalten-1) {
                return 6;
            }
            else {
                return 5;
            }
        }
        return 0; // default return 0
    }

    @objid ("e4c501f9-d9e3-44c4-9bc2-f98906965044")
    public List<Zelle> pruefeNachbarzellenKeineBombe(int zeile, int spalte) {
        // wird in Aufdecken verwendet um Variante Nullen zeigen einzuleiten anpassen bzw. verweisen auf endg�ltige findeNullen + Tests wieder enablen
        List<Zelle> zellen = new ArrayList<Zelle>(); 
        zellen.add(Spielfeld.zellenArray[2][2]);
        zellen.add(Spielfeld.zellenArray[2][4]);
        zellen.add(Spielfeld.zellenArray[1][3]);
        zellen.add(Spielfeld.zellenArray[3][3]);
        zellen.add(Spielfeld.zellenArray[1][2]);
        zellen.add(Spielfeld.zellenArray[1][4]);
        zellen.add(Spielfeld.zellenArray[3][2]);
        zellen.add(Spielfeld.zellenArray[3][4]);
        
        //        for (Zelle zelle : zellen) {
        //            zelle.zeichen = "0";
        //        }    
        
        //TODO nachdem die Zellen mit Null gefunden wurden, diese in Liste schreiben und weitergeben?
        //??? Wie wird verhindert das eine Feld nicht mehrmals oder ewig gepr�ft wird? Flag setzen?
        List<Zelle> nachbarZellenMit0 = new ArrayList<>();
        return nachbarZellenMit0;
    }

    @objid ("9c549826-4bdb-49eb-b4e1-8292fa875515")
    public void findeNullen(int zeile, int spalte) {
        // Cheat-L�sung 1
        //        Spielfeld.zellenArray[0][0].zeichen = "0";
        //        Spielfeld.zellenArray[1][0].zeichen = "0";
        //        Spielfeld.zellenArray[2][0].zeichen = "1";
        //        Spielfeld.zellenArray[3][0].zeichen = " ";
        //        Spielfeld.zellenArray[4][0].zeichen = "1";
        //        Spielfeld.zellenArray[5][0].zeichen = "0";
        //        Spielfeld.zellenArray[6][0].zeichen = "1";
        //        Spielfeld.zellenArray[7][0].zeichen = " ";
        
        // Cheat-L�sung 2
        //        Spielfeld.zellenArray[0][0].zeichen = "0";
        //        Spielfeld.zellenArray[1][0].zeichen = "0";
        //        Spielfeld.zellenArray[2][0].zeichen = "1";
        //
        //        Spielfeld.zellenArray[4][0].zeichen = "1";
        //        Spielfeld.zellenArray[5][0].zeichen = "0";
        //        Spielfeld.zellenArray[6][0].zeichen = "1";
        
        //DONE liste erstellen? sobald zelle keine bombe ist, und keine nachbarbomben hat, zellen zur liste nullen hinzuf�gen
        //TODO bis wieder eine bombe kommt, danach neue liste ertellen
        
        List<Zelle> nullen = new ArrayList<Zelle>();
        
        findeNachbarNullZellen(nullen);
        beschrifteNachbarNullMitNull(nullen);
        beschrifteZellenZwischenNullUndBombe(nullen);
        
        //1. check feld auf bombe, wenn ja skip, da nichts mit dem Feld geschehen soll da default wert f�r Zelle ja " " sein sollte.s
        //2. check ob zelle.nachbarbomben gr�sser als null, wenn ja mach was, auch nichts,
        // diese Zellen m�ssen dann von allen nullen aus aufgerufen werden und mit anzahl nachbarbomben beschrieben werden.
        //3. wenn nein, mach das richtige
        
        
        // TODO erstelle Listenbezugsattribut pro Zelle
        // TODO erstelle Liste pro neues nicht verbundenes Null in Spalte
        //        List<Zelle>
    }

    @objid ("c2fbf017-7d23-42b9-a64f-504fa8451011")
    public void findeNachbarNullZellen(List<Zelle> nullen) {
        // FIXME unterscheide verbunden mit Aufdeckort und nicht verbunden: nicht verbundene Zellen d�rfen nicht in die Liste aufgenommen werden!
        
        // findet ALLE Nullen auf dem Spielfeld! ALLE! siehe FIXME
        for (int j = 0; j < Spielfeld.zellenArray[0].length; j++) {
            for (int i = 0; i < Spielfeld.zellenArray.length; i++) {
                if (Spielfeld.zellenArray[i][j].bombe == false) {
                    if (Spielfeld.zellenArray[i][j].bombenInNachbarschaft == 0) {
                        nullen.add(Spielfeld.zellenArray[i][j]);
                    }
                }
            }
        }
    }

    @objid ("847e7ea8-dacf-40b0-b15c-864238719a12")
    public void beschrifteNachbarNullMitNull(List<Zelle> nullen) {
        for (Zelle zelle : nullen) {
            zelle.zeichen = Integer.toString(zelle.bombenInNachbarschaft);
        }
    }

    @objid ("d576208c-655d-4a94-a1a6-1a5f29e1b72c")
    public void beschrifteZellenZwischenNullUndBombe(List<Zelle> nullen) {
        // beschrifte alle Nachbarzellen aus der Liste Nullen mit den Werten 
        // aus zelle.bombeinnachbarschaft
        // Das heisst f�r jede Zelle gilt ein anderer Schl�ssel welche Nachbarzellen
        // zu pr�fen sind, wie bei Methode beschrifteNachbarzellenZuBomben
        // TODO da dieses vorgehen bereits einmal angwendet wird bei beschrifteNachbarzellenZuBomben, 
        // dessen methode so anpassen, dass diese f�r beide F�lle geht!
        
        // Notiz: Ablauf der Auswahl, welche Kriterien sind bei beiden Methoden gleich, wo unterscheiden Sie sich?
        // Beide haben eine Liste von Zellen welche abgearbeitet werden m�ssen.
        // bei beiden muss dann entsprechend der aktuellen Zelle, alle Benachbarten Zellen gefunden werden und diese manipuliert werden.
        // Die Manipulation ist aber nicht mehr dieselbe bei beiden.
        // Einmal m�ssen die Bomben in der Nachbarschaft gefunden werden bzw. die Anzahl der Bomben in Nachbarschaft aktualisiert werden
        // Ein andermal muss die Information ob die Nachbarzellen an Bomben angrenzen nun in das Feld .zeichen �bertragen werden
        // Anders ausgedr�ckt, bei beiden muss Anhand einer Zelle alle Nachbarzellen gefunden werden und diese aber unterschiedlich manipuliert werden.
        // Wie m�sste nun das Codeger�st dazu aussehen?
        
        // Listentyp muss gleich sein, Momentan ist es einmal ein int Array und einemal eine Liste vom Typ Zelle
        // Die Liste kann aber schlecht in ein Array umgewandelt werden weil diese dynamisch ist, d.h. dessen Anzahl ist bei Erstellung unbekannt
        // D.h. ist es m�glich und Sinnvoll den int Array in eine Liste zu wechseln?
        // das wechseln zur Liste ist kein problem nur das anpassen der Funktionen welche sich auf das Array beziehen umzustellen auf eine Liste...
        // wie kann nachgeschaut werden welche Methoden das int Array benutzen?
        
        for (Zelle zelle : nullen) {
        
            switch (waehleVariante(zelle)) {
            case 1:
                NullObenLinks(zelle);
                break;
            case 2:
                NullObenMitte(zelle);
                break;
            case 3:
                NullObenRechts(zelle);
                break;
            case 4:
                NullMitteLinks(zelle);
                break;
            case 5:
                NullMitteMitte(zelle);
                break;
            case 6:
                NullMitteRechts(zelle);
                break;
            case 7:
                NullUntenLinks(zelle);
                break;
            case 8:
                NullUntenMitte(zelle);
                break;
            case 9:
                NullUntenRechts(zelle);
                break;
        
            default:
                break;
            }
        }
    }

    @objid ("f47dc93e-72bf-4319-9718-ef7142ef1338")
    public void NullUntenRechts(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
    }

    @objid ("78d4f7f8-210b-4a19-a2e0-279d5b3fea0e")
    public void NullUntenMitte(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
        zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
    }

    @objid ("631f0061-875f-49f0-9f0c-e3f424fe3cb5")
    public void NullUntenLinks(Zelle zelle) {
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
    }

    @objid ("b4cdd8f3-ea23-4250-9ddd-5c350a668c8a")
    public void NullMitteRechts(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
        zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);
    }

    @objid ("0c7cee93-ab66-4cdb-a6ef-bf36da610521")
    public void NullMitteMitte(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleObenLinks().zeichen = Integer.toString(zelle.zelleObenLinks().bombenInNachbarschaft);
        zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);    
        zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
        zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
    }

    @objid ("3f35f70f-62eb-477f-af42-996640db4893")
    public void NullMitteLinks(Zelle zelle) {
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleOben().zeichen = Integer.toString(zelle.zelleOben().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleObenRechts().zeichen = Integer.toString(zelle.zelleObenRechts().bombenInNachbarschaft);
        zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
    }

    @objid ("09aa2fb6-ca86-4885-8504-666efa4a8da2")
    public void NullObenRechts(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);
    }

    @objid ("8fd5c9bc-6666-42c3-b5d9-cc557580a12d")
    public void NullObenMitte(Zelle zelle) {
        zelle.zelleLinks().zeichen = Integer.toString(zelle.zelleLinks().bombenInNachbarschaft);
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleUntenLinks().zeichen = Integer.toString(zelle.zelleUntenLinks().bombenInNachbarschaft);    
        zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
    }

    @objid ("b6767ed9-e17b-4325-8c1d-adb55726d615")
    public void NullObenLinks(Zelle zelle) {
        zelle.zelleRechts().zeichen = Integer.toString(zelle.zelleRechts().bombenInNachbarschaft);
        zelle.zelleUnten().zeichen = Integer.toString(zelle.zelleUnten().bombenInNachbarschaft);
        zelle.zelleUntenRechts().zeichen = Integer.toString(zelle.zelleUntenRechts().bombenInNachbarschaft);
    }

    @objid ("9e4456f0-edbd-43e2-a013-f27dff0631ce")
    public void kreuzSuche() {
    }

}
