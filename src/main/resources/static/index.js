const uri = "http://localhost:8081/books/";
let books = [];
let updateIndex = 0;

function getUser() {
    $.ajax({
        url: uri,
        type: "GET",
        dataType: "json",
        success: function (data) {
           
            console.log(data);
            login = data;
            _displayItem(login);
        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function _displayItem(login){
    const tBody = document.getElementById("Login");
    const button = document.createElement("button");
    books.forEach((item) => {
        
        console.log(item.title);
        let tr = tBody.insertRow();
        let td1 = tr.insertCell(0);
        let id = document.createTextNode(item.id);
        td1.appendChild(id);
        let td2 = tr.insertCell(1);
        let Name = document.createTextNode(item.Name);
        td2.appendChild(Name);
        let td3 = tr.insertCell(2);
        let MobileNumber = document.createTextNode(item.MobileNumber );
        td3.appendChild(MobileNumber );
        
    });
}
