// URL del mock server
const BASE_URL = 'http://localhost:3000';

const dropdown = document.getElementById('surname-dropdown');
const dataDiv = document.getElementById('anagrafici-data');

// Caricare i cognomi nel menù a tendina
fetch(`${BASE_URL}/people`)
    .then((response) => response.json())
    .then((people) => {
        const surnames = new Set();
        people.forEach((person) => {
            surnames.add(person.surname);
        });

        surnames.forEach((surname) => {
            const option = document.createElement('option');
            option.value = surname;
            option.textContent = surname;
            dropdown.appendChild(option);
        });
    });

// Ascoltare il cambiamento di selezione del menù a tendina
dropdown.addEventListener('change', (event) => {
    const selectedSurname = event.target.value;

    if (selectedSurname === '') {
        dataDiv.innerHTML = 'Seleziona un cognome';
        return;
    }

    // Richiedere i dati anagrafici della persona selezionata
    fetch(`${BASE_URL}/people?surname=${selectedSurname}`)
        .then((response) => response.json())
        .then((people) => {
            if (people.length === 0) {
                dataDiv.innerHTML = 'Nessun dato trovato';
            } else {
                const person = people[0];
                dataDiv.innerHTML = `
                <p>Nome: ${person.name}</p> 
                <p>Età: ${person.age}</p>
                <p>Città: ${person.city}</p>
                `;
            }
        });
});