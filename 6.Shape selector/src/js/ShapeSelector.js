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
                {
                    selected:selected ? true : false,
                    loadedImageElem:loadedImage,
                    shapeSelectorID:shapeSelectorID
                };
            
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

    var ShapeSelector = function(shapeSelectorID,imageHolderDS){
        this.shapeSelectorID = shapeSelectorID;
        this.imageHolderDS = imageHolderDS;
        document.getElementsByClassName("shapeContainerTitle")
            [(shapeSelectorID-1)].innerHTML = "Group "+shapeSelectorID;
    }

    ShapeSelector.prototype.drawContainer = function(baseElem){
     
        var removeOldestList = function(){
            var oldestUI = baseElem.getElementsByTagName("ul")[0];
            if(oldestUI !==undefined ){
                oldestUI.parentNode.removeChild(oldestUI);
            }
        }
        
        var changeStyleOfSelectedLI = function(){
            
            for (var keyT in this.imageHolderDS){
                this.imageHolderDS[keyT].selected = false;
                document.getElementsByClassName(keyT)[0].className=keyT;
            }

            if(this.imageHolderDS[this.pressedKey] !==undefined){
                this.imageHolderDS[this.pressedKey].selected = true;
                document.getElementsByClassName(this.pressedKey)[0].className +=" outline_selected";
            }
        
        }
        
        // Logic for drawing
        removeOldestList();
       
        var ul = document.createElement("ul");
        
        for (var key in this.imageHolderDS) {
            var elem = this.imageHolderDS[key].loadedImageElem;
            
            var li = document.createElement("li");
            li.className+=key;

            (function(pressedKey,imageHolderDS){
                li.addEventListener("click",function(){
                    var objToPass = { pressedKey:pressedKey,imageHolderDS:imageHolderDS }; //pass to call function
                    changeStyleOfSelectedLI.call(objToPass);
                });
            })(key,this.imageHolderDS);//IIFE to prevent refracne problem on click

            li.appendChild(elem);
            ul.appendChild(li);
        }
        
        baseElem.appendChild(ul);
        
        var objToPass = {pressedKey :'ellipsis',imageHolderDS:this.imageHolderDS }; //pass to call function
        if(this.imageHolderDS!=={}){
            changeStyleOfSelectedLI.call(objToPass); //set first shape selected
        }
    }

    ShapeSelector.prototype.getSelectedShape = function(){

        for (var keyT in this.imageHolderDS){
            if(this.imageHolderDS[keyT].selected === true)
                return keyT;
        }

    }

    return {
        ShapeSelector:ShapeSelector
    };

})();

// Buttons arrows method
var ButtonsArrows = (function(){

    // Cto'r
    var ButtonsArrows = function(ShapeSelectorLeft,ShapeSelectorRight){

        var arrowLeft = document.getElementById("moveSelectedShapeLeft");
        var arrowRight = document.getElementById("moveSelectedShapeRight");
    
        (function(ShapeSelectorLeft,ShapeSelectorRight){
    
            arrowLeft.addEventListener("click",function(){

                // 1.Get selected shape (check if selected)
                var selectedShapeKey = ShapeSelectorRight.getSelectedShape();
                var selectedShape

                // 2.Remove selected shape from the needed container,
                //   update the image holder image holder ds in the seconed container
                ShapeSelectorLeft.imageHolderDS[selectedShapeKey] = ShapeSelectorRight.imageHolderDS[selectedShapeKey];
                ShapeSelectorLeft.imageHolderDS[selectedShapeKey].shapeSelectorID = 1;
                delete ShapeSelectorRight.imageHolderDS[selectedShapeKey];
                // 3.Redraw both containers
                ShapeSelectorLeft.drawContainer(document.getElementsByClassName('shapeContainer')[0]);
                ShapeSelectorRight.drawContainer(document.getElementsByClassName('shapeContainer')[1]);

            });
        
            arrowRight.addEventListener("click",function(){
                
                // 1.Get selected shape (check if selected)
                var selectedShapeKey = ShapeSelectorLeft.getSelectedShape();
                // selectedShape.shapeSelectorID = 2;
                // 2.Remove selected shape from the needed container,
                //   update the image holder image holder ds in the seconed container
                ShapeSelectorRight.imageHolderDS[selectedShapeKey] = ShapeSelectorLeft.imageHolderDS[selectedShapeKey];
                ShapeSelectorRight.imageHolderDS[selectedShapeKey].shapeSelectorID = 2;
                delete ShapeSelectorLeft.imageHolderDS[selectedShapeKey];
                // 3.Redraw both containers
                ShapeSelectorLeft.drawContainer(document.getElementsByClassName('shapeContainer')[0]);
                ShapeSelectorRight.drawContainer(document.getElementsByClassName('shapeContainer')[1]);

            });

        })(ShapeSelectorLeft,ShapeSelectorRight);
    }


    return{
        ButtonsArrows:ButtonsArrows
    };

})();