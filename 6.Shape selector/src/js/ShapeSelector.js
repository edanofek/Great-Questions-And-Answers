// Hold Our Images 
// Image Holder container - class
var ImageHolderContianer = (function(){
    
    // Cto'r 
    var ImageHolderContianer = function(shapeSelectorID){
        
        this.shapeSelectorID = shapeSelectorID
        this.imageHolderDS = {};
    };


    ImageHolderContianer.prototype.addImages = function(){
        this.addImage = function(imageName,shapeSelectorID,selected){

            var loadedImage = new Image();
            loadedImage.src = "./src/img/"+imageName+".png";
            this.imageHolderDS[imageName]=
                    {selected:selected ? true : false,
                    loadedImageElem:loadedImage,
                    shapeSelectorID:shapeSelectorID};
            
        }

        this.addImage('ellipsis',this.shapeSelectorID,true);
        this.addImage('polygon',this.shapeSelectorID);
        this.addImage('reactangle',this.shapeSelectorID);
        this.addImage('rounded_rect',this.shapeSelectorID);
        this.addImage('star_big',this.shapeSelectorID);
        this.addImage('star_small',this.shapeSelectorID);
        this.addImage('triangle',this.shapeSelectorID);
        
    }

    return {
        ImageHolderContianer:ImageHolderContianer,
    }
})();


// Shape Selector Class
var ShapeSelector = (function(){

    // Cto'r 
    var ShapeSelector = function(shapeSelectorID,imageHolderDS){
        this.shapeSelectorID = shapeSelectorID;
        this.imageHolderDS = imageHolderDS;
    }

    ShapeSelector.prototype.drawContainer = function(baseElem){
     
        var removeOldestList = function(){
            var oldestUI = document.getElementsByTagName("ul")[0];
            if(oldestUI !==undefined ){
                oldestUI.parentNode.removeChild(oldestUI);
            }
        }
        
        removeOldestList();
        var ul = document.createElement("ul");
        for (var key in this.imageHolderDS) {
            var elem = this.imageHolderDS[key].loadedImageElem;
            
            var li = document.createElement("li");

            (function(key,imageHolderDS){
                li.addEventListener("click",function(){
                    for (var keyT in imageHolderDS){
                        imageHolderDS[keyT].selected = false;
                    }
                    imageHolderDS[key].selected = true;
                    
                });

            })(key,this.imageHolderDS);

            // Con't here - need to fix
            if(elem.selected === true){
                elem.class = "outline_selected";
            }else{
                elem.class = "";
            }
            li.appendChild(elem);
            ul.appendChild(li);
        }
        baseElem.appendChild(ul);
    }

    return {
        ShapeSelector:ShapeSelector
    };

})();