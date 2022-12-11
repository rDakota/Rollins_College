'''This program allows two tests: abecedarian() and starts_and_ends_with()
to test a given file of words for a certain case'''
def starts_and_ends_with(word, match):
    '''function returns boolean value based on if 
    the begginning two letters and ending two letters
    of a word match'''
    if word[0:2] == match:
        if word[-2:] == match:
            return True
    return False

def abecedarian(word):
    '''function returns boolean value based on if word
    is in alphabetical order'''
    index = 1
    while index < len(word):
        if word[index - 1] > word[index]:
            return False
        index += 1
    return True

def print_menu():
    ''' function to print the menu of options for the user'''
    print("Your options:")
    print("\t1. starts_and_ends_with")
    print("\t2. abecedarian")

def main():
    ''' function to process user input 
        Complete the function by implementing the 
        functionality outlined in the comments
    '''
    
    # open words.txt file
    file_in = open("words.txt")

    choice = 0
    while (choice <= 0 or choice >= 4):
        print_menu()
        choice = int(input("Select your choice: "))
    
    if choice == 1:  # starts_and_ends_with
        substr = str(input("Enter the string to begin/end the word with: "))
        # read lines in words.txt and call starts_with_ends_with
        # to see if that line/word starts and ends with the substring
        # the user entered
        for my_word in file_in:
            my_word = my_word.strip()
            if starts_and_ends_with(my_word, substr):
                print(my_word)

    else:   # choice == 2 (abecedarian)
        # want to only look for words that start with a specific letter
        # so get that letter from the user
        letter = input("Enter the letter to start abededarian words: ")
        # read line/words in words.txt and see if they begin with the letter
        # the user entered.  If it does, call is_abecedarian to see if the
        # word is an abededarian word.  If it is, print it out.
        for my_word in file_in:
            my_word = my_word.strip()
            if my_word[0] == letter:
                if abecedarian(my_word):
                    print(my_word)

    # close words.txt file
    file_in.close()

if __name__ == "__main__":
    main()