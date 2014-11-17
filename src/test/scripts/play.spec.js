var jsdom = require('jsdom').jsdom;
var minesweeper = require('../../main/webapp/js/minesweeper');
var playCell = minesweeper.playCell;

describe('The game', function() {

    var document = jsdom('<span ' + minesweeper.cell(3, 4) + ' />');
    var cell = document.getElementById('cell-3x4');

    it('is lost when the player plays on a bomb', function() {
        cell.attributes['class'].value = 'bomb';
        playCell(cell.id, document);

        expect(cell.attributes['class'].value).toEqual('lost');
    });

    it('continues when the player plays on an empty cell', function() {
        cell.attributes['class'].value = 'empty';
        playCell(cell.id, document);

        expect(cell.attributes['class'].value).toEqual('empty');
    });
});