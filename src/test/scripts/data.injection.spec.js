var jsdom = require('jsdom').jsdom;
var minesweeper = require('../../main/webapp/js/minesweeper');

var lines = minesweeper.lines;
var load = minesweeper.load;

describe('Data injection challenge', function() {

    it('calls for a load method', function() {
        expect(typeof load).toEqual('function');
    });

    it('load data in grid from document.grid', function() {
        document = jsdom('<table id="grid">'+ lines(2) +'</table>');
        document.grid = [ ['bomb', 'empty' ], ['empty', 'bomb' ] ];
        load();

        expect(document.getElementById('cell-1x1').attributes['class'].value).toEqual('bomb');
        expect(document.getElementById('cell-1x2').attributes['class'].value).toEqual('empty');
        expect(document.getElementById('cell-2x2').attributes['class'].value).toEqual('bomb');
        expect(document.getElementById('cell-2x1').attributes['class'].value).toEqual('empty');
    });
});