/*
    DOMEquality unit tests

    Tests:
    1.Check areEqual(element1, element2) method {output : true,false}
 */


QUnit.test("declare DOMEquality instance", function( assert ) {
    
    var _DOMEqualityES5 = new DOMEqualityES5.DOMEqualityES5();

    assert.ok(_DOMEqualityES5 !== null 
        && _DOMEqualityES5 !==undefined
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

    var areEqual = new DOMEqualityES5.DOMEqualityES5();
    var buildHolderTAGSDS = new DOMEqualityES5.DOMEqualityES5();
    
    
    var mockElemDiv1 = document.createElement("div");
    mockElemDiv1.appendChild(document.createElement("img"));  
    mockElemDiv1.appendChild(document.createElement("span"));  
    mockElemDiv1.appendChild(document.createElement("div")).appendChild(document.createElement("img"));

    var mockElemDiv2 = document.createElement("div");
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("span")).appendChild(document.createElement("div"));

    var mockElemDiv3 = document.createElement("div").appendChild(document.createElement("span"));

    var HolderTAGSDS1 = Object.create(null),HolderTAGSDS2 = Object.create(null);
    buildHolderTAGSDS.buildHolderTAGSDS(mockElemDiv1,HolderTAGSDS1);
    buildHolderTAGSDS.buildHolderTAGSDS(mockElemDiv2,HolderTAGSDS2);

    // console.info(HolderTAGSDS1);
    // console.info(HolderTAGSDS2);
    

    assert.equal(areEqual(mockElemDiv1,mockElemDiv2),true ,"are equal method is true for elem 1,elem 2");
    assert.ok(areEqual(mockElem1,mockElemDiv3), false ,"are equal method is false for elem 1,elem 3");
});