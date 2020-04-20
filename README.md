# Kata
Prima versione dell'esercizio birthday kata.
Le implementazioni dei "collaborators" non contengono di per sè una vera e propria implentazione;
in ogni test di ogni collaborators infatti viene mockata la logica.
E' stato abbastanza difficile capire fino a che livello mockare e tutt'ora non sono al 100% sicura di aver rispettato tutte le consegne.
Non è ancora presente il controllo sulla data del 29 febbraio.
#Miglioramenti
Aggiunta del controllo sulla data 29 febbraio in birthdayService.
Aggiunto un primo test relativo del quale non garantisco in quanto ho dovuto aggiungere un controllo if al momento del mock del metodo findEmployeesBornOn ma non penso sia giusto siccome nei test non si dovrebbero inserire condizioni.
