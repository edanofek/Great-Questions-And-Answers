var MockTreeDS = (function(){
    
    /**
     * Node item data holder
     * @param {name of node} name 
     * @param {base array of children} children 
     * @param {key for the node} key 
     * @param {parent id to node} pid 
     */
    function Node(name,children,key,pid){
        this.name = name;
        this.children = children;
        this.key = key;
        this.pid = pid;
    };

    /**
     * Base init for the first node in the tree (root element)
     */
    var MockTreeDS = function (){
        this.root = null; //base node for the tree
    };

    /**
     * find the node by tree id - (private utility method)
     * @param {which node to start looking from} nodeToStartLookFrom 
     * @param {node key to look for} nodeID 
     */
    var findNodeByID = function(nodeToStartLookFrom,nodeID){

        // Don't think this code needed
        // if(nodeToStartLookFrom.key === nodeID)
        //     return nodeToStartLookFrom;
        
        for(var ind=0;ind<nodeToStartLookFrom.children.length;ind++){
            if(nodeToStartLookFrom.children[ind].key === nodeID){
                return nodeToStartLookFrom.children[ind];
            }else if(nodeToStartLookFrom.children[ind].children.length > 0){ 
                //return recursion method with children nodes
               return findNodeByID(nodeToStartLookFrom.children[ind],nodeID);
            }
        }

        return null; //not found the node looking for
    }

    
    /**
     * Insert method for array (based on parent key)
     * @param {name of the new node} name 
     * @param {children array for the new node} children 
     * @param {key for the new node} key 
     * @param {parent key for the new node - also to decarle where to place the new node} pid 
     */
    MockTreeDS.prototype.insert = function(name,children,key,pid){
        var root = this.root; //the first node

        if(!root){
            // 'root',[],1,-1
            this.root = new Node(name,children,key,pid);
            return;
        }

        var currentNode = root;
        var newNode = new Node(name,children,key,pid);
        var tempNodeKey = findNodeByID(this.root,pid);
        
        if(tempNodeKey!== null){ //set the new root node for the found node children
            tempNodeKey.children.push(newNode);
        }else{ //set the new node for node one of the children
            currentNode.children.push(newNode);
        }

    }


    /**
     * delete method - recursioive method (delete all the leefs from the tree)
     * @param {the key for node to delete} key 
     */
    MockTreeDS.prototype.delete = function(key){

        var selectedNode = findNodeByID(this.root,key);

        for(var ind =0; ind < selectedNode.children.length; ind ++){
            this.delete(selectedNode.children[ind].key);
        }

        var parentSelectedNode = findNodeByID(this.root,selectedNode.pid);

        selectedNode.children=[];
        selectedNode.name="";
        selectedNode.key=-1;

        selectedNode.pid=-1;

        parentSelectedNode.children = [];
        
    };

    /**
     * update name to specific node
     * @param {key to the node} key 
     * @param {name to update} name 
     */
    MockTreeDS.prototype.upadteName =function(key,name){
        
        var selectedNode = findNodeByID(this.root,key);
        if(selectedNode!==null && selectedNode!==undefined){
            selectedNode.name = name;
        }
    }

    /**
     *  Convert the tree array into flat array
     * @param {start of node to create the sub array from} nodeToLookFor 
     * @param {the ref array to return} retArr 
     */
    MockTreeDS.prototype.createflatArr = function(nodeToLookFor,retArr){
        
        if(nodeToLookFor === null || nodeToLookFor === undefined){
            nodeToLookFor = this.root;
        }
        retArr.push({key:nodeToLookFor.key,name:nodeToLookFor.name,pid:nodeToLookFor.pid});
        nodeToLookFor.children.forEach(node => {
            this.createflatArr(node,retArr);
        });
        
    }
    
    return {
        MockTreeDS:MockTreeDS
    };

})();