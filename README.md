# Assignment 9
Prima versione del file .yml per le pipeline di gitlab.
Provato jacoco e i la coverage di Intellij.

# Estensioni su jitpack
Ho aggiunto la parte di gestione delle estensioni pubblicate su maven local con l'utilizzo di jitpack.
Siccome il mio è un repo privato,
ho dovuto seguire le istruzioni sulla doc di jitpack per dare l'accesso a jitpack al mio repo privato,
utilizzando uno scambio di token tra gitlab e jitpack.
Commit per verificare che l'esecuzione della pipeline funzioni.

# Piccole correzioni
Rimosse le estensioni dalla modulo di test, rimaste ancora dalla prima versione in cui provavo le estensioni.

Spostate le classi di test che erano finite fuori da qualsiasi package (non so bene il motivo, intellij ad un certo punto mi ha dato qualche problema).

Non utilizzo le mie estensioni pubblicate su mavenLocal per via delle pipeline che altrimenti fallirebbero, quindi utilizzo le estensioni del prof importate come definito nel build.gradle
