var displayGrid = require('../../main/webapp/js/minesweeper');
var cheerio = require('cheerio');
var jsdom = require('jsdom').jsdom;

describe('Minesweeper', function() {

    it('contains 8x8 cells', function() {
        document = jsdom('<table id="grid"></table>');
        displayGrid();


        var size = 8;
        for (var row=1; row<= size ; row++) {
            for (var column=1; column<=size; column++) {
                var cellId = 'cell-'+ row + 'x' + column;
                expect(document.getElementById(cellId)).not.toEqual(null);
            }
        }
    });
});