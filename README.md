# Schulprojekt JAVA ZF
## Eclipse Projekt auf GitHub bringen
Voraussetzung
*Bestehendes Eclipse Projekt
*Projekt ist offen
*(Git vorhanden in Eclipse) Standard?

### Schritte in Eclipse
1. Projekt im Package Explorer mit rechter Maustaste anklicken
2. Team > Share Project..
3. Im Fenster 'Configure Git Repository' unter Repository > Create wählen:
4. Pfad angeben bzw. Ordner erstellen (Browse > create folder): C:\Users\deinUsername\git\Projektname (C:\Users\deinUsername\git Standard Git Ordner Win10?), (ganzes Projekt wird in diesen Ordner verschoben?), (dies ist jetzt ein lokales Git Repository)
### Schritte Github
5. Unter www.GitHub.org ein neues Projekt erstellen
6. Erhaltener GitHub Projektpfad kopieren (Bsp. https://github.com/gihubusername/neuesProjekt.git)
### Wieder in Eclipse
8. Git Ansicht des Projektes öffnen > wieder rechter Mausklick auf Eclipse Projekt > Team > Show in Repository View (Erkennung > Projektname [NO-HEAD]
9. In dieser Git Repositories Ansicht > Projekbaum Ordner Remotes suchen und rechte Maustaste: deinEclipseProjekt > Remotes > create Remote > remotre Name > origin
10. Im Fenster 'Configure push for remote 'origin'' bei URI auf 'Change...' und den Projektpfad mit Git-Dateiendung einfügen (siehe 6.): https://github.com/gihubusername/neuesProjekt.git
11. Kontrolle ob Protokoll https und Username / Passwort von GitHub eingetragen > Finish
12. 'Save and Push'
13. Bier trinken! Bravo!
