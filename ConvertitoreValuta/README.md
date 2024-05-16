Realizzare una applicazione web in grado di operare il cambio tra due valute.

I dati relativi alle valute e alle informazioni di cambio sono forniti da un mock server in grado di fornire le informazioni: sigla valuta, nome della valuta, tasso di cambio in euro e nome file che contiene la bandiera del paese.

L’applicazione deve consentire di selezionare qualsiasi coppia di valute ed ottenere per un dato importo il valore nella valuta di destinazione. Per convertire una valuta in un’altra valuta è necessario passare per la conversione in euro visto che nel file json è presente solamente in tasso di cambio in euro.

Esempio di conversione:
Si vogliono cambiare 120 dollari USA in franchi svizzeri quindi si passa dai dollari agli euro e poi dagli euro ai franchi.
Nel file json troviamo:
il tasso di cambio in euro del dollaro:  1 dollaro = 0,92831 euro
il tasso di cambio in euro del franco svizzero: 1 franco = 1,02399 euro

convertiamo:
120 dollari = 120 * 0,92831 = 111,3972 euro
111,3972 euro / 1,02399  = 108,7874 franchi

In definitiva:    120 USD = 108,7874 CHF