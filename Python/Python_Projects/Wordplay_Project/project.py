'''
This project performs various english word analyses based on a text file of words
'''
def palindrome(word):
    '''function will return a boolean value if a word is a palindrome.
    A palindrome is a word that reads the same backwards and forwards
    such as "radar" or "civic". '''
    # string slicing [beginning:end:step]
    if word == word[::-1]: # if the word is the same word sliced backwards
        return True
    return False
    
def anagram(word_1, word_2):
    '''function will return a boolean value if two words are anagrams of each other.
    An anagram is a word formed by rearranging the words of another.
    "veil" and "vile" are anagrams of "evil".'''
    # initialize both the lists
    w1_list = []
    w2_list = []
    if word_1 != word_2: # do not want to return True if the same word
        for l in word_1:
            w1_list.append(l) # append every letter in the word into a list
        for l in word_2:
            w2_list.append(l) # do the same as above in different list

        # sort both lists
        w1_list.sort() 
        w2_list.sort()
        #print(w1_list)
        #print(w2_list)

        # the two alphabetized lists are compared to determine if anagram
        if w1_list == w2_list:
            return True
    return False
    
def isogram(word):
    '''function will return a boolean value if a word is a isogram.
    An isogram is a word with no repeating letters
    such as "ambidextrous" or "equal".'''
    d = {} # initialize the dictionary
    
    for letter in word:
        # add the letters to a dict
        # for time every seen, incrment the value in the dict by 1
        # if not seen keep at defualt of 0
        count = d.get(letter, 0)
        d[letter] = count + 1
    # print(d) # the dict should show values of 1 across all letters
    # if the sum of the values of the dictionary are equal to 
    # the length of the values in the dictionary
    # then the word is an isogram
    if sum(d.values()) == len(d.values()): 
        return True
    return False
    
def main_menu():
    ''' function to print the main menu of options for the user'''
    # The main menu shows the several word analysis options for the user
    print("Analysis options:")
    print("\t1. palindrome search") # prints all palindromes and prints frequency
    print("\t2. anagram finder") # user provides word and returns any of its anagrams
    print("\t3. isogram search") # prints dict of isogram frequency starting with each letter

def main():
    '''
    This main function calls all other word analysis functions
    and allows the user to chose which data they would like to recieve
    '''
    print("This is my final homework!")
    # ask for filename
    filename = input("Please enter the filename to analyze: ")
    file_in = open(filename)

    choice = 0 # initialized 
    while (choice <= 0 or choice >= 4):
    # menu will open each time the program is run
        main_menu()
        choice = int(input("Select your choice of word analysis: "))

    if choice == 1:
        pal_list = []
        for file_word in file_in: # search in file
            file_word = file_word.strip() # strip whitespace
            if palindrome(file_word): # if palindrome(file_word) returns True
                print(file_word)
                pal_list.append(file_word) # add word to the list
        print("There are {} palindromes in this text file.".format(len(pal_list)))

    elif choice == 2:
        user_word = input("Enter a word to determine if it's an anagram: ")
        ana_list = [] # initialize
        for file_word in file_in: #search
            file_word = file_word.strip() # strip whitespace
            #print(file_word)
            if anagram(file_word, user_word): # if returns True
                print(file_word)
                ana_list.append(file_word) # add to list
        print("There is/are {} anagrams for {}".format(len(ana_list), user_word))
        
    else: # choice 3
        d = {} # initialize dict
        for file_word in file_in: 
            file_word = file_word.strip()
            if isogram(file_word): # if returns True
                # add the first letters of each isogram to the dict
                # icrement the values by 1 everytime seen
                count = d.get(file_word[0], 0)
                d[file_word[0]] = count + 1
        print(d) # prints the isogram frequency of each starting letter

    file_in.close()
    

if __name__ == '__main__':
    main()