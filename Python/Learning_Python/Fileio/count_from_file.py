''' Program to count the occurrences in a file
    dictionary and file I/O practice
    CMS120, Fall 2020
'''

def num_count(f):
    d = {}
    
    # lines is a list of strings
    #lines = f.readlines() # returns list, each entry is str one line long
    for line in f:
        #line = line.strip() is not neccesary bc of int() function
        num = int(line)
        while num != 0:
            digit = num % 10 # takes off last letter
            digit_count = d.get(digit, 0)
            d[digit] = digit_count + 1 
            num = num // 10 # decrement integer each time
    
    
    #print(d)
    return d

def letter_count(f):
    d = {}

    # always bringing in a string!!!!!!!
    for line in f:
        line = line.strip() # must assign to variable because str immutable
        for letter in line:
            #print(letter)
            current_count = d.get(letter, 0) # if not seen keep at defualt
            d[letter] = current_count + 1 # for every seen incrment by 1 
            
            
            # will not create duplicates
    #print(d)
    return d
    
def main():
    ''' main funciton which opens the file
        calls the function and
        closes the file
    '''
    
    # change to small_words.txt for easier debugging
    # while you are working
    filename = input("Please enter the filename to analyze: ")
    f = open(filename)
    
    #l_dict = letter_count(f)
    num_dict = num_count(f)
    print(num_dict)
    #print(l_dict)
    #letter_dict = letter_count(f)
    # You can print the dictionary if need to 
    # debug
    f.close()
    
if __name__ == "__main__":
    main()