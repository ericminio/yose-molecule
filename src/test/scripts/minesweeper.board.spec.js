var displayGrid = require('../../main/webapp/js/minesweeper');
var cheerio = require('cheerio');

describe('Minesweeper', function() {

    it('contains 8x8 cells', function() {
        var $ = cheerio.load('<table id="grid"></table>');
        displayGrid($);

        for (var row=1; row<=8 ; row++) {
            for (var column=1; column<=8; column++) {
                expect($('#cell-'+ row + 'x' + column).length).toEqual(1);
            }
        }
    });
});