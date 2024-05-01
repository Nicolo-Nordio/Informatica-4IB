document.addEventListener('DOMContentLoaded', function () {
    const app = Vue.createApp({
        data() {
            return {
                prodotti: [],
                prodotto: {
                    categoria: "",
                    codice: "",
                    nome: "",
                    descrizione: "",
                    prezzo: "",
                    sconto: "",
                    magazzino: false
                }
            };
        },
        methods: {
            saveProduct() {
                if (!this.prodotto.categoria) {
                    alert('Selezionare una categoria prima di salvare il prodotto');
                    return;
                }
                if (this.nome === null) {
                    alert('Inserire un nome prima di salvare il prodotto');
                    return;
                }
                if (this.prezzo === null) {
                    alert('Inserire un prezzo prima di salvare il prodotto');
                    return;
                }
                if (!this.prodotto.codice) {
                    alert('Inserire un codice alfanumerico prima di salvare il prodotto');
                    return;
                }

                this.prodotto.prezzo = parseFloat(this.prodotto.prezzo);
                this.prodotto.prezzo -= (this.prodotto.prezzo * this.prodotto.sconto / 100);

                this.prodotti.push({ ... this.prodotto }); //Inserisco nell'array una copia di this.prodotto per evitare problemi
            },
            deleteProduct(index) {
                this.prodotti.splice(index, 1);
            },
            deleteAll() {
                this.prodotti.splice(0, this.prodotti.length);
            },
            clearForm() {
                this.prodotto.categoria = "";
                this.prodotto.codice = "";
                this.prodotto.nome = "";
                this.prodotto.descrizione = "";
                this.prodotto.prezzo = "";
                this.prodotto.sconto = "";
                this.prodotto.magazzino = false;
            }
        }
    });

    app.mount('#app');
});