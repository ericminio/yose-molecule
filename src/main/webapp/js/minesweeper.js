function displayGrid($) {
    var table = $('#grid');

    for (var row=1; row<=8 ; row++) {
        var line = '<tr>';
        for (var column=1; column<=8; column++) {
            line += '<td id="cell-'+ row + 'x' + column + '"></td>';
        }
        line += '</tr>';
        table.append(line);
    }
}

module.exports = displayGrid;
