#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <unistd.h>
#include <errno.h>

int main(int argc, char **argv){
    if(argc != 2){
        return -1;
    }

    DIR *dir;
    struct dirent *dirent;
    if((dir = opendir(argv[1])) == NULL){
        perror("Dir:");
    }
    while((dirent = readdir(dir)) != NULL){
        printf("%s\n", dirent->d_name);
    }
}
