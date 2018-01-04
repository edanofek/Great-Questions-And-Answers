var DOMEqualityES5 = (function(){

    var checkElementByTagName=function(element,HolderTAGSDS){
        if(HolderTAGSDS[element.tagName] === undefined )
            HolderTAGSDS[element.tagName] = 1;
        else
            HolderTAGSDS[element.tagName]++;
    }

    var buildHolderTAGSDS = function(element,HolderTAGSDS){
        
        checkElementByTagName(element,HolderTAGSDS);
        var recPart = function(element,HolderTAGSDS){

            for (var index = 0; index < element.children.length; index++) {
    
                var elementItem = element.children[index];
                if(elementItem.children.length > 0) //enter to check all the childrens on each element
                    recPart(elementItem,HolderTAGSDS);
    
                checkElementByTagName(elementItem,HolderTAGSDS);
            }
        }
        recPart(element,HolderTAGSDS);

    };

    var checkTagsAnagram = function(HolderTAGSDS1, HolderTAGSDS2){
        var flag = true;
        
        for (var tag in HolderTAGSDS1) {
            
            if(HolderTAGSDS2[tag] === undefined || HolderTAGSDS2[tag] === null){
                flag = false;
                break;
            } else{
                HolderTAGSDS2[tag] = (HolderTAGSDS2[tag] - HolderTAGSDS1[tag]);
                HolderTAGSDS1[tag] = 0;
            }
        }

        for (var tag in HolderTAGSDS2){
            if(HolderTAGSDS2[tag] !== 0){
                flag = false;
                break;
            }
        }

        return flag;
    };

    
    var DOMEqualityES5 = function(){
    }


    DOMEqualityES5.prototype.areEqual = function(element1, element2){
        // DS contianers
        var HolderTAGSDS1 = {},HolderTAGSDS2 ={};
        // build tag holder DS for element 1
        buildHolderTAGSDS(element1,HolderTAGSDS1);
        // build tag holder DS for element 2
        buildHolderTAGSDS(element2,HolderTAGSDS2);
        // check the DS to see for equal anagram
        return checkTagsAnagram(HolderTAGSDS1,HolderTAGSDS2);
    }


    DOMEqualityES5.prototype.equalElements = function(element){
        
        var retEqualElements = [];
        // O[n*n] complexability solution - Not best Practice.
        // TODO - solve in better complexability
        for(var i=0;i < element.children.length;i++){
            for(var j=(i+1);j < element.children.length;j++){
                if(i !== j && this.areEqual(element.children[i],element.children[j]) === true ){
                    retEqualElements.push([element.children[i],element.children[j]]);
                }
            }
        }
        return retEqualElements;
    }

    return {
        DOMEqualityES5:DOMEqualityES5
    }

})();

