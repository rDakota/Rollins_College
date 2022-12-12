// Demonstration of the crypt() function

// Compile this program using: 
//     gcc -Wall -o example example.c -lcrypt
//
// -lcrypt is required to link in the crypt library

#include <stdio.h>
#include <unistd.h>
#include <crypt.h>

int main() {


  // password -> $1$$I2o9Z7NcvQAKp7wyCTlia0
  // Password -> $1$$evwpigkoE8f96iTMTyGOP0
  // Password1 -> $1$$XLQov1ZlfgvOKCmjVrCO60
  // Password123 -> $1$$xHo/Yzm9Uxp7MKBlD6fdm1
  // drowssap -> $1$$3EpNdLKKO9EEHIxjhpy0A0
  char *key = "password";
  char *salt = "$1$";  // Always use "$1$" for the salt string
  char *hash = crypt(key, salt);

  printf("%s\n", hash);

    
  return 0;
}