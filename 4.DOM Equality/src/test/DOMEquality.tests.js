/*
    DOMEquality unit tests
 */



QUnit.test("declare DOMEquality instance", function( assert ) {
    var _DOMEquality = new DOMEquality.DOMEquality();

    assert.ok(_DOMEquality !== null 
        && _DOMEquality !==undefined
        ,"DOMEquality instance is declared");
});
