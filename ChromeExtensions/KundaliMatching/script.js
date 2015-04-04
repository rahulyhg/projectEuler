//Global vars
var name;
var day;
var month;
var year;


//Utility functions
function id(name) { return document.getElementById(name); }
function exists(val) { return (val == null || val == undefined || val == "") ? false : true; }

function setName1(val){document.getElementById('name2').value = val;}
function setName2(val){document.getElementById('name1').value = val;}
function setDob1(val){
    document.getElementsByName('day2')[0].value = parseInt(val.split(" ")[0].split("/")[0]).toString();
    document.getElementsByName('month2')[0].value = parseInt(val.split(" ")[0].split("/")[1]).toString();
    document.getElementsByName('year2')[0].value = val.split(" ")[0].split("/")[2];
    document.getElementsByName('hrs2')[0].value = val.split(" ")[1].split(":")[0];
    document.getElementsByName('min2')[0].value = val.split(" ")[1].split(":")[1];
    document.getElementsByName('sec2')[0].value = "0";
}
function setDob2(val){
    document.getElementsByName('day1')[0].value = parseInt(val.split(" ")[0].split("/")[0]).toString();
    document.getElementsByName('month1')[0].value = parseInt(val.split(" ")[0].split("/")[1]).toString();
    document.getElementsByName('year1')[0].value = val.split(" ")[0].split("/")[2];
    document.getElementsByName('hrs1')[0].value = val.split(" ")[1].split(":")[0];
    document.getElementsByName('min1')[0].value = val.split(" ")[1].split(":")[1];
    document.getElementsByName('sec1')[0].value = "0";
}
function setPob1(val){
    document.getElementsByName('place2')[0].value = val;
}
function setPob2(val){
    document.getElementsByName('place1')[0].value = val;
}
function init(){
    if(window.location.href.toUpperCase().split("ASTROSAGE.COM/FREECHART/MATCHMAKING").length>1){
        getGun();
    }
    if(window.location.href.toUpperCase().split("MAHESHWARI.ORG").length>1){
        chrome.storage.sync.set({name2:document.getElementById('ctl00_Content_Pgallry').textContent.split('Profile')[0]});
        var columns = document.getElementsByClassName("col1 b");
        for (var i = 0; i < columns.length; i++) { if(columns[i].textContent == "Date of Birth") {chrome.storage.sync.set({dob2:columns[i].nextSibling.nextSibling.textContent}); }}
        for (var i = 0; i < columns.length; i++) { if(columns[i].textContent == "Place of Birth") {chrome.storage.sync.set({pob2:columns[i].nextSibling.nextSibling.textContent}); }}
    }
}


function getGun(){
    chrome.storage.sync.get("name1", function(result){setName1(result.name1);});
    chrome.storage.sync.get("name2", function(result){setName2(result.name2);});
    chrome.storage.sync.get("dob1", function(result){setDob1(result.dob1);});
    chrome.storage.sync.get("dob2", function(result){setDob2(result.dob2);});
    chrome.storage.sync.get("pob1", function(result){setPob1(result.pob1);});
    chrome.storage.sync.get("pob2", function(result){setPob2(result.pob2);});
    document.getElementsByName('submit')[0].click()
}

init();