# Documentazione del Codice - Palle Pazze

Il seguente codice implementa un'applicazione di animazione nel canvas HTML, chiamata "Palle Pazze". L'applicazione presenta un insieme di sfere colorate che si muovono all'interno di un canvas, rimbalzando contro i bordi e reagendo alle collisioni tra di loro.

## Struttura del Codice

### Classe `Circle`

La classe `Circle` rappresenta una sfera nel canvas, con proprietà come posizione, raggio, colore e velocità lungo gli assi x e y. La classe include metodi per disegnare la sfera, aggiornare la sua posizione, gestire i rimbalzi sui bordi del canvas e verificare le collisioni con altre sfere.

#### Metodi Principali:

- `draw()`: Disegna la sfera sul canvas.
- `update()`: Aggiorna la posizione della sfera in base alla sua velocità e gestisce i rimbalzi sui bordi del canvas.
- `checkCollision(other)`: Verifica se la sfera corrente collide con un'altra sfera (`other`) e gestisce la collisione.

### Funzioni di Supporto

#### Funzione `getRandomColor()`

Questa funzione restituisce un colore casuale dalla lista predefinita di colori, garantendo che i colori non si ripetano.

#### Funzione `restart()`

La funzione `restart()` reimposta lo stato dell'applicazione. Ricrea le sfere e reinizializza i colori in modo casuale senza ripetizioni.

### Funzione Principale `update()`

La funzione `update()` è responsabile dell'aggiornamento continuo delle posizioni delle sfere nel canvas. Ogni frame, le sfere vengono spostate, disegnate e le collisioni vengono verificate e gestite.

## Principi Fisici delle Collisioni

Le collisioni tra le sfere sono gestite secondo i principi fisici delle collisioni elastiche. Quando due sfere collidono, vengono calcolate le nuove velocità delle sfere coinvolte basate sulla conservazione della quantità di moto e l'angolo di collisione.

L'implementazione delle leggi fisiche nelle collisioni assicura un comportamento realistico e dinamico delle sfere all'interno del canvas.

L'uso delle funzioni trigonometriche, come `Math.atan2`, è essenziale per calcolare angoli e direzioni nelle collisioni e garantire un corretto aggiornamento delle velocità delle sfere coinvolte.