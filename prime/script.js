function isPrime(number) {
    if (number <= 1) return false; 
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) {
            return false;
        }
    }
    return true;
}

function checkPrime() {
    const num = parseInt(document.getElementById('numberInput').value);
    if (isNaN(num)) {
        alert("Please enter a valid number.");
        return;
    }
    if (isPrime(num)) {
        alert(num + " is a prime number.");
    } else {
        alert(num + " is not a prime number.");
    }
}
