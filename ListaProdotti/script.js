let prodotti = [];

function showProducts() {
    let productList = document.getElementById('product-list');
    productList.innerHTML = '';
    prodotti.forEach((prodotto) => {
        productList.innerHTML += `<p>Codice: ${prodotto.codice}, Nome: ${prodotto.nome}, Descrizione: ${prodotto.descrizione}, Prezzo: ${prodotto.prezzo}</p>`;
    });
}

function addProduct() {
    let codice = prompt("Inserisci il codice del prodotto");
    let nome = prompt("Inserisci il nome del prodotto");
    let descrizione = prompt("Inserisci la descrizione del prodotto");
    let prezzo = prompt("Inserisci il prezzo del prodotto");
    prodotti.push({ codice, nome, descrizione, prezzo });
    showProducts();
}

function deleteProduct() {
    let codice = prompt("Inserisci il codice del prodotto da rimuovere");
    prodotti = prodotti.filter(prodotto => prodotto.codice !== codice);
    showProducts();
}

function sortProducts() {
    prodotti.sort((a, b) => a.nome.localeCompare(b.nome));
    showProducts();
}
