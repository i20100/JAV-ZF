package mod226_10.badexample;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import mod226_10.mineswepfinal.Spielfeld;

@objid ("b0363b5d-32a8-415e-a52c-015c741a85e8")
public class MinesweeperBadExample {
    @objid ("fd01fe8b-5dc1-454f-b02d-474fb7462c90")
    private final Scanner scanner = new Scanner(System.in);

    @objid ("34e50a0e-4822-4e25-9ad8-e64b9ccafee0")
    private final Spielfeld spielfeld = new Spielfeld();

    @objid ("1598c4c9-d519-4cc0-ac7a-d313e0e6dcd2")
    public static void main(String[] args) {
        MinesweeperBadExample minesweeper = new MinesweeperBadExample();
        minesweeper.spielen();
    }

    @objid ("2de3af34-7500-484e-b233-0c7240484121")
    private void spielen() {
        do {
          zeigeSpielfeld();
          zeigeEingabeaufforderung();
          String[] eingabeTeile;
          do {
            String eingabe = scanner.nextLine();
            eingabeTeile = eingabe.split(" ");
            if (istGueltig(eingabeTeile))
              break;
            else
              zeigeFehlermeldung();
          } while (true);
          int zeile = Integer.valueOf(eingabeTeile[1]);
          int spalte = Integer.valueOf(eingabeTeile[2]);
          switch (eingabeTeile[0]) {
          case "T":
            spielfeld.aufdecken(spalte, zeile);
            break;
          case "M":
            spielfeld.markieren(spalte, zeile);
            break;
          }
        } while (spielLaeuft());
        zeigeSpielfeld();
        zeigeSchlussmeldung();
    }

    @objid ("fdc9c4df-12fa-43dd-85b6-1d5436b5bf4b")
    private boolean istGueltig(String[] eingabeTeile) {
        if (eingabeTeile.length != 3)
          return false;
        if (!eingabeTeile[0].equals("T") && !eingabeTeile[0].equals("M"))
          return false;
        try {
          Integer.valueOf(eingabeTeile[1]);
          Integer.valueOf(eingabeTeile[2]);
        } catch (NumberFormatException e) {
          return false;
        }
        return true;
    }

    @objid ("e94a2999-48e4-4156-bf03-00b2f0759c02")
    private void zeigeSpielfeld() {
    }

    @objid ("7134513f-ba64-4c23-be12-3d8ec6cc1f8b")
    private void zeigeEingabeaufforderung() {
    }

    @objid ("f09adb32-e737-4091-ad3b-4722aa67adb8")
    private void zeigeFehlermeldung() {
    }

    @objid ("5b1d9a8e-6738-4683-89b8-b7a67932529d")
    private void zeigeSchlussmeldung() {
    }

    @objid ("a7a8746c-a7e9-43ba-866e-44eb8909cbaf")
    private boolean spielLaeuft() {
        return false;
    }

}
