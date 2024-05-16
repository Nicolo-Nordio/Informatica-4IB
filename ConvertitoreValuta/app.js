// URL del mock server
const BASE_URL = 'http://localhost:3000';

const dropdownSx = document.getElementById("dropdown-sx");
const dropdownDx = document.getElementById("dropdown-dx");
const input = document.getElementById("v-inserita").value;
const output = document.getElementById("v-convertita").value;
const convertitore = document.getElementById("conversione");
let tassoConversione1 = 0;
let tassoConversione2 = 0;

// Caricare le sigle delle valute nel menù a tendina
fetch(`${BASE_URL}/listaValute`)
    .then((response) => response.json())
    .then((listaValute) => {
        const sigle = new Set();
        listaValute.forEach((valuta) => {
            sigle.add(valuta.sigla);
        });

        sigle.forEach(sigla => {
            const option = document.createElement('option');
            option.value = sigla;
            option.textContent = sigla;
            dropdownSx.appendChild(option);
        });
    });

// Ascoltare il cambiamento di selezione del menù a tendina a sx
dropdownSx.addEventListener('change', (event) => {
    const selectedSigla = event.target.value;
    // Richiedere  della persona selezionata
    fetch(`${BASE_URL}/listaValute?sigla=${selectedSigla}`)
        .then((response) => response.json())
        .then((listaValute) => {
            if (listaValute.length == 0) {
                alert("Nessuna lista è stata trovata");
            } else {
                const valuta = listaValute[0];
                tassoConversione1 = valuta.tasso;
            }
        });
});

// Ascoltare il cambiamento di selezione del menù a tendina a dx
dropdownDx.addEventListener('change', (event) => {
    const selectedSigla = event.target.value;
    // Richiedere  della persona selezionata
    fetch(`${BASE_URL}/listaValute?sigla=${selectedSigla}`)
        .then((response) => response.json())
        .then((listaValute) => {
            if (listaValute.length == 0) {
                alert("Nessuna lista è stata trovata");
            } else {
                const valuta = listaValute[0];
                tassoConversione2 = valuta.tasso;
            }
        });
});

convertitore.addEventListener("click", () => {
    output = (input * tassoConversione1) / tassoConversione2;
});