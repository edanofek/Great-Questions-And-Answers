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

    // Mock Elem 1
    /* <div>
    <img/>
    <span/>
    <div>
    <img/>
    </div>
    </div> */

    // Mock Elem 2
    /* <div>
    <img/>
    <img/>
    <span>
    <div/>
    </span>
    </div> */

    var areEqual = new DOMEquality.DOMEquality().areEqual;
    
    var mockElemDiv1 = document.createElement("div");
    mockElemDiv1.appendChild("img");  
    mockElemDiv1.appendChild("span");  
    mockElemDiv1.appendChild("div").appendChild("img");

    var mockElemDiv2 = document.createElement("div");
    mockElemDiv2.appendChild("img");
    mockElemDiv2.appendChild("img");
    mockElemDiv2.appendChild("span").appendChild("div");

    var mockElemDiv3 = document.createElement("div").appendChild("span");

    assert.equal(areEqual(mockElemDiv1,mockElemDiv2),true ,"are equal method is true for elem 1,elem 2");
    assert.ok(areEqual(mockElem1,mockElemDiv3), false ,"are equal method is false for elem 1,elem 3");
});