// Tales from the Crypt

#include <stdio.h>
#include <unistd.h>
#include <crypt.h>
#include <string.h>
#include <stdlib.h>

char* crack(char *hs, char *fileName, int c, int n) {
  FILE *f = fopen(fileName, "r");
  if (f == NULL) {
    perror("fopen");
    exit(1);
  }
  // Declare character buffer
  char buf[1024];
  
  while (fgets(buf, sizeof(buf), f) != NULL) {
    char *token;
    token = strtok(buf, "\n");
    // -----------------------------------
    // beginning of (n == 1)
    if (n == 1) {
      // if -c flag is also taken
      // flip case
      if (c == 1) {
        token[0] = token[0] ^ ' ';
      }
      // loop through 0-9
      int i = 0;
      while (i < 10) { 
        if (i == 0) {
          // concatenate the number 0 onto the word
          char num[2];
          sprintf(num, "%d", i);
          strcat(token, num);
          // get hasString
          char *salt = "$1$";
          char *hash = crypt(token, salt);
          // check if the hashstring is equal 
          // to one from the input file hs
          if (strcmp(hash, hs) == 0) {
            fclose(f); // close file f -- dict file
            return token; // return that word because correct
          }
        }
        else {
          // for every other case except appending zero
          // can just replace 0 with another number 1-9
          char c = i +'0'; // from int to char
          // change that last character to the 1-9 character
          token[strlen(token) - 1] = c;
          // get hasString
          char *salt = "$1$";
          char *hash = crypt(token, salt);
          // check if the hashstring is equal 
          // to one from the input file hs
          if (strcmp(hash, hs) == 0) {
            fclose(f); // close file f -- dict file
            return token; // return that word because correct
          }  
        }
        i++;
      } 
    } // -----------------------------------
   
    // -----------------------------------
    // not the -n flag option
    else if (n != 1) {
      // not the -n flag option but
      // if -c option flag then
      // automatically switches the case
      if (c == 1) {
        token[0] = token[0] ^ ' ';
      }
      // get hasString
      char *salt = "$1$";  
      char *hash = crypt(token, salt);
      // check if the hashstring is equal 
      // to one from the input file hs
      if (strcmp(hash, hs) == 0) {
        // if match, return that dictionary word 
        fclose(f); // close file f -- dict file
        return token;
      }
    } // -----------------------------------
  }
  // if no matches then return NULL
  fclose(f); // -- dict file
  return NULL; 
}

int main(int argc, char *argv[]) {

//   // //*** Process input arguments ***//

  char *input = NULL;
  char *output = NULL;
  char *dictionary = NULL;
  
  int n = 0;
  int c = 0;
  char a;
  // "i:o:d:nc"
  while((a = getopt(argc, argv, "i:o:d:nc")) != -1) {
    // specifies the input shadow password  file.
    if( a == 'i') { 
      input = optarg;
    }
    // specifies the output file to store the cracked passwords
    if( a == 'o') {
      output = optarg; 
    }
    // specifies the dictionary file that stores the list of candidate passwords.
    // The supplied words file is a UNIX dictionary with a large number of words 
    // intended for spellchecking.
    if( a == 'd') {
      dictionary = optarg;
    }
    // append each of the single digits, 0-9, to end of the candidate.
    if( a == 'n') { 
      n = 1;
    }
  //   // toggle the case of the  first letter of the candidate.
    if( a == 'c') { 
      c = 1;
    }
  }
  
  // Example invocation
  // ./crack -i tests/shadow_case_number -o output -d words -c -n
  // The test.py automatically invokes program 
  // with appropriate inputs for each test case.

  //*** You do the rest ***//

  // open the input file and loop through each of its lines. 
  // Use strtok to extract the hash string from each line.
  // Open the file -- input from optarg from -i
  FILE *f = fopen(input, "r"); // input fil
  FILE *o = fopen(output, "w"); // output file

  // Check the return code
  if (f == NULL || o == NULL) {
    perror("fopen");
    exit(1);
  }
  // Declare character buffer
  char buf[1024];
  int line = 0; 
  while (fgets(buf, sizeof(buf), f) != NULL) {
    // extract hashstring
    // want this part -> $1$$VD002Iq9ks/wo/H1EXJtJ0
    char *token = strtok(buf, ":");
    token = strtok(NULL, "\n");
    // token is hashString
    // dictioary from -d
    // take the -c and -n flags as input
    char* password = crack(token, dictionary, c, n);
    
    line++;
    // takes optarg as output file o name from -o
    fprintf(o, "%s", password);
    if (line < 5) { // don't print /n on last line -->
      fprintf(o, "%s", "\n");
    }
  }
  
  // close files
  fclose(o);
  fclose(f);
    
  return 0;
}