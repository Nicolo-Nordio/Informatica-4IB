// URL del mock server
const BASE_URL = 'http://localhost:3000';

const dropdownSx = document.getElementById("dropdown-sx");
const dropdownDx = document.getElementById("dropdown-dx");
const input = document.getElementById("v-inserita");
const output = document.getElementById("v-convertita");
const convertitore = document.getElementById("convertitore");
const imgSx = document.getElementById("img-sx");
const imgDx = document.getElementById("img-dx");
let tassoConversione1 = 0;
let tassoConversione2 = 0;

// Caricare le sigle delle valute nel menù a tendina a sx
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

// Caricare le sigle delle valute nel menù a tendina a dx
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
            dropdownDx.appendChild(option);
        });
    });

// Ascoltare il cambiamento di selezione del menù a tendina a sx
dropdownSx.addEventListener('change', (event) => {
    const selectedSigla = event.target.value;
    // Richiedere sigla della valuta selezionata
    fetch(`${BASE_URL}/listaValute?sigla=${selectedSigla}`)
        .then((response) => response.json())
        .then((listaValute) => {
            if (listaValute.length == 0) {
                alert("Nessuna lista è stata trovata!");
            } else {
                const valuta = listaValute[0];
                tassoConversione1 = valuta.tasso;
                imgSx.src = valuta.img;
            }
        });
});

// Ascoltare il cambiamento di selezione del menù a tendina a dx
dropdownDx.addEventListener('change', (event) => {
    const selectedSigla = event.target.value;
    // Richiedere sigla della valuta selezionata
    fetch(`${BASE_URL}/listaValute?sigla=${selectedSigla}`)
        .then((response) => response.json())
        .then((listaValute) => {
            if (listaValute.length == 0) {
                alert("Nessuna lista è stata trovata!");
            } else {
                const valuta = listaValute[0];
                tassoConversione2 = valuta.tasso;
                imgDx.src = valuta.img;
            }
        });
});

// Gestione del button 'Converti'
convertitore.addEventListener("click", () => {
    const inputValue = parseFloat(input.value);
    if (!isNaN(inputValue) && tassoConversione1 && tassoConversione2) {
        const outputValue = ((inputValue * tassoConversione1) / tassoConversione2);
        output.value = outputValue.toFixed(2); //Arrotonda a 2 cifre decimali
    } else {
        alert("Inserisci un valore valido e/o seleziona le valute.");
    }
});
