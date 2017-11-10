(function(){
    
    // con't here
    // item holder - data
    function Node(name,children,key,pid){
        this.name = name;
        this.children = children;
        this.key = key;
        this.pid = pid;
    };

    var MockTreeDS = function (){
        this.root = null;
    };

    // check with unit test resaults - con't here
    mockTreeDS.prototype.insert = function(name,children,key,pid){
        var root = this.root;

        if(!root){
            // 'root',[],1,-1
            this.root = new Node(name,children,key,pid);
            return;
        }

        var currentNode = root;
        var newNode = new Node(name,children,key,pid);

        // con't here - don't think it will work
        currentNode.children.push(newNode);
        // this.children.push(newNode);
        
            // this.children.push(newNode);
    }


    mockTreeDS.prototype.delete = function(key,pid){
        //should be recursive
        // if(!root) {
            for(var ind =0; ind < this.children.length; ind ++){
                if(this.children[ind].length > 0){
                    this.delete(this.children[ind].key,this.children[ind].pid);
                }

            }
            //clean value
            this.children=[];
            this.name = "";
            this.key = -1;
            this.pid = -1;     
        // }
    };

    // should update this value
    mockTreeDS.prototype.upadteName =function(key,pid,name){
        //update name
        if(!root){
            this[key].name = name;
            return;
        }
        var currentNode = root;
        currentNode[key].name = name;
    }

    mockTreeDS.prototype.createflatArr = function(){
        var retArr = [];
        for (var key in this.children) {
            if (this.children.hasOwnProperty(key)) {
                var element = this.children[key];
                // con't here
            }
        }
        return retArr;
    }
    
    return MockTreeDS;

})();