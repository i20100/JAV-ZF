package mod226_09;

import java.util.Scanner;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@objid ("0c8fce55-1566-486c-b50c-86569d0965dd")
class EingabeKommandoTest {
    @objid ("d54da73c-c843-4e62-b57b-946785e39571")
    @Test
    @DisplayName("testLiesBenutzerEingabe")
    void testLiesBenutzerEingabe() {
        String benutzerEingabe = "M25";
        Scanner scanner = new Scanner(benutzerEingabe);
        EingabeKommando ek = new EingabeKommando();
        ek.liesBenutzerEingabe();
        assertEquals(benutzerEingabe, ek.getBenutzerEingabe());
        scanner.close();
    }

    @objid ("14b72c01-38b7-45b0-b7d1-1abef2e63ef8")
    @AfterAll
    public static void teardown() {
        System.exit(0);
    }

}
