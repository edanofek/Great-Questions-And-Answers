var TreeDSDOM = (function(){
 
    var createNodeLine = function(){

    };

    var doc = window.document;
    var refTreeDS ;
    // create mock insert method - for basic tree
    var mockCreateTree = function(treeDS){

        treeDS.insert('root',[],1,0);
        treeDS.insert('a',[],1,0);
        treeDS.insert('c',[],3,1);
        treeDS.insert('b',[],2,0);
        treeDS.insert('d',[],4,2);
        
    };

    var TreeDSDOM = function(treeDS){
        //create main root node
        mockCreateTree(treeDS);

        var ulRoot = doc.createElement('ul');

        var plusButton = doc.createElement('button');
        var minusButton = doc.createElement('button');

        plusButton.id = "plus";
        plusButton.innerText ="plus button";
        minusButton.id ="minus";
        minusButton.innerText = "minus button";
               
    };

    TreeDSDOM.prototype.addNewNode = function(node){
        alert(node);
        if(refTreeDS!==undefined && refTreeDS!==null){
            var flatArr = [];
            refTreeDS.createflatArr(null,flatArr,0);
            refTreeDS.insert('new node',[],flatArr.length,node.pid);
            this.drawTreeFromFlatArray(refTreeDS,null);
        }

       
    }

    TreeDSDOM.prototype.removeNode = function(node){
        alert(node);
        if(refTreeDS!==undefined && refTreeDS!==null){
            
            refTreeDS.delete(node.id);
        }
    }
    
    var createLeafTemplate = function(node){
        
        var tempalteText = "<li><div>"+node.name+
        "<br/><button id='add_node"+node.id+"' >add to "+node.name+
        " child</button><button id='remove_node"+node.id+"' >remove "+node.name+
        "</button></div></li>";

        return tempalteText;
    };

    TreeDSDOM.prototype.drawTree = function(treeDS,nodeToPutOn){
 
        refTreeDS = treeDS;
        var ulElem = doc.createElement('ul');
        var liElem = doc.createElement('li');
        var leafName = doc.createTextNode(treeDS.name);

        liElem.appendChild(leafName);
        ulElem.appendChild(liElem);
        
        if(nodeToPutOn === undefined || nodeToPutOn === null){
            nodeToPutOn = doc.getElementById("main");
        }
        nodeToPutOn.appendChild(ulElem);
        
        for(var ind=0;ind<treeDS.children.length;ind++){

            if(treeDS.children.length > 0){
                this.drawTree(treeDS.children[ind],ulElem);
            }

        }
 
    };

    TreeDSDOM.prototype.drawTreeFromFlatArray = function(treeDS,nodeToPutOn){

        var flatArr = [];
        var currentDepthLevel = 0,compULElems = 0;
        var ind;

        refTreeDS = treeDS;
        treeDS.createflatArr(null,flatArr,0);

        if(nodeToPutOn === undefined || nodeToPutOn === null){
            nodeToPutOn = doc.getElementById("main");
        }
        nodeToPutOn.innerText+="<ul>";

        for(ind=0;ind<flatArr.length;ind++){

            if(currentDepthLevel < flatArr[ind].depthLevel){
                currentDepthLevel = flatArr[ind].depthLevel;
                nodeToPutOn.innerText+="<ul>";
                compULElems++;
            }
            
            if(currentDepthLevel > flatArr[ind].depthLevel){
                currentDepthLevel = flatArr[ind].depthLevel;
                compULElems--;
                nodeToPutOn.innerText+="</ul>";
            }
            
            nodeToPutOn.innerText+= createLeafTemplate(flatArr[ind]);
            
        }

        for(ind=0; ind < compULElems;ind++){
            nodeToPutOn.innerText+="</ul>";
        }

        nodeToPutOn.innerText+="</ul>";
        nodeToPutOn.innerHTML = nodeToPutOn.innerText;
    };

    return {
        TreeDSDOM:TreeDSDOM
    };

})();