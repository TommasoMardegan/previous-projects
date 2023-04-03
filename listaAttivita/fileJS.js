class Attivita {
    constructor(check, data, descrizione) {
        this.descrizione = descrizione;
        this.data = data;
        this.check = false;
    }
}
class GestioneAttivita {
    constructor() {
        this.indexAttivita = 1;
        this.listaAttivita = new Array();
        this.modificaAtt = false;
        this.indiceModifica = 0;
    }
    aggiungi(attivita) {
        if(this.modificaAtt == true) {
            this.listaAttivita[this.indiceModifica-1] = attivita;
            document.getElementById("descAttivita" + this.indiceModifica).innerHTML = attivita.descrizione;
            document.getElementById("dataAttivita" + this.indiceModifica).innerHTML = attivita.data.getDate() + "/" + parseInt(attivita.data.getMonth()+1) + "/" + attivita.data.getFullYear();
            document.getElementById("ch" + this.indiceModifica).style.display = "block";
            document.getElementById("ch" + this.indiceModifica).checked = false;
            document.getElementById("canc" + this.indiceModifica).style.display = "block";
            document.getElementById("descAttivita" + this.indiceModifica).style.textDecoration = null;
            document.getElementById("dataAttivita" + this.indiceModifica).style.textDecoration = null;
            document.getElementById("mod"+this.indiceModifica).style.display="block";
            document.getElementById("mod"+this.indiceModifica).value = "";
            let dataOdierna = new Date();
            if(dataOdierna.getMonth() == this.listaAttivita[this.indiceModifica-1].data.getMonth()) {
                if(this.listaAttivita[this.indiceModifica-1].data.getDate() - dataOdierna.getDate() < 7) {
                    document.getElementById("descAttivita" + this.indiceModifica).style.color = "red";
                }
                else {
                    document.getElementById("descAttivita" + this.indiceModifica).style.color = "orange";
                }
            }
            else {
                document.getElementById("descAttivita" + this.indiceModifica).style.color = "green";
            }
            this.modificaAtt = false;
            this.indiceModifica = 0;
            document.getElementById("aggiungiAttività").value = "Aggiungi";
        }
        else {
            this.listaAttivita.push(attivita);
            console.log(attivita.descrizione);
            console.log(attivita.data);
            console.log(this.indexAttivita);
            document.getElementById("descAttivita" + this.indexAttivita).innerHTML = attivita.descrizione;
            document.getElementById("dataAttivita" + this.indexAttivita).innerHTML = attivita.data.getDate() + "/" + parseInt(attivita.data.getMonth()+1) + "/" + attivita.data.getFullYear();
            document.getElementById("ch" + this.indexAttivita).style.display = "block";
            document.getElementById("ch" + this.indexAttivita).checked = false;
            document.getElementById("canc" + this.indexAttivita).style.display = "block";
            document.getElementById("descAttivita" + this.indexAttivita).style.textDecoration = null;
            document.getElementById("dataAttivita" + this.indexAttivita).style.textDecoration = null;
            document.getElementById("mod"+this.indexAttivita).style.display="block";
            let dataOdierna = new Date();
            if(dataOdierna.getMonth() == this.listaAttivita[this.indexAttivita-1].data.getMonth()) {
                if(this.listaAttivita[this.indexAttivita-1].data.getDate() - dataOdierna.getDate() < 7) {
                    document.getElementById("descAttivita" + this.indexAttivita).style.color = "red";
                }
                else {
                    document.getElementById("descAttivita" + this.indexAttivita).style.color = "orange";
                }
            }
            else {
                document.getElementById("descAttivita" + this.indexAttivita).style.color = "green";
            }
            this.indexAttivita++;
        }
    }
    elimina(indice) {
        console.log(indice);
        document.getElementById("descAttivita" + indice).innerHTML = "";
        document.getElementById("dataAttivita" + indice).innerHTML = "";
        document.getElementById("ch" + indice).style.display = "none";
        document.getElementById("canc" + indice).style.display = "none";
        document.getElementById("mod" + indice).style.display = "none";
        this.listaAttivita.splice(indice-1, 1);
        this.indexAttivita--;
        //se elimina il primo non sposta gli altri quindi 3 sara ancora 3 e non 2
        for(let i = 0; i < this.listaAttivita.length; i++) {
            let indiceId = i+1;
            document.getElementById("descAttivita" + indiceId).innerHTML = this.listaAttivita[i].descrizione;
            document.getElementById("dataAttivita" + indiceId).innerHTML = this.listaAttivita[i].data.getDate() + "/" + parseInt(this.listaAttivita[i].data.getMonth()+1) + "/" + this.listaAttivita[i].data.getFullYear();;
            document.getElementById("ch" + indiceId).style.display = "block";
            document.getElementById("ch" + indiceId).check = this.listaAttivita[i].check;
            document.getElementById("canc" + indiceId).style.display = "block";
            document.getElementById("mod" + indiceId).style.display =  "block";
            let dataOdierna = new Date();
            if(dataOdierna.getMonth() == this.listaAttivita[i].data.getMonth()) {
                if(this.listaAttivita[i].data.getDate() - dataOdierna.getDate() < 7) {
                    document.getElementById("descAttivita" + indiceId).style.color = "red";
                }
                else {
                    document.getElementById("descAttivita" + indiceId).style.color = "orange";
                }
            }
            else {
                document.getElementById("descAttivita" + indiceId).style.color = "green";
            }
        }
        //tmp
        document.getElementById("descAttivita" + this.indexAttivita).innerHTML = "";
        document.getElementById("dataAttivita" + this.indexAttivita).innerHTML = "";
        document.getElementById("ch" + this.indexAttivita).style.display = "none";
        document.getElementById("canc" + this.indexAttivita).style.display = "none";
        document.getElementById("mod" + this.indexAttivita).style.display = "none";
    }
    completa(indice) {
        if(document.getElementById("ch" + indice).checked == false) {
            document.getElementById("descAttivita" + indice).style.textDecoration = null;
            document.getElementById("dataAttivita" + indice).style.textDecoration = null;
            document.getElementById("ch" + indice).checked = false;
            this.listaAttivita[indice-1].check = false;
        }
        else {
            document.getElementById("descAttivita" + indice).style.textDecoration = "line-through";
            document.getElementById("dataAttivita" + indice).style.textDecoration = "line-through";
            document.getElementById("ch" + indice).checked = true;
            this.listaAttivita[indice-1].check = true;
        }   
    }
    visualizzaCompletate() {
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            if(this.listaAttivita[i-1].check == false) {
                document.getElementById("descAttivita" + i).innerHTML = "";
                document.getElementById("dataAttivita" + i).innerHTML = "";
                document.getElementById("ch" + i).style.display = "none";
                document.getElementById("canc" + i).style.display = "none";
                document.getElementById("mod" + i).style.display = "none";
            }
            else {
                document.getElementById("descAttivita" + i).innerHTML = this.listaAttivita[i-1].descrizione;
                document.getElementById("dataAttivita" + i).innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
                document.getElementById("ch" + i).style.display = "block";
                document.getElementById("canc" + i).style.display = "block";
                document.getElementById("mod" + i).style.display = "block";
            }
        }
    }
    visualizzaNonCompletate() {
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            if(this.listaAttivita[i-1].check == true) {
                document.getElementById("descAttivita" + i).innerHTML = "";
                document.getElementById("dataAttivita" + i).innerHTML = "";
                document.getElementById("ch" + i).style.display = "none";
                document.getElementById("canc" + i).style.display = "none";
                document.getElementById("mod" + i).style.display = "none";
            }
            else {
                document.getElementById("descAttivita" + i).innerHTML = this.listaAttivita[i-1].descrizione;
                document.getElementById("dataAttivita" + i).innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
                document.getElementById("ch" + i).style.display = "block";
                document.getElementById("canc" + i).style.display = "block";
                document.getElementById("mod" + i).style.display = "block";
            }
        }
    }
    visualizzaTutte() {
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            document.getElementById("descAttivita" + i).innerHTML = this.listaAttivita[i-1].descrizione;
            document.getElementById("dataAttivita" + i).innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
            document.getElementById("ch" + i).style.display = "block";
            document.getElementById("canc" + i).style.display = "block";
            document.getElementById("mod" + i).style.display = "block";
        }
    }
    mostraUrgenti() {
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            let dataOdierna = new Date();
            if(this.listaAttivita[i-1].data.getDate() - dataOdierna.getDate() > 3) {
                document.getElementById("descAttivita" + i).innerHTML = "";
                document.getElementById("dataAttivita" + i).innerHTML = "";
                document.getElementById("ch" + i).style.display = "none";
                document.getElementById("canc" + i).style.display = "none";
                document.getElementById("mod" + i).style.display = "none";
            }
            else {
                document.getElementById("descAttivita" + i).innerHTML = this.listaAttivita[i-1].descrizione;
                document.getElementById("dataAttivita" + i).innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
                document.getElementById("ch" + i).style.display = "block";
                document.getElementById("canc" + i).style.display = "block";
                document.getElementById("mod" + i).style.display = "block";
            }
        }
    }
    nascondiUrgenti() {
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            let dataOdierna = new Date();
            if(this.listaAttivita[i-1].data.getDate() - dataOdierna.getDate() <= 3) {
                document.getElementById("descAttivita" + i).innerHTML = "";
                document.getElementById("dataAttivita" + i).innerHTML = "";
                document.getElementById("ch" + i).style.display = "none";
                document.getElementById("canc" + i).style.display = "none";
                document.getElementById("mod" + i).style.display = "none";
            }
            else {
                document.getElementById("descAttivita" + i).innerHTML = this.listaAttivita[i-1].descrizione;
                document.getElementById("dataAttivita" + i).innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
                document.getElementById("ch" + i).style.display = "block";
                document.getElementById("canc" + i).style.display = "block";
                document.getElementById("mod" + i).style.display = "block";
            }
        }
    }
    ordinaPerScadenza() {
        for(let i =1; i < this.listaAttivita.length+1;i++) { 
            for(let i2 = 1; i2 < this.listaAttivita.length+1; i2++) {
                if(i2 < this.indexAttivita-1) {
                    if(this.listaAttivita[i2-1].data > this.listaAttivita[i2].data) {
                        let tmp = this.listaAttivita[i2-1];
                        this.listaAttivita[i2-1] = this.listaAttivita[i2];
                        this.listaAttivita[i2] = tmp;
                    }
                }
            }
        }
        for(let i =1; i < this.listaAttivita.length+1;i++) {
            document.getElementsByClassName("da")[i-1].innerHTML = this.listaAttivita[i-1].data.getDate() + "/" + parseInt(this.listaAttivita[i-1].data.getMonth()+1) + "/" + this.listaAttivita[i-1].data.getFullYear();
            document.getElementsByClassName("ds")[i-1].innerHTML = this.listaAttivita[i-1].descrizione;
            document.getElementById("ch"+i).style.display = "block";
            document.getElementById("ch" + i).check = this.listaAttivita[i-1].check;
            document.getElementById("canc"+i).style.display = "block";
            document.getElementById("mod" + i).style.display = "block";
        }
    }
    modifica(indiceMod) {
        document.getElementById("aggiungiAttività").value = "modifica";
        this.modificaAtt = true;
        this.indiceModifica = indiceMod;
    }
    controllaMNO() {
        let lista = document.getElementById("sl");
        let testo =  lista[lista.selectedIndex].text;
        if(testo == "mostra urgenti") {
            this.mostraUrgenti();
        }
        else if(testo == "nascondi urgenti") {
            this.nascondiUrgenti();
        }
        else if(testo == "ordina per scadenza"){
            this.ordinaPerScadenza();
        }
    }
}