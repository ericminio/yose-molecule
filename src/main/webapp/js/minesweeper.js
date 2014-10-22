function displayGrid() {
    var table = document.getElementById('grid');

    var row = table.insertRow(0);

    row.insertCell(0).id = 'cell-1x1';
    row.insertCell(0).id = 'cell-8x8';
    row.insertCell(0).id = 'cell-2x3';
}
