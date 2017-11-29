var TreeDSDOM = (function(treeDS){
 
    var createNodeLine = function(){

    }

    var doc = window.document;

    var TreeDSDOM = function(){
        //create main root node
        treeDS.insert('root',[],1,0);
        var ulRoot = doc.createElement('ul');
        
        doc.getElementById("main").appendChild(ulRoot);
    }

    TreeDSDOM.prototype.drawTree = function(){
        var arr = treeDS.createflatArr();
        for(var ind =0;ind<arr.length;ind++){
            // con't here
        }
    }

    return {
        TreeDSDOM:TreeDSDOM
    };

});