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
var mockTreeDS = new MockTreeDS();

QUnit.test("declare treeDS instance", function( assert ) {

    assert.ok(mockTreeDS !== null && mockTreeDS !==undefined,"mock tree ds is declared");

});

QUnit.test("test insert new object to mock tree ds",function(assert){
    
    assert.equal(mockTreeDS.length,0,"mock tree length equal 0");

    mockTreeDS.insert({name:a,children:[],key:1,pid:0});
    
    assert.equal(mockTreeDS.length,1,"mock tree length equal 1");

});

QUnit.test("test delete all nodes for branch",function(assert){
    
    mockTreeDS.insert({name:a,children:[],key:1,pid:0});
    mockTreeDS.delete({key:1,pid:-1});
    assert.equal(mockTreeDS.length,0,"mock tree length equal 0 afer delete");
    
});

// QUnit.test("test update node name",function(assert){
    
//     mockTreeDS.insert({name:a,children:[],key:1,pid:0});
//     mockTreeDS.delete({key:1,pid:-1});
//     assert.equal(mockTreeDS.length,0,"mock tree length equal 0 afer delete");
    
// });

QUnit.test("test update node name",function(assert){
    
    mockTreeDS.insert({name:a,children:[],key:1,pid:0});
    mockTreeDS[0].upadteName('mockName');
    assert.equal(mockTreeDS[0].name,'mockName',"mock tree name in node 0 equal 'mockName' ");
    
});


QUnit.test("test convert to flat array and draw the array",function(assert){
    
    mockTreeDS.insert({name:a,children:[],key:1,pid:0});
    mockTreeDS[1].children.push({name:d,children:[],key:4,pid:1});

    mockTreeDS.insert({name:b,children:[],key:2,pid:0});
    mockTreeDS.insert({name:c,children:[],key:3,pid:0});

    var flatArr = mockTreeDS.createflatArr();

    assert.equal(flatArr.length,4,"flat arr length equal 4 ");
    assert.equal(flatArr[0],{name:a,key:1},"flat arr in place 0 should be equal a ");
    assert.equal(flatArr[1],{name:d,key:2},"flat arr in place 1 should be equal d ");
    
});