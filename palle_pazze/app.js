// Creazione dell'elemento canvas e impostazione delle dimensioni
let canvas = document.createElement('canvas');
let w = window.innerWidth * 0.8; // 80% della larghezza della finestra
let h = window.innerHeight * 0.8; // 80% dell'altezza della finestra
canvas.width = w;
canvas.height = h;
document.body.appendChild(canvas);

let ctx = canvas.getContext('2d');

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
            // Calcola l'angolo di collisione
            let angle = Math.atan2(dy, dx);

            // Calcola le nuove velocità utilizzando le funzioni trigonometriche
            let speed1 = Math.sqrt(this.vx * this.vx + this.vy * this.vy);
            let speed2 = Math.sqrt(other.vx * other.vx + other.vy * other.vy);

            let direction1 = Math.atan2(this.vy, this.vx);
            let direction2 = Math.atan2(other.vy, other.vx);

            let vx1 = speed1 * Math.cos(direction1 - angle);
            let vy1 = speed1 * Math.sin(direction1 - angle);
            let vx2 = speed2 * Math.cos(direction2 - angle);
            let vy2 = speed2 * Math.sin(direction2 - angle);

            let final_vx1 = ((this.r - other.r) * vx1 + (other.r + other.r) * vx2) / (this.r + other.r);
            let final_vx2 = ((this.r + this.r) * vx1 + (other.r - this.r) * vx2) / (this.r + other.r);

            // Aggiorna le velocità dei cerchi
            this.vx = Math.cos(angle) * final_vx1 + Math.cos(angle + Math.PI / 2) * vy1;
            this.vy = Math.sin(angle) * final_vx1 + Math.sin(angle + Math.PI / 2) * vy1;
            other.vx = Math.cos(angle) * final_vx2 + Math.cos(angle + Math.PI / 2) * vy2;
            other.vy = Math.sin(angle) * final_vx2 + Math.sin(angle + Math.PI / 2) * vy2;
        }
    }

}

// Creazione dei cerchi
let circles = [
    new Circle(w / 4, h / 4, 50, 'red', Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(3 * w / 4, h / 4, 50, 'yellow', Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(w / 4, 3 * h / 4, 50, 'green', Math.random() * 2 - 1, Math.random() * 2 - 1),
    new Circle(3 * w / 4, 3 * h / 4, 50, 'blue', Math.random() * 2 - 1, Math.random() * 2 - 1)
];

// Funzione di aggiornamento
function update() {
    ctx.clearRect(0, 0, w, h);
    for (let circle of circles) {
        circle.update();
        circle.draw();
    }
    requestAnimationFrame(update);

    for (let i = 0; i < circles.length; i++) {
        for (let j = i + 1; j < circles.length; j++) {
            circles[i].checkCollision(circles[j]);
        }
    }
}

let button = document.createElement('button');
button.textContent = 'Resetta';
button.style.display = 'block';
button.addEventListener('click', () => {
    // Resetta i cerchi
    circles = [
        new Circle(w / 4, h / 4, 50, 'red', Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(3 * w / 4, h / 4, 50, 'yellow', Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(w / 4, 3 * h / 4, 50, 'green', Math.random() * 2 - 1, Math.random() * 2 - 1),
        new Circle(3 * w / 4, 3 * h / 4, 50, 'blue', Math.random() * 2 - 1, Math.random() * 2 - 1)
    ];
});
document.body.appendChild(button);

update();
