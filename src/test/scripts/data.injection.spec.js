var load = require('../../main/webapp/js/load');
var jsdom = require('jsdom').jsdom;

var lines = require('../../main/webapp/js/minesweeper').lines;

describe('Data injection challenge', function() {

    it('calls for a load method', function() {
        expect(typeof load).toEqual('function');
    });

    it('load data in grid from document.grid', function() {
        document = jsdom('<html><head></head><body><table id="grid">'+ lines(2) +'</table></body></html>');
        document.grid = [ ['bomb', 'empty' ], ['empty', 'empty' ] ];
        load();

        expect(document.getElementById('cell-1x1').attributes['class']).toEqual('bomb');
    });
});