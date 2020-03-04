let source = new EventSource("http://localhost:8080/console3");
source.onmessage = function (event) {
  let txt = "";
  let obj = JSON.parse(event.data);
  for (let x in obj) {
    txt += "<tr><td>" + x + "</td><td>" + obj[x] + "</td></tr>";
  }
  document.getElementById("tabela").innerHTML = txt;
}