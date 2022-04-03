
window.onload = addButtonEvent;


function addButtonEvent(){
    toDoAddBtnEvent();
    doingAddBtnEvent();
    addFormBtn();
}

function addFormBtn(){
    var addbutton = document.querySelector(".add-button");
    addbutton.addEventListener("click",sendGet);
}

function sendGet(){
    var form = document.createElement("form");
    form.setAttribute("charset", "UTF-8");
    form.setAttribute("method", "Get");
    form.setAttribute("action", "/post/new");

    document.body.appendChild(form);
    form.submit();
}


function toDoAddBtnEvent(){
    var todoButton = document.querySelectorAll(".todo button");

    for(var i = 0; i < todoButton.length; i++){
        todoButton[i].addEventListener("click", sendPost);
    }
}

function doingAddBtnEvent(){
    var doingButton = document.querySelectorAll(".now-doing button");
    
    for(var i = 0; i < doingButton.length; i++){
        doingButton[i].addEventListener("click", sendPost);
    }
}


function sendPost(e){
    var postId = e.path[1].querySelector(".postId").textContent;

    var requestUrl = "/post/status"

    var form = document.createElement("form");
    form.setAttribute("method","Post");
    form.setAttribute("action", requestUrl);
    document.charset = "utf-8";

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "hidden");
    hiddenField.setAttribute("name", "postId");
    hiddenField.setAttribute("value", postId);
    form.appendChild(hiddenField);

    document.body.appendChild(form);
    form.submit();
}