function lines(size) {
    var lines = '';
    for (var row=1; row<=size ; row++) {
        var line = '<tr>';
        for (var column=1; column<=size; column++) {
            line += '<td class="empty" id="cell-'+ row + 'x' + column + '"></td>';
        }
        line += '</tr>';
        lines += line;
    }
    return lines;
}

function displayGrid() {
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

var module = module || {};

module.exports.displayGrid = displayGrid;
module.exports.lines = lines;
module.exports.load = load;
