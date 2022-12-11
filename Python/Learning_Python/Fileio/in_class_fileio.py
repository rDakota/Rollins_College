'''
This program will retunr the occurences of a certain inputed character
'''

def main():
    '''
    This function takes in input for a filename and a char and will until.
    inside the file I ultilize nested loops to count the number of times that character ocurs
    '''
    # if says submission in IDE THAT IS NOT WHAT YOU WANT!!!
    #type first few letters then tab in terminal
    # up arrow
    # to turn in find folder, has a slash at the end
    # submite fle and view sibmission
    #look at how stacks up woth test cases 
    
    
	#Write your program in this function
    count = 0
    # Prompt the user for a file name
    filename = input("Please enter the filename to search:") # just a string
    # Prompt the user for a character to search the file for
    char = input("Please enter the character to search for:")
    
    #print("Search", filename, "for character", char)
    
    # Open the file
    file_in = open(filename) # variable is the atual file
    
    # Loop though the file line-by-line
    for line in file_in:
        #print(line)

    # For each line, count the number of letters (asked for by the user!)
    # in that line
        # line.count()
        for character in line:
            if character == char:
                count += 1
            # no else needed
        


    # print out the total number of characters found
    print("Found", count, char, end="")
    print("'s")
    # Don't forget to close the file!
    file_in.close()



if __name__ == '__main__':
    main()