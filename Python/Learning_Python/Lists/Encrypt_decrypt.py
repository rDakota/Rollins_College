def decrypt(matrix, cipher):
    plain = ""
    index = 0
    stop = 2
    while index < len(cipher):
            pair = (cipher[index:stop])
            
            index += 2
            stop += 2
            
            row = int(pair[0])
            col = int(pair[1])
            # print(row, col)
            # print()
            # print(pair, "\n")
            
            
            plain += matrix[row][col]
            #print(plain)
            
    return plain
    
def encrypt(matrix, plain):
    cipher = ""
    
    for char in plain:
    
        row = 0
        
        # searching matrix for specific character
        while row < len(matrix):
            col = 0 
            while col < len(matrix[row]):
                #print(matrix[row][col])
                if matrix[row][col] == char:
                    #print("found it", row, col)
                    #print(row, col)
                    cipher += str(row)
                    cipher += str(col)
                col += 1
            row += 1

    return cipher
    
key = [
    ['z', 'e', 'b', 'r', 'a'],
    ['c', 'd', 'f', 'g', 'h'],
    ['i', 'k', 'l', 'm', 'n'],
    ['o', 'p', 'q', 's', 't'],
    ['u', 'v', 'w', 'x', 'y']
]

ciphertext = "043434041021043411044224"
#print(ciphertext)
plaintext = decrypt(key, ciphertext)
print("decrypted:", plaintext)
ciphertext = encrypt(key, plaintext)
print("encrypted:", ciphertext)
