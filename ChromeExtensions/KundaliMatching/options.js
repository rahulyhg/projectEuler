function init(){
    var selectDay = '';
    for (i=1;i<=31;i++){
        selectDay += '<option value=' + i + '>' + i + '</option>';
    }
    $('#db1_day').html(selectDay);
    var selectYear = '';
    for (i=2015;i>=1950;i--){
        selectYear += '<option value=' + i + '>' + i + '</option>';
    }
    $('#db1_year').html(selectYear);
    var selectHour = '';
    for (i=00;i<=24;i++){
        selectHour += '<option value=' + i + '>' + i + '</option>';
    }
    $('#hr1').html(selectHour);
    var selectMin = '';
    for (i=00;i<=60;i++){
        selectMin += '<option value=' + i + '>' + i + '</option>';
    }
    $('#min1').html(selectMin);
    document.getElementById("submit").addEventListener("click",handleClick);
}

function id(name) { return document.getElementById(name); }

function handleClick() {
    id("yourName").innerHTML = id("name1").value; 
    id("yourDOB").innerHTML = id("db1_day").value + "-" + id("db1_month").value + "-" + id("db1_year").value + ", " + id("hr1").value +":" + id("min1").value; 
    id("yourPOB").innerHTML = id("pob1").value; 
    //window.localStorage.setItem("prefs", JSON.stringify({name:id('name1').value, day:id('db1_day').value, month:id('db1_month').value, year:id('db1_year').value, hr:id('hr1').value, min:id('min1').value, pob:id('pob1').value}));
    var day1 = (id('db1_day').value<10)?"0"+id('db1_day').value:id('db1_day').value;
    var month1 = (id('db1_month').value<10)?"0"+id('db1_month').value:id('db1_month').value;
    chrome.storage.sync.set({name1:id('name1').value, dob1:day1+"/"+month1+"/"+id('db1_year').value+" "+id('hr1').value+":"+id('min1').value, pob1:id('pob1').value}, function(){console.log("Values set!")});
}

window.onload = init;