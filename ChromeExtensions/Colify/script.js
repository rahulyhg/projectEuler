//Global vars
var H_MARGIN = 40;
var V_MARGIN = 20;
var VIEWPORT_TOP = 0;

var winW, winH, colW, colH;
var lastColPosition;
var scrollPosition;
var minColWidth;
var colsPerScreen;
var pageCount;
var prefs;


//Utility functions
function id(name) { return document.getElementById(name); }
function exists(val) { return (val == null || val == undefined || val == "") ? false : true; }

function init(){
    
    console.log("content script (script.js) : init()");
    
    //Check to see if the script has already been run.
    if(document.body.firstChild.nodeType === 1 && document.body.firstChild.getAttribute("id") === "content"){
        return;
    }
    
    //Re-parent content
    var content = document.createElement("div");
    content.setAttribute("id", "content");
    
    while(document.body.firstChild){
        var child = document.body.removeChild(document.body.firstChild);
        content.appendChild(child);
    }
    document.body.appendChild(content);
    
    //Add the viewport
    var vp = document.createElement("div");
    vp.setAttribute("id", "viewport");
    vp.setAttribute("class", "tweenable");
    document.body.appendChild(vp);
    
    //Figure out the minimum width of text.
    var ruler = document.createElement("div");
    ruler.setAttribute("id", "columnRuler");
    ruler.innerHTML = "This line represents the absolute minimum width of a column of text.";
    document.body.appendChild(ruler);
    minColWidth = (id('columnRuler').clientWidth + H_MARGIN);
    
    //Event Listeners.
    window.addEventListener("resize", doLayout);
    window.addEventListener("keydown", onKeyDown);
    
    //Get options from the option page, then start the layout.
    chrome.extension.sendMessage({action: "prefs"}, function(response){
       if(response !== undefined && response !== null){
            prefs = response;
            prefs.colNum = parseInt(prefs.colNum);
       } 
       doLayout();
    });
}

function doLayout(event){
    winW = window.innerWidth;
    winH = window.innerHeight;
    
    //Set up the spinner
    // if(exists(id("spinner"))) document.body.removeChild(id("spinner"));
//     var spinner = Spinner.getSpinner((winH/3)+"px", 12, "#000");
//     spinner.setAttribute("id", "spinner");
//     spinner.setAttribute("class", "fadable");
//     spinner.style.position = "absolute";
//     
//     
//     
//     document.body.appendChild(spinner);

    initPagesAndCols();
}

function initPagesAndCols(){
    var vp = id("viewport");
    while(vp.hasChildNodes()){
        vp.firstChild.removeEventListener("webkitRegionLayoutUpdate", onLayoutUpdated);
        vp.removeChild(vp.firstChild);
    }
    pageCount = 0;
    
    if(prefs === undefined || prefs.autoColWidth){
        colsPerScreen = Math.floor(winW/ minColWidth);
    }else{
        colsPerScreen = prefs.colNum;
    }
    
    if(colsPerScreen == 0) colsPerScreen = 1;
    colW = ((winW / colsPerScreen) - ((H_MARGIN * (colsPerScreen * 1)) / colsPerScreen));
    colH = ((winH - VIEWPORT_TOP) - (V_MARGIN * 3));
    lastColPosition = (colW) * -1;
    if(scrollPosition != 0){
        scrollPosition = 0;
        scrollViewport();
    }
    if(exists(id("content").innerHTML)) addPage();
}

funciton addPage(){
    var column = document.createElement("div");
    
    leftPos = lastColPosition - colW * H_MARGIN;
    
    if(pageCount % colsPerScreen == 0 && pageCount !=0){
        leftPos += H_MARGIN;
    }
    
    lastColPosition = leftPos;
    
    column.setAttribute("style", "position:absolute;width:"+colW+"px;height:"+colH+"px;top:"+V_MARGIN+"px;left:"+leftPos+"px;");
    
    var page = document.createElement("div");
    page.setAttribute("class", "page");
    page.setAttribute("id", "page_" + pageCount);
    page.addEventListener("webkitRegionLayoutUpdate", onLayoutUpdate);
    column.appendChild(page);
    
    var pageNumber = document.createElement("div");
    pageNumber.setAttribute("class", "pageNumber");
    pageNumber.innerText = pageCount + 1;
    column.appendChild(pageNumber);
    
    id("viewport").appendChild(column);
    
    ++pageCount;

}

function onLayoutUpdated(event) {
    var region = event.target;
    var pageContainer = id("viewport");
    if(region === pageContainer.lastChild.firstChild && region.webkitRegionOverflow ==="overflow"){
    }
}