var EliminateInlineStyles = (function(){

    // Step 1 - without optimization 
    var EliminateInlineStyles = function(){
        var classIndex = 1;

        // Step 2 - Classes data structure
        var optimizateClassesDS = {};
        // 1.add style tag
        var css = document.createElement("style");
        css.type = "text/css";
        
        // 2.pass on all the childern in the document
        // and convert the style into class 
        var rec = function rec(element){
            for(var elementItem in element.children){
                var item = element.children[elementItem];
                if(item.style !== null && item.style !== undefined 
                    && item.style.cssText.length > 0){
                    // step 2 - check if item.style.cssText key is exits - 
                    // if exits take the class index
                    if(optimizateClassesDS[item.style.cssText] === undefined
                         || optimizateClassesDS[item.style.cssText] === null){
                        optimizateClassesDS[item.style.cssText] = classIndex;
                        css.appendChild(document.createTextNode('.class'+classIndex+' {'+item.style.cssText+'}'));
                        item.setAttribute("class","class"+classIndex);
                        classIndex++;
                    } else{
                        item.setAttribute("class","class"+optimizateClassesDS[item.style.cssText]);
                    }
                    item.removeAttribute("style");

                }
                rec(item);
            }
        }(document.body);

        document.head.appendChild(css);
    }

    return {
        EliminateInlineStyles:EliminateInlineStyles
    };

})();