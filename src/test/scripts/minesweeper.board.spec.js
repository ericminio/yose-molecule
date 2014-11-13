var jsdom = require('jsdom').jsdom;

var minesweeper = require('../../main/webapp/js/minesweeper');
var displayGrid = minesweeper.displayGrid;

describe('Minesweeper', function() {

    var size = 8;

    beforeEach(function() {
        document = jsdom('<table id="grid"></table>');
        displayGrid();
    });

    it('contains 8x8 cells', function() {
        for (var row=1; row<= size ; row++) {
            for (var column=1; column<=size; column++) {
                var cellId = 'cell-'+ row + 'x' + column;
                expect(document.getElementById(cellId)).not.toEqual(null);
            }
        }
    });

    it('cells are empty by default', function() {
        for (var row=1; row<= size ; row++) {
            for (var column=1; column<=size; column++) {
                var cellId = 'cell-'+ row + 'x' + column;
                expect(document.getElementById(cellId).attributes['class'].value).toEqual('empty');
            }
        }
    });
});