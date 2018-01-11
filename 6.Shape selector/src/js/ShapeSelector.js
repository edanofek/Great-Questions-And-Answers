// Hold Our Images 
var ImageHolderContianer = (function(){
    

    var ImageHolderContianer = function(shapeSelectorID){
        
        this.shapeSelectorID = shapeSelectorID
        this.imageHolderDS = {};
    };


    ImageHolderContianer.prototype.addImages = function(){
        this.addImage = function(imageName,shapeSelectorID){

            var loadedImage = new Image();
            loadedImage.src = "./src/img/"+imageName+".png";
            this.imageHolderDS[imageName]=
                    {selected:false,
                    loadedImageElem:loadedImage,
                    shapeSelectorID:shapeSelectorID};
            
        }

        this.addImage('ellipsis',this.shapeSelectorID);
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



var ShapeSelector = (function(){

    //hold the shapes ds on each shape selector
    

    var ShapeSelector = function(shapeSelectorID){
        // Cto'r
        var shapeSelectorID = this.shapeSelectorID;
    }

    ShapeSelector.prototype.initFN = function(fullOrEmpty){
     
        // var DrawBase

        if(fullOrEmpty === true){


        }else{

        }
    }

    return {
        ShapeSelector:ShapeSelector,
        // ShapesDS:ShapesDS
    };

})();