chrome.extension.onMessage.addListener({
    function(request, sender, sendResponse){
        if(request.action === "prefs"){
            var prefsString = localStorage.prefs;
            if(prefsString === undefined){
                sendResponse(undefined);
            } else{
                sendResponse(JSON.parse(localStorage.prefs));
            }
        }
    }
});

function click(e){
    chrome.tabs.query({currentWindow:true, active:true}, funtion(tabs){
        console.log("background.js : click()");
        var specTab = tabs[0];
        //chrome.tabs.insertCSS(specTab.id, {file:"styles.css"});
        //chrome.tabs.executeScript(specTab.id, {file:"jquery-1.9.0.js"});
        chrome.tabs.executeScript({
            file: "script.js"
        }, function () {
            console.log("Injection is Completed");
        });
    });
}

chrome.browserAction.onClicked.addListener(click);