var TreeDSDOM = (function(){
 
    var createNodeLine = function(){

    };

    var doc = window.document;

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

    
    var createLeafTemplate = function(htmlContainer){
        
    };

    TreeDSDOM.prototype.drawTree = function(treeDS,nodeToPutOn){
 
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
        var currentDepthLevel = 0;
        treeDS.createflatArr(null,flatArr,0);
 
        if(nodeToPutOn === undefined || nodeToPutOn === null){
            nodeToPutOn = doc.getElementById("main");
        }
        nodeToPutOn.innerHTML+="<ul>";

        for(var ind=0;ind<flatArr.length;ind++){

            if(currentDepthLevel < flatArr[ind].depthLevel){
                currentDepthLevel = flatArr[ind].depthLevel;
                nodeToPutOn.innerHTML+="<ul>";
            }

            nodeToPutOn.innerHTML+="<li>"+flatArr[ind].name+"</li>";

            if(currentDepthLevel > flatArr[ind].depthLevel){
                currentDepthLevel = flatArr[ind].depthLevel;
                nodeToPutOn.innerHTML+="</ul>";
            }


        }
        nodeToPutOn.innerHTML+="</ul>";
 
    };

    return {
        TreeDSDOM:TreeDSDOM
    };

})();