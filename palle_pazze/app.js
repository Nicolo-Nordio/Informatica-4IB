const canvas = document.getElementById('mycanvas');

const ctx = canvas.getContext('2d');

const w = canvas.width;
const h = canvas.height;

// Definizione della classe Circle
class Circle {
    constructor(x, y, r, color, vx, vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
        this.vx = vx;
        this.vy = vy;
    }

    draw() {
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.r, 0, 2 * Math.PI);
        ctx.fillStyle = this.color;
        ctx.fill();
        ctx.closePath();
    }

    update() {
        this.x += this.vx;
        this.y += this.vy;

        // Gestione degli urti con i bordi del canvas
        if (this.x + this.r > w || this.x - this.r < 0) {
            this.vx = -this.vx;
        }
        if (this.y + this.r > h || this.y - this.r < 0) {
            this.vy = -this.vy;
        }
    }

    checkCollision(other) {
        let dx = other.x - this.x;
        let dy = other.y - this.y;
        let distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < this.r + other.r) {
            // Unisce i colori dei cerchi in collisione
            this.color = mergeColor(this.color, other.color);
            other.color = this.color;

            // Calcola l'angolo di collisione tra i due cerchi
            let angle = Math.atan2(dy, dx);

            // Calcola le velocità iniziali dei due cerchi
            let speed1 = Math.sqrt(this.vx * this.vx + this.vy * this.vy);
            let speed2 = Math.sqrt(other.vx * other.vx + other.vy * other.vy);

            let direction1 = Math.atan2(this.vy, this.vx);  // Direzione della velocità del cerchio corrente
            let direction2 = Math.atan2(other.vy, other.vx);  // Direzione della velocità dell'altro cerchio

            // Ruota le velocità in modo che siano allineate con l'asse di collisione
            let vx1 = speed1 * Math.cos(direction1 - angle);
            let vy1 = speed1 * Math.sin(direction1 - angle);
            let vx2 = speed2 * Math.cos(direction2 - angle);
            let vy2 = speed2 * Math.sin(direction2 - angle);

            // Calcola le nuove velocità dopo la collisione utilizzando le formule di conservazione della quantità di moto
            let final_vx1 = ((this.r - other.r) * vx1 + (2 * other.r) * vx2) / (this.r + other.r);
            let final_vx2 = ((2 * this.r) * vx1 + (other.r - this.r) * vx2) / (this.r + other.r);

            // Aggiorna le velocità dei cerchi considerando la direzione dell'angolo di collisione
            this.vx = Math.cos(angle) * final_vx1 + Math.cos(angle + Math.PI / 2) * vy1;
            this.vy = Math.sin(angle) * final_vx1 + Math.sin(angle + Math.PI / 2) * vy1;
            other.vx = Math.cos(angle) * final_vx2 + Math.cos(angle + Math.PI / 2) * vy2;
            other.vy = Math.sin(angle) * final_vx2 + Math.sin(angle + Math.PI / 2) * vy2;

            return true;
        }
        return false;
    }
}

// Creazione array di colori rgb (rosso, verde, blu, giallo)
let colors = ['255,0,0', '0,255,0', '0,0,255', '255,255,0'];

const positionX = w / 4;
const positionY = h / 4;

const rad = 35; //radius della palla

// Creazione dei cerchi
let circles = [
    new Circle(positionX, positionY, rad, `rgb(${colors[0]})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(3 * positionX, positionY, rad, `rgb(${colors[1]})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(positionX, 3 * positionY, rad, `rgb(${colors[2]})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(3 * positionX, 3 * positionY, rad, `rgb(${colors[3]})`, Math.random() * 2 - 1, Math.random() * 2 - 1)
];

function mergeColor(color1, color2) {
    // Parse the RGB values from the input strings
    const r1 = parseInt(color1.split(',')[0]);
    const g1 = parseInt(color1.split(',')[1]);
    const b1 = parseInt(color1.split(',')[2]);
    const r2 = parseInt(color2.split(',')[0]);
    const g2 = parseInt(color2.split(',')[1]);
    const b2 = parseInt(color2.split(',')[2]);

    // Calculate the average RGB values of the two input colors
    const rAvg = (r1 + r2) / 2;
    const gAvg = (g1 + g2) / 2;
    const bAvg = (b1 + b2) / 2;

    // Return the new merged color as a string in the format "rgb(r, g, b)"
    return `rgb(${rAvg}, ${gAvg}, ${bAvg})`;
}


// Funzione di aggiornamento
function update() {
    // Pulisci il canvas
    ctx.clearRect(0, 0, w, h);

    for (let circle of circles) {
        circle.update();
        circle.draw();
    }
    requestAnimationFrame(update);

    // Controlla se ci sono collisioni tra le palle
    for (let i = 0; i < circles.length; i++) {
        for (let j = i + 1; j < circles.length; j++) {
            circles[i].checkCollision(circles[j])
        }
    }
}

let usedColors = [];

function getRandomColor() {
    if (colors.length === 0) {
        // Se l'array dei colori è vuoto, significa che sono stati utilizzati tutti i colori
        return null;
    }

    // Ottieni un colore random e rimuovilo dall'array
    let randomIndex = Math.floor(Math.random() * colors.length);
    let randomColor = colors.splice(randomIndex, 1)[0];

    usedColors.push(randomColor);

    return randomColor;
}

function restart() {
    // Riaggiungi i colori utilizzati nuovamente all'array dei colori
    colors = colors.concat(usedColors);

    // Svuota l'array dei colori usati
    usedColors = [];

    // Resetta i cerchi e assegna colori random
    circles = [
        new Circle(positionX, positionY, rad, `rgb(${getRandomColor()})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(3 * positionX, positionY, rad, `rgb(${getRandomColor()})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(positionX, 3 * positionY, rad, `rgb(${getRandomColor()})`, Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(3 * positionX, 3 * positionY, rad, `rgb(${getRandomColor()})`, Math.random() * 2 - 1, Math.random() * 2 - 1)
    ];
}

update();
