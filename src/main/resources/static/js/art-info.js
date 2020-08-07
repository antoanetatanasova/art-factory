var pageCounter = 1;
var artContainer = document.getElementById("art-info");
var btn = document.getElementById("art-btn");

btn.addEventListener("click", function() {
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'https://res.cloudinary.com/the-potential/raw/upload/v1596790495/art-factory/JSON/art-' + pageCounter + '.json');
    ourRequest.onload = function() {
        if (ourRequest.status >= 200 && ourRequest.status < 400) {
            var ourData = JSON.parse(ourRequest.responseText);
            renderHTML(ourData);
        } else {
            console.log("We connected to the server, but it returned an error.");
        }

    };

    ourRequest.onerror = function() {
        console.log("Connection error");
    };

    ourRequest.send();
    pageCounter++;
    if (pageCounter > 3) {
        btn.classList.add("hide-me");
    }
});

function renderHTML(data) {
    var htmlString = "";

    for (i = 0; i < data.length; i++) {
        htmlString += "<p>" + data[i].name + " Description: " + data[i].description + ".";

        for (ii = 0; ii < data[i].actions.implemented.length; ii++) {
            if (ii == 0) {
                htmlString += data[i].actions.implemented[ii];
            } else {
                htmlString += " and " + data[i].actions.implemented[ii];
            }
        }

        htmlString += ' and dislikes ';

        for (ii = 0; ii < data[i].actions.not-implemented.length; ii++) {
            if (ii == 0) {
                htmlString += data[i].actions.not-implemented[ii];
            } else {
                htmlString += " and " + data[i].actions.not-implemented[ii];
            }
        }

        htmlString += '.</p>';
    }

    artContainer.insertAdjacentHTML('beforeend', htmlString);
}