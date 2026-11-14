JARVIS AI – Android-Projekt

Dies ist eine erste installierbare Android-Prototyp-App. Sie bietet:
- dunkle JARVIS-Oberfläche
- Spracheingabe per Taste (Android-Spracherkennung, Deutsch)
- Sprachausgabe über die auf dem Handy gewählte Android-TTS-Stimme
- lokales Notiz-Gedächtnis

Noch NICHT enthalten:
- echtes KI-Sprachmodell / ChatGPT-ähnliche Antworten
- dauerhaftes Wake Word „Hey JARVIS“
- zuverlässige Hintergrund-Mikrofonüberwachung bei gesperrtem Bildschirm
- vollständige Android-Gerätesteuerung

APK online bauen (ohne eigenen PC):
1. Ein GitHub-Konto öffnen/erstellen.
2. Dieses ZIP entpacken und den gesamten Projektordner in ein neues GitHub-Repository hochladen.
3. Im Repository den Reiter „Actions“ öffnen.
4. Den Workflow „Build JARVIS AI APK“ auswählen und „Run workflow“ drücken.
5. Nach Abschluss den Eintrag „JARVIS-AI-debug-APK“ unter Artifacts herunterladen.
6. ZIP entpacken und app-debug.apk auf dem Samsung installieren.
   Android kann nachfragen, ob Installationen aus dieser Quelle erlaubt werden sollen.

Hinweis:
- Das Projekt benötigt Android SDK / Gradle für den Build. Die GitHub-Actions-Datei erledigt das online.
- Die APK ist eine Debug-Testversion. Sie ist nicht im Play Store veröffentlicht.
- Für eine öffentliche/produktive App braucht es weitere Tests, Signierung und Datenschutz-/Mikrofonhinweise.
