//var day, month, year, hour, min;
var gunMilanWindow;
function getName1(){ return id('name1').innerHTML;}
function getName2(){ return id('name2').innerHTML;}
function setName1(val){ id("name1").innerHTML = val;}
function setName2(val){ id("name2").innerHTML = val;}
function setDob1(val){ id("dob1").innerHTML = val;}
function setDob2(val){ 
    if(val.split("-").length>1){
        var date = val.split(" ");
        var day = date[0];
        var month = day.split("-")[1];
        var monthInNumber = convertToMonth(month);
        var date1 = day.split("-")[0]+"/"+monthInNumber+"/"+day.split("-")[2];
        var hour = date[1].split(":")[0];
        var ampm = date[2];
        var hour24 = getHour24(hour, ampm);
        var min = parseInt(date[1].split(":")[1]);
        var time1 = hour24+":"+min;
        id("dob2").innerHTML = date1.toString()+" "+time1;
        chrome.storage.sync.set({dob2:date1+" "+time1});
    }
    else{
        id("dob2").innerHTML = val;
    }
}
function setPob1(val){ id("pob1").innerHTML = val;}
function setPob2(val){ id("pob2").innerHTML = val;}

function getHour24(hour, ampm){
    if(ampm=="AM"&&parseInt(hour)==12){
        return 0;
    }
    else if(ampm=="PM"){
        return parseInt(hour) + 12;
    }
    else{
        return parseInt(hour);
    }
}
function convertToMonth(val){
    switch(val){
        case "Jan":
            return "01";
        case "Feb":
            return "02";
        case "Mar":
            return "03";
        case "Apr":
            return "04";
        case "May":
            return "05";
        case "Jun":
            return "06";
        case "Jul":
            return "07";
        case "Aug":
            return "08";
        case "Sep":
            return "09";
        case "Oct":
            return "10";
        case "Nov":
            return "11";
        case "Dec":
            return "12";
    }
}
function init(){
    //var prefs = JSON.parse(window.localStorage.getItem("prefs"));
    chrome.storage.sync.get("name1", function(result){setName1(result.name1);});
    chrome.storage.sync.get("name2", function(result){setName2(result.name2);});
    chrome.storage.sync.get("dob1", function(result){setDob1(result.dob1);})
    chrome.storage.sync.get("dob2", function(result){setDob2(result.dob2);});
    chrome.storage.sync.get("pob1", function(result){setPob1(result.pob1);});
    chrome.storage.sync.get("pob2", function(result){setPob2(result.pob2);});
    id('getGunMilanSite').addEventListener("click", getGunMilanSite);
}

function getGunMilanSite(){
    gunMilanWindow = window.open("http://www.astrosage.com/freechart/matchMaking.asp");
}


function id(name) { return document.getElementById(name); }

window.onload = init;