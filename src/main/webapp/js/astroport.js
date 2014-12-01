function Docker() {}

Docker.prototype.dock = function(document) {
    var field = document.getElementById("ship");
    var gate = document.getElementById("gate-1");
    var ship = document.getElementById("ship-1");
    var undock = document.getElementById("undock-1");

    gate.className = "occupied gate"
    ship.innerHTML = field.value;
    undock.className = "";
    field.value = "";
}

Docker.prototype.undock = function(document) {
    var gate = document.getElementById("gate-1");
    var ship = document.getElementById("ship-1");
    var undock = document.getElementById("undock-1");

    gate.className = "free gate";
    ship.innerHTML = "-- None --";
    undock.className = "hidden";
}