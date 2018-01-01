/*
    DOMEquality unit tests

    Tests:
    1.Check areEqual(element1, element2) method
 */


QUnit.test("declare DOMEquality instance", function( assert ) {
    var _DOMEquality = new DOMEquality.DOMEquality();

    assert.ok(_DOMEquality !== null 
        && _DOMEquality !==undefined
        ,"DOMEquality instance is declared");
});
QUnit.test("test DOMEquality areEqual(element1, element2) method", function( assert ) {

    var areEqual = new DOMEquality.DOMEquality().areEqual;
    var mockElem1 = document.createElement("div").appendChild("img");
    // var mockElemDiv1 = document.createElement("");  

{/* <div>
<img/>
<span/>
<div>
<img/>
</div>
</div> */}

{/* <div>
<img/>
<img/>
<span>
<div/>
</span>
</div> */}

    assert.ok( areEqual(mockElem1,mockElem2) === true 
        ,"DOMEquality instance is declared");
});