function Docker() {}

Docker.prototype.dock = function(document) {
    var field = document.getElementById("ship");
    var gate = document.getElementById("gate-1");
    var ship = document.getElementById("ship-1");
    var info = document.getElementById("info");
    var infoClasses = info.className;

    gate.className = "occupied gate"
    ship.innerHTML = field.value;
    field.value = "";
    info.className = infoClasses.replace('hidden', '');
}

function hideInfo() {
    var info = document.getElementById("info");

    if (info.className.indexOf('hidden') === -1) {
        info.className = info.className + ' hidden';
    }
}