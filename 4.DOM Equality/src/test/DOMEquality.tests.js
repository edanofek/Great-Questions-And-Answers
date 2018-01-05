/*
    DOMEquality unit tests

    Tests:
    1.test areEqual(element1, element2) method {output : true,false} method
    2.test equalElements(element) method {output : [[elem1, elem2],...]}
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

    var mockElemDiv1 = document.createElement("div");
    mockElemDiv1.appendChild(document.createElement("img"));  
    mockElemDiv1.appendChild(document.createElement("span"));  
    mockElemDiv1.appendChild(document.createElement("div")).appendChild(document.createElement("img"));
    
    var mockElemDiv2 = document.createElement("div");
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("span")).appendChild(document.createElement("div"));
    
    var mockElemDiv3 = document.createElement("div").appendChild(document.createElement("span"));

    var areEqual = new DOMEqualityES5.DOMEqualityES5();
    
    var HolderTAGSDS1 = Object.create(null),HolderTAGSDS2 = Object.create(null);


    assert.equal(areEqual.areEqual(mockElemDiv1,mockElemDiv2),true ,"are equal method is true for elem 1,elem 2");
    assert.equal(areEqual.areEqual(mockElemDiv2,mockElemDiv1),true ,"are equal method is true for elem 2,elem 1");
    assert.equal(areEqual.areEqual(mockElemDiv2,mockElemDiv2),true ,"are equal method is true for elem 2,elem 2");
    assert.equal(areEqual.areEqual(mockElemDiv1,mockElemDiv3), false ,"are equal method is false for elem 1,elem 3");
    assert.equal(areEqual.areEqual(mockElemDiv2,mockElemDiv3), false ,"are equal method is false for elem 2,elem 3");
    assert.equal(areEqual.areEqual(mockElemDiv3,mockElemDiv1), false ,"are equal method is false for elem 3,elem 1");
});

QUnit.test("test DOMEquality equalElements(element) method", function( assert ) {
    
    var mockElemDiv1 = document.createElement("div");
    mockElemDiv1.appendChild(document.createElement("img"));  
    mockElemDiv1.appendChild(document.createElement("span"));  
    mockElemDiv1.appendChild(document.createElement("div")).appendChild(document.createElement("img"));
    
    var mockElemDiv2 = document.createElement("div");
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("img"));
    mockElemDiv2.appendChild(document.createElement("span")).appendChild(document.createElement("div"));
    
    var mockElemDiv3 = document.createElement("div").appendChild(document.createElement("span"));
    
    var mockContainer =  document.createElement("div");
    mockContainer.appendChild(mockElemDiv1);
    mockContainer.appendChild(mockElemDiv2);
    mockContainer.appendChild(mockElemDiv3);

    var equalElements = new DOMEqualityES5.DOMEqualityES5();
    assert.equal(equalElements.equalElements(mockContainer).length === 1,true ,"equalElements method is true for [[elem1, elem2]]");
    

});