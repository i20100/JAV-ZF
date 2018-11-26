# Schulprojekt JAVA Zwischenfach
## Struktur der Module
* MOD226A - Modul A aus 226 - ThemenSchwerpunkt?
* MOD226B - Modul B aus 226 - ???

## Eclipse Projekt auf GitHub bringen
### Voraussetzung und Ablauf
* Kenntnisse Git (empfohlen mindestens Git Tutorial durchgespielt, siehe https://git-scm.com/docs/gittutorial)
* GitHub Benutzer vorhanden
* GitHub Projekt erstellen
* GitHub Projekt clonen auf lokalen Rechner (ins lokale git Standardverzeichnis) Vorteil beim clonen, git remote gesetzt (Link auf origin wird automatisch gesetzt)
* Eclipse Projekt erstellen bzw. transferieren in lokalen git clone
* git add .
* git commit
* git pull request oder push

### Alte Vorgehensweise, nicht mehr empfohlen:
Voraussetzung
- Bestehendes Eclipse Projekt
- Projekt ist offen
- (Git vorhanden in Eclipse) Standard

#### Schritte in Eclipse
1. Projekt im Package Explorer mit rechter Maustaste anklicken
2. Team > Share Project..
3. Im Fenster 'Configure Git Repository' unter Repository > Create wählen:
4. Pfad angeben bzw. Ordner erstellen (Browse > create folder): C:\Users\deinUsername\git\Projektname (C:\Users\deinUsername\git Standard Git Ordner Win10?), (ganzes Projekt wird in diesen Ordner verschoben?), (dies ist jetzt ein lokales Git Repository)
#### Schritte Github
5. Unter www.GitHub.org ein neues Projekt erstellen
6. Erhaltener GitHub Projektpfad kopieren (Bsp. https://github.com/githubusername/neuesProjekt.git)
#### Wieder in Eclipse
8. Git Ansicht des Projektes öffnen > wieder rechter Mausklick auf Eclipse Projekt > Team > Show in Repository View (Erkennung > Projektname [NO-HEAD]
9. In dieser Git Repositories Ansicht > Projekbaum Ordner Remotes suchen und rechte Maustaste: deinEclipseProjekt > Remotes > create Remote > remotre Name > origin
10. Im Fenster 'Configure push for remote 'origin'' bei URI auf 'Change...' und den Projektpfad mit Git-Dateiendung einfügen (siehe 6.): https://github.com/githubusername/neuesProjekt.git
11. Kontrolle ob Protokoll https und Username / Passwort von GitHub eingetragen > Finish
12. 'Save and Push'
13. Bier trinken! Bravo!
14. Was Fehler erhalten?
#### Eclipse Git Commit
16. Klar gibt es einen Fehler Pushen geht nur wenn es etwas zu pushen gibt.
17. Also erstmal commit machen auf Dateien!
18. Push nochmal versuchen. Klappt. Gehe wieder zu Punkt 13.

## altes Eclipseprojekt von GitHub wieder in Eclipse oeffnen
1. Wenn lokaler Klone nicht besteht, GitHub Projekt klonen in lokalen git Ordner.
2. Eclipse Projekt Wizard benutzen um Projekt zu finden. **Achtung bei Multi Eclipse oder git Projekten, siehe Egit.md**
