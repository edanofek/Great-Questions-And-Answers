/*
    Tree DS tests
 */

// 2.test all curd operation with childrens:
// 2.1.test insert - V
// 2.2.test delete all nodes for branch - V
// 2.2.1.test delete all one node for branch - ? (don't think it's needed)
// 2.3.test draw / print the logic of flat array - V
// 2.4.test update one node name - V
// 2.4.1.test update one node place (branch) - futru(e)rstic

// 1.test declare a variable instance


QUnit.test("declare treeDS instance", function( assert ) {
    var mockTreeDS = new MockTreeDS.MockTreeDS();

    assert.ok(mockTreeDS !== null 
        && mockTreeDS !==undefined
        && mockTreeDS.root === null,"mock tree ds is declared");
});

QUnit.test("test insert new object to mock tree ds",function(assert){
    var mockTreeDS = new MockTreeDS.MockTreeDS();

    assert.equal(mockTreeDS.root,null,"mock tree root should be equal to null");
    
    mockTreeDS.insert('root',[],1,0);
    mockTreeDS.insert('a',[],1,0);
    
    assert.equal(mockTreeDS.root.children.length,1,"mock tree after 1 time : (root->a) insert length equal is 1");
    mockTreeDS.insert('b',[],2,0);
    assert.equal(mockTreeDS.root.children.length,2,"mock tree after 2 time : (root->b) insert length equal is 2");

    mockTreeDS.insert('c',[],3,1);
    assert.equal(mockTreeDS.root.children[0].children.length,1,"mock tree after 3 time: (a->c) insert length equal is 1");
    
    mockTreeDS.insert('d',[],4,0);
    assert.equal(mockTreeDS.root.children.length,3,"mock tree after 4 time: (root->d) insert length equal is 3");

    mockTreeDS.insert('e',[],5,3);
    assert.equal(mockTreeDS.root.children[0].children[0].children.length,1,"mock tree after 5 time: (c->e) insert length equal is 1");

});

QUnit.test("test delete all nodes for branch",function(assert){
    var mockTreeDS = new MockTreeDS.MockTreeDS();
    mockTreeDS.insert('root',[],1,0);
    mockTreeDS.insert('a',[],1,0);
    mockTreeDS.insert('b',[],2,0);
    mockTreeDS.insert('c',[],3,1);
    mockTreeDS.insert('d',[],4,3);
    mockTreeDS.delete(3);

    assert.equal(mockTreeDS.root.children[0].children.length,0,"mock tree length after first delete (c->d - delete) equal to 0");
    assert.equal(mockTreeDS.root.children.length,2,"mock tree length equal 2 for root children");
    

});


QUnit.test("test update node name",function(assert){
    var mockTreeDS = new MockTreeDS.MockTreeDS();
    mockTreeDS.insert('root',[],1,0);
    mockTreeDS.insert('a',[],1,0);
    mockTreeDS.upadteName(1,'mockName');
    assert.equal(mockTreeDS.root.children[0].name,'mockName',"mock tree name in node 0 equal 'mockName' ");
    
});


QUnit.test("test convert to flat array and draw the array",function(assert){
    
    var mockTreeDS = new MockTreeDS.MockTreeDS();
    mockTreeDS.insert('root',[],1,0);
    mockTreeDS.insert('a',[],1,0);
    mockTreeDS.insert('b',[],2,0);
    mockTreeDS.insert('c',[],3,1);
    mockTreeDS.insert('d',[],4,3);
    
    var flatArr = mockTreeDS.createflatArr();

    assert.equal(flatArr.length,4,"flat arr length equal 4 ");
    assert.equal(flatArr[0],{name:a,key:1},"flat arr in place 0 should be equal a ");
    assert.equal(flatArr[1],{name:d,key:2},"flat arr in place 1 should be equal d ");
    
});