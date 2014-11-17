function cell(row, column) {
    return 'onclick="playCell(this.id, document);" class="empty" id="cell-' + row + 'x' + column + '"';
}

function lines(size) {
    var lines = '';
    for (var row=1; row<=size ; row++) {
        var line = '<tr>';
        for (var column=1; column<=size; column++) {
            line += '<td ' + cell(row, column) + ' />';
        }
        line += '</tr>';
        lines += line;
    }
    return lines;
}

function displayGrid(document) {
    var table = document.getElementById('grid');
    table.innerHTML = lines(8);
}

function load() {
    var size = document.grid.length;
    for (var row=1; row<=size ; row++) {
        for (var column = 1; column <= size; column++) {
            if (document.grid[row-1][column-1] == 'bomb') {
                var cellId = 'cell-'+ row + 'x' + column;
                document.getElementById(cellId).attributes['class'].value = 'bomb';
            }
        }
    }
}

function playCell(id, document) {
    var classes = document.getElementById(id).attributes['class'];
    if (classes.value == 'bomb') {
        classes.value = 'lost';
    }
}

var module = module || { exports: {} };

module.exports.displayGrid = displayGrid;
module.exports.lines = lines;
module.exports.load = load;
module.exports.cell = cell;
module.exports.playCell = playCell;
