import {guessLetter} from "./helper.js";

window.getAlphabet = function (language = bg) {
    fetch(`http://localhost:8080/api/alphabet/${language}`, {method: "GET"}).then(response => {
        response.json().then(alphabet => {
            const alphabetDiv = document.getElementById("alphabet");
            alphabet.forEach(letter => {
                alphabetDiv.appendChild(createButton(letter));
            });
        })
    }).catch(e => {
        console.log(e)
    });
}

const createButton = (letter) => {
    const button = document.createElement("button")
    button.addEventListener("click", () => guessLetter(letter));
    button.setAttribute("class", "btn btn-default");
    button.innerText = letter;
    button.setAttribute("id", letter);
    return button;
}

