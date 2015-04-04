function init(){
    //Check to see if the script has already been run.
    console.log("Injected again");

    if(document.body.firstChild.nodeType === 1 && document.body.firstChild.getAttribute("id") === "gunMatching"){
        return;
    }
    
    //Create GunMatching div
    var gunMatching = document.createElement("div");
    gunMatching.setAttribute("id", "gunMatching");
    
    //Re-parent content
    var content = document.createElement("div");
    content.setAttribute("id", "content");
    
    while(document.body.firstChild){
        var child = document.body.removeChild(document.body.firstChild);
        content.appendChild(child);
    }
    document.body.appendChild(gunMatching);
    document.body.appendChild(content);
    
    //Get options from the option page, then start the layout.
    chrome.extension.sendMessage({action: "prefs"}, function(response){
       if(response !== undefined && response !== null){
            name = response.name;
            day = parseInt(response.day);
            month = parseInt(response.month);
            year = parseInt(response.year);
       } 
       doLayout();
    });
}

function doLayout(){
    //console.log(prefs.name);
    //id('gunMatching').appendChild(createLabel(prefs.name));
    id('gunMatching').appendChild(createLabel(day+"-"+month+"-"+year));
}

function createLabel(val){
    var x = document.createElement("label");
    var t = document.createTextNode(val+ "   ");
    x.appendChild(t);
    return x;
}