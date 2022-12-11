# f = open("words.txt")
# out_file = open("output.txt", "w")

# # count = 0
# # for line in f:
# #     no_whitespace = line.strip() # removes all the whitespace
# #     # passes str 
# #     out_file.write("Line " + str(count) + " " + no_whitespace + "\n") 
# #     count += 1

    

# # #file_in = f.read()# returns data and stores in file_in
# # #file_in = f.readlines() #returns what is in file includeing the \n
# # file_in = f.readline()
# # file_in = file_in.strip()
    
# # includes the white space

#     # comes in as string!!!!!!!

# # print(file_in) # print provides a newline
# # #print(file_in[-1])
# # print(len(file_in))

# must close file
#  f.close()
#  out_file.close()


in_file = open("words.txt")


longest = []
count = 0 


for word in in_file:
    word = word.strip()
    if len(word) == count: # found another longest word
        longest.append(word)
    
    if len(word) > count: # just found new longest word
        longest = []
        longest.append(word)
        count = len(word)

    print("Word: '{}' has Length: {}".format(word, len(word)))
    
print("The longest word was {}".format(longest))
print("length:", count)
# print(f"The length: {count}")

in_file.close()
