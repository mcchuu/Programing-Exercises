# function to determine if user input is palindrome 
def palindrome():
    string = input('enter a message: ').lower  # prompt user to enter a message
    stringpal = string[::-1]  # reverse string from last index, assign to stringpal
    # message is palindrome if string is equal to string pal, else it is not
    if stringpal == string: 
        print('message is palindrome')
    else:
        print('message is not palindrome')
palindrome()