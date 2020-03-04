var obj, x, txt = "";
obj = JSON.parse('{ "name":"John", "age":30, "city":"New York"}');

txt += "<table border='1'>"
for (x in obj) {
  txt += "<tr><td>" + obj[x] + "</td></tr>";
}
txt += "</table>"
document.getElementById("demo").innerHTML = txt;
  