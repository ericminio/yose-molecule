function displayGrid($) {
    var table = $('#grid');
    table.append(lines(8));
}

function lines(size) {
    var lines = '';
    for (var row=1; row<=size ; row++) {
        var line = '<tr>';
        for (var column=1; column<=size; column++) {
            line += '<td id="cell-'+ row + 'x' + column + '"></td>';
        }
        line += '</tr>';
        lines += line;
    }
    return lines;
}

var module = module || {};
module.exports = displayGrid;
module.exports.lines = lines;
