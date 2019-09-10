var num = 0;
var state;

function moveWords() {
  var elem = document.getElementById("animate");
  var pos = 0;
  var id = setInterval(frame, 7);
  function frame() {
    if (pos == 350) {
      clearInterval(id);
    } else {
      pos++;
      elem.style.top = pos + "px";
      elem.style.left = pos + "px";
    }
  }
}

function add() {
  var result;
  var num1 = Number(document.calc.num1.value);
  var num2 = Number(document.calc.num2.value);

  result = num1 + num2;
  alert(result);
}

function sub() {
  var result;
  var num1 = Number(document.calc.num1.value);
  var num2 = Number(document.calc.num2.value);

  result = num1 - num2;
  alert(result);
}

function div() {
  var result;
  var num1 = Number(document.calc.num1.value);
  var num2 = Number(document.calc.num2.value);

  if(num2 == 0){
    alert("Cannot divide by zero!!! Try again!")
  } else {
    result = num1/num2;
    alert(result);
  }
}
function mul() {
  var result;
  var num1 = Number(document.calc.num1.value);
  var num2 = Number(document.calc.num2.value);

  result = num1 * num2;
  alert(result);
}

function clickCount() {
  state = setInterval(count, 1000);;
}

function count() {
   document.getElementById("counter").innerHTML = num;
   num++;
}
