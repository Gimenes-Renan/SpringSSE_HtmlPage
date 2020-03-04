if (typeof (EventSource) !== "undefined") {
    let source = new EventSource("http://localhost:8080/console2");
    source.onmessage = function (event) {
        document.getElementById("thread2").innerHTML = event.data + "<br>";
    };
} else {
    document.getElementById("result").innerHTML = "Sorry, your browser does not support server-sent events...";
}