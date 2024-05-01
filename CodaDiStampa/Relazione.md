#### Classi:

1. `Main`: Questa è la classe principale che contiene il metodo `main`. Genera una coda di stampa prioritaria (`PriorityPrintQueue`) e una serie di file di testo casuali con pesi casuali utilizzando la classe `FileTesto`. I file vengono poi aggiunti alla coda di stampa in base al loro peso. Infine, vengono stampati i contenuti dei file in ordine di priorità nella coda di stampa.

2. `FileTesto`: Questa classe rappresenta un file di testo. Ha la capacità di leggere, scrivere e chiudere il file. È utilizzata dalla classe `PriorityPrintQueue` per rappresentare i file che devono essere stampati.

3. `PriorityPrintQueue`: Questa classe implementa una coda di stampa prioritaria. I file vengono inseriti e rimossi in base al loro peso, in modo che i file più pesanti abbiano una priorità più alta. La classe utilizza la classe `FileTesto` per rappresentare i file all'interno della coda di stampa.

#### Funzionamento:

1. La classe `Main` genera una coda di stampa (`printQueue`) e alcuni file di testo casuali. Ogni file di testo è associato a un peso casuale e viene aggiunto alla coda di stampa in base al proprio peso.

2. I file vengono stampati dalla coda di stampa in ordine di priorità. Il contenuto di ciascun file viene aggiunto a un nuovo file di testo denominato "PriorityPrint.txt" insieme a un'indicazione del suo peso.

3. La classe `PriorityPrintQueue` gestisce l'aggiunta e la rimozione dei file di testo in base alla loro priorità. Utilizza il concetto di una lista collegata per mantenere i file ordinati per peso.

4. La classe `FileTesto` si occupa della scrittura, lettura e chiusura dei file di testo. Viene utilizzata per rappresentare ciascun file all'interno della coda di stampa.
