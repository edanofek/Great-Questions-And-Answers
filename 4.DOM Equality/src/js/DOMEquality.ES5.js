var DOMEqualityES5 = (function(){

    var HolderTAGSDS = {};
    var DOMEqualityES5 = function(){
        var buildHolderTAGSDS = function(element){
            for (var index = 0; index < element.children.length; index++) {

                var element = element.children[index];
                if(element.children[index].children.length > 0) //enter to check all the childrens on each element
                    this.buildHolderTAGSDS(element.children[index]);

                if(HolderTAGSDS[element.tagName] === undefined )
                    HolderTAGSDS[element.tagName] = 1;
                else
                    HolderTAGSDS[element.tagName]++;
            }
            
        }
    }

    DOMEqualityES5.prototype.buildHolderTAGSDS = function(element){
        for (var index = 0; index < element.children.length; index++) {

            var elementItem = element.children[index];
            if(elementItem.children.length > 0) //enter to check all the childrens on each element
                this.buildHolderTAGSDS(elementItem);

            if(HolderTAGSDS[elementItem.tagName] === undefined )
                HolderTAGSDS[elementItem.tagName] = 1;
            else
                HolderTAGSDS[elementItem.tagName]++;
        }
        
    };

    DOMEqualityES5.prototype.printHolderTAGSDS = function(){
        console.info(HolderTAGSDS);
    }

    return {
        DOMEqualityES5:DOMEqualityES5
    }

})();

