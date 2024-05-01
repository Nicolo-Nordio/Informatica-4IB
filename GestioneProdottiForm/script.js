let prodotti = [];

function showProducts() {
    let productList = document.getElementById('product-list');
    productList.innerHTML = '';
    prodotti.forEach((prodotto) => {
        productList.innerHTML += `<li>Categoria: ${prodotto.categoria}, Codice: ${prodotto.codice}, Nome: ${prodotto.nome}, Descrizione: ${prodotto.descrizione}, Prezzo: ${prodotto.prezzo}€, Magazzino: ${prodotto.magazzino} </li>`;
    });
}

function saveProduct() {
    let categoria = document.getElementById('category').value;
    let codice = document.getElementById('codice').value;
    if (codice != null) {
        let nome = document.getElementById('nome').value;
        let descrizione = document.getElementById('descrizione').value;
        let prezzo = document.getElementById('prezzo').value;
        if (prezzo === null || prezzo < 0) prezzo = 0;
        let sconto;
        try{
            sconto  = document.querySelector('input[name = "sconto"]:checked').value;
        } catch(InvalidOperationException){
            sconto = 0;
        }
        prezzo = prezzo - (prezzo * sconto / 100); //Applicazione dello sconto
        let magazzino = false;
        if (document.getElementById('in-stock').checked) magazzino = true;
        prodotti.push({categoria: categoria, codice: codice, nome: nome, descrizione: descrizione, prezzo: prezzo, magazzino: magazzino});
        showProducts();
    } else {
        alert('Non hai inserito il codice');
    }
}