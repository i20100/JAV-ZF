package mod226_10.badexample;

import java.util.Scanner;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("b0363b5d-32a8-415e-a52c-015c741a85e8")
public class MinesweeperBadExample {
  private final Scanner scanner = new Scanner(System.in);
  private final Spielfeld spielfeld = new Spielfeld();

  public static void main(String[] args) {
    MinesweeperBadExample minesweeper = new MinesweeperBadExample();
    minesweeper.spielen();
  }

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

  private void zeigeSpielfeld() {}
  private void zeigeEingabeaufforderung() {}
  private void zeigeFehlermeldung() {}
  private void zeigeSchlussmeldung() {}
  private boolean spielLaeuft() {}
}
