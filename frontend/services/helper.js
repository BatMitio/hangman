export function maskAndRenderCountry() {
 document.getElementById("country").innerText = maskCountryV2(countryToGuess);
}

function maskCountryV2(countryToGuess) {
    let arr = [];
    arr.push(countryToGuess.charAt(0));
    document.getElementById(countryToGuess.charAt(0)).setAttribute("disabled", true);
    for(let i = 1; i <= countryToGuess.length - 2; i++) {
        if(guessedLetters.includes(countryToGuess.charAt(i))) {
            arr.push(countryToGuess.charAt(i));
            document.getElementById(countryToGuess.charAt(i)).setAttribute("disabled", true);
        } else {
            arr.push("_")
        }
 
    }
    arr.push(countryToGuess.charAt(countryToGuess.length - 1));
    document.getElementById(countryToGuess.charAt(countryToGuess.length - 1)).setAttribute("disabled", true);

    return arr.join(" ");
}

export const  guessLetter = (letter) => {
    document.getElementById(letter).setAttribute("disabled", true);
    if(countryToGuess.includes(letter)) {
        guessedLetters.push(letter);
        maskAndRenderCountry();
        if(guessedLetters.length === uniqueCountryLetters.length) {
            const result = document.getElementById("result");
            result.style.display = "block";
            result.innerHTML = "<h3>You succeeded</h3>";
            result.style.color = "green";
            clear();
        }
    } else {
        failedAttempts++;
        const image = document.getElementById("hang");
        image.setAttribute("src", `./images/err${failedAttempts}.gif`)
        if(failedAttempts === maximumAttempts) {
            hangHim();
            return;
        }

    }
}

export const hangHim = () => {
    guessedLetters = [...countryToGuess];
    failedAttempts = 6;
    maskAndRenderCountry();
    const result = document.getElementById("result");
    result.style.display = "block";
    result.innerHTML = "<h3>You failed</h3>";
    result.style.color = "red";
    const image = document.getElementById("hang");
    image.setAttribute("src", `./images/err${failedAttempts}.gif`)
    const children = Array.from(document.getElementById("alphabet").children);
    children.forEach(child => child.setAttribute("disabled", true));
    clear();
}

const clear = () => {
    clearInterval(intervalHolder);
}