window.onload = cancelEvent;

function cancelEvent(){
    var cancelButton = document.querySelector(".cancel");
    cancelButton.addEventListener("click", function(){
        var form = document.createElement("form");
        form.setAttribute("charset", "UTF-8");
        form.setAttribute("method","Get");
        form.setAttribute("action", "/");

        document.body.appendChild(form);
        form.submit();
    })
}