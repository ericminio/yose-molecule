var jsdom = require('jsdom').jsdom;

var minesweeper = require('../../main/webapp/js/minesweeper');
var displayGrid = minesweeper.displayGrid;

describe('Minesweeper', function() {

    it('contains 8x8 cells', function() {
        document = jsdom('<table id="grid"></table>');
        displayGrid(document);

        var size = 8;
        for (var row=1; row<= size ; row++) {
            for (var column=1; column<=size; column++) {
                var cellId = 'cell-'+ row + 'x' + column;
                expect(document.getElementById(cellId)).not.toEqual(null);
            }
        }
    });

    describe('cell', function() {

        var cell = jsdom('<span ' + minesweeper.cell(3, 4) + ' />')
                                  .getElementById('cell-3x4');

        it('has the expected id', function() {
            expect(cell).not.toEqual(null);
        });

        it('is empty by default', function() {
            expect(cell.attributes['class'].value).toEqual('empty');
        });

        it('lets clients decide the tag hosting the cell', function() {
            expect(cell.tagName).toEqual('SPAN');
        });
    });
});