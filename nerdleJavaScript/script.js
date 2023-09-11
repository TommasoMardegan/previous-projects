
var operazioni = [
  ['1', '+', '5', '+', '5', '=', '1', '1'],
  ['2', '+', '4', '+', '6', '=', '1', '2'],
  ['3', '*', '4', '-', '2', '=', '1', '0'],
  ['2', '4', '/', '2', '4', '=', '0', '1'],
  ['3', '*', '7', '-', '3', '=', '1', '9'],
  ['8', '*', '9', '/', '3', '=', '2', '4'],
  ['5', '2', '*', '5', '=', '2', '6', '0'],
];
var tentativi = 6;
var soluzioni = [];

var indiceRandom = Math.floor(Math.random() * operazioni.length);
var operazione = operazioni[indiceRandom];
var soluzione = evaluateExpression(operazione.slice(0, operazione.length - 3));
soluzione = soluzione.toString();
operazione[operazione.length - 2] = soluzione.charAt(0);
operazione[operazione.length - 1] = soluzione.charAt(1);
soluzioni.push(operazione);
  window.addEventListener('load', function() {
    generaEquazione();
  });
  
  function generaEquazione() {
    tenativi = 6;
    var tabella = document.getElementById('board');
    tabella.innerHTML = '';
  
    for (var i = 0; i < soluzioni.length; i++) {
      var row = document.createElement('div');
      row.classList.add('riga');
  
      for (var j = 0; j < soluzioni[i].length; j++) {
        var input = document.createElement('input');
        input.type = 'text';
        input.classList.add('cella');
        input.maxLength = 1;
        row.appendChild(input);
      }
  
      tabella.appendChild(row);
    }
  }
  
  function controllaSoluzione() {
    tentativi--;
    var righe = document.getElementsByClassName('riga');
  
    for (var i = 0; i < righe.length; i++) {
      var celle = righe[i].getElementsByClassName('cella');
      var inputArray = [];
  
      for (var j = 0; j < celle.length; j++) {
        var valore = celle[j].value.trim();
        inputArray.push(valore);
      }
      var soluzione = soluzioni[i];
  
      if (arraysEqual(inputArray, soluzione)) {
        markCells(celle, ['green', 'green', 'green', 'green', 'green', 'green', 'green', 'green']);
        alert('Complimenti! Hai risolto il nerdle');
      } else {
        var feedback = getFeedback(inputArray, soluzione);
        markCells(celle, feedback);
        alert("tentativi rimasti:" + tentativi)
        if(tentativi == 0) {
          alert("hai perso! riprova un altro giorno");
          generatePuzzle();
        }
      }
    }
  }
  
  function evaluateExpression(inputArray) {
    var espressione = inputArray.join('');
    return eval(espressione);
  }
  
  function markCells(celle, feedback) {
    for (var i = 0; i < celle.length; i++) {
      celle[i].style.backgroundColor = feedback[i];
    }
  }
  
  function getFeedback(inputArray, soluzione) {
    var feedback = [];
  
    for (var i = 0; i < inputArray.length; i++) {
      var input = inputArray[i];
      var correct = soluzione[i];
  
      if (input === correct) {
        feedback.push('green');
      } else if (soluzione.includes(input)) {
        feedback.push('purple');
      } else {
        feedback.push('black');
      }
    }
  
    return feedback;
  }
  
  function arraysEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) {
      return false;
    }
  
    for (var i = 0; i < arr1.length; i++) {
      if (arr1[i] !== arr2[i]) {
        return false;
      }
    }
  
    return true;
  }