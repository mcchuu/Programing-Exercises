// function to determin sum of user input
function sum(){
    let num = prompt('enter a number: ');  // prompt user to input number
    let len = num.length // assign length of num to len
    let newNum // define newNum
    let total = 0  // define total
    
    /* cast the num at index i to an int and reassigns to newNum, adds total and newNum and reassigns total
    increments i until i is less than length of num*/
    for (i = 0; i < len; i++){  
        newNum = parseInt(num[i])
        total = total + newNum
    }
    console.log(total) // output the total to console
}

sum()
