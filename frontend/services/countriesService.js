import {maskAndRenderCountry, hangHim} from "./helper.js";

window.addCountry = function addCountry() {
    let countryName = document.getElementById("countryNameToSend").value;
    console.log(countryName);
    fetch("http://localhost:8080/api/countries", {
        method: "POST",
        body: JSON.stringify({ name: countryName }),
        headers: {"Content-Type": "application/json"}
    });
}

window.getCountry =  function() {
   fetch("http://localhost:8080/api/country", {method: "GET"}).then(response => {
       response.json().then(country => {
        reset();
        countryToGuess = country.name.toUpperCase();
        uniqueCountryLetters = [...new Set(Array.from(countryToGuess))];
        guessedLetters.push(countryToGuess.charAt(0));
        guessedLetters.push(countryToGuess.charAt(countryToGuess.length - 1));
        const children = Array.from(document.getElementById("alphabet").children);
        children.forEach(child => child.removeAttribute("disabled"));
        document.getElementById("timer").innerText = timeremainig;
        maskAndRenderCountry();
        if(intervalHolder != null)
            clearInterval(intervalHolder);
        intervalHolder = setInterval(countDown, 1000);
       })
   });
}



const reset = () => {
 countryToGuess = "";
 uniqueCountryLetters = [];
 guessedLetters = [];
 failedAttempts = 0;
 const image = document.getElementById("hang");
 image.setAttribute("src", `./images/err0.gif`)
 const result = document.getElementById("result");
 result.style.display = "none";
}

export const countDown = () => {
    const currentValue = Number.parseInt(document.getElementById("timer").innerText);
    if(currentValue === 0) {
        hangHim();
    }
    document.getElementById("timer").innerText =  currentValue - 1;
}