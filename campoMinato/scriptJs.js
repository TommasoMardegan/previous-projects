//per indicazione:
//var txt2 = $("<p></p>").text("ciao"); Creare con jQuery
//$("h2").hide(); select con jQuery
//(no <>)
class Campo {
	constructor(righeIn, colonneIn) {
		//costruttore campo
		this.campo = [];
		//dimensioni del campo
		this.RIGHE = righeIn;
		this.COLONNE = colonneIn;
		this.NUM_MINE = 0;
	}
	Vinci() {
		alert("hai vinto!");
		//metodo per svuotare la pagina prima di generare un campo nuovo
		window.location.reload();
		this.generaCampo();
	}
	generaCampo(numeroMine) {
		let numeroCelle = this.RIGHE*this.COLONNE;
		if(numeroMine > numeroCelle) {
			alert("troppe mine!");
		}
		else {
			this.NUM_MINE = numeroMine;
		// Crea il campo di gioco
		for (var i = 0; i < this.RIGHE; i++) {
		  //imposto il campo[i] come un vettore vuoto
		  this.campo[i] = [];
		  //creo la riga a cui fare l'append successivamente (senza classe)
		  var riga = $("<tr></tr>");
		  for (var j = 0; j < this.COLONNE; j++) {
			//creo la cella con i 3 parametri da assegnare agli attributi
			let cellaTmp = new Cella(false, false, false);
			//la metto nel campo
			this.campo[i][j] = cellaTmp;
			//creazione della cella di classe cell:
			var cella = $("<td class='cell'><td>");
			//posizione della cella in righe (come attributo)
			cella.attr("data-rig", i);
			//pos. della cella in colonne
			cella.attr("data-col", j);
			//append alla riga della cella
			riga.append(cella);
		  }
		  //append al campo della riga
		  $("#campoGioco").append(riga);
		}
		this.piazzaMine();
		}	
	}
	piazzaMine() {
		let nriga, ncolonna;
		for(let contMine = 0; contMine < this.NUM_MINE; contMine++) {
			nriga = Math.floor(Math.random() * this.RIGHE);
			ncolonna = Math.floor(Math.random() * this.COLONNE);
			while(this.campo[nriga][ncolonna].hasMine == true) {
				nriga = Math.floor(Math.random() * this.RIGHE);
				ncolonna = Math.floor(Math.random() * this.COLONNE);
			}
			this.campo[nriga][ncolonna].hasMine = true;
		}
	}
	//metodo quando clicco su una cella
	clickCella(CellaSel) {		
		//prendo il numero della riga della cella selezionata
		var rigaTmp = parseInt($(CellaSel).attr("data-rig"));
		//prendo il numero della colonna della cella selezionata
		var colTmp = parseInt($(CellaSel).attr("data-col"));
		//se la cella del campo a quella posizione ha una mina:
		if (this.campo[rigaTmp][colTmp].hasMine == true && this.campo[rigaTmp][colTmp].isRevealed == false) {
			alert("Hai perso!");
			//reload della pagine
			window.location.reload();
			//rigenero il campo
			this.generaCampo();
		} else if(this.campo[rigaTmp][colTmp].hasMine == false) {
			this.campo[rigaTmp][colTmp].isRevealed = true;
			// Mostra il numero di mine adiacenti
			var count = 0;
			//andra dalla riga subito inferiore a quella subito superiore
			for (var i = rigaTmp - 1; i <= rigaTmp + 1; i++) {
				//andrà dalla colonna a sinistra di quella selezionata a quella a destra
				for (var j = colTmp - 1; j <= colTmp + 1; j++) {
					//controllo che dove sto cercando la mina sia nella tabella (caso in cui sono ad esempio nell'ultima colonna)
					//e se la cella ha la mina:
					if (i >= 0 && i < this.RIGHE && j >= 0 && j < this.COLONNE && this.campo[i][j].hasMine) {
						//aumento il contatore
						count++;
					}
				}
			}
			//sulla cella selezionata imposto il testo a count
			$(CellaSel).text(count);
			//cambio il css della cella
			$(CellaSel).addClass("selezionata");
		}
	}
	//cambio il text della cellaSel
	flagga(CellaSel) {
		//prendo il numero della riga della cella selezionata
		var rigaTmp = parseInt($(CellaSel).attr("data-rig"));
		//prendo il numero della colonna della cella selezionata
		var colTmp = parseInt($(CellaSel).attr("data-col"));
		//controllo se la cella è già stata rivelata
		if (!this.campo[rigaTmp][colTmp].isRevealed) {
			//aggiungo la flag alla cella
			$(CellaSel).text("!");
			//aggiorno il flag della cella
		    this.campo[rigaTmp][colTmp].isFlagged = true;
			this.campo[rigaTmp][colTmp].isRevealed = true;
			//controllo se tutte le mine sono state flaggate
			var countFlag = 0;
			for (var i = 0; i < this.RIGHE; i++) {
				for (var j = 0; j < this.COLONNE; j++) {
					if (this.campo[i][j].hasMine && this.campo[i][j].isFlagged) {
						countFlag++;
					}
				}
			}
			if (countFlag == this.NUM_MINE) {
				this.Vinci();
			}
		}
	}
}
class Cella {
	//costruttore
	constructor(_hasMine, _isRevealed, _isFlagged) {
		this.hasMine = _hasMine; 
		this.isRevealed = _isRevealed,
		this.isFlagged = _isFlagged;
	}
}