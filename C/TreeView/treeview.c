#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <dirent.h>
#include <errno.h>
#include <string.h>

static int files = 0;;
static int dirs = 0 - 1;
static int levels = 0;
static FILE *out;

int index_file(char *path, int level);
int is_dir(char *path);
//char *_strcat(char *tmp, char *append);

int main(int argc, char **argv){
    if(argc != 2) {
        printf("usage: %s [dir]\n", argv[0]);
        return 0;
    }
    if((out = fopen("tree.out", "w+")) == NULL)
    {
        perror("fopen:");
        exit(EXIT_FAILURE);
    }
    index_file(argv[1], levels);

    printf("\n\n");
    printf("\x1b[4;34;42m  files: %d \x1b[0m", files);
    printf("\x1b[4;35;43m  dirs: %d \x1b[0m", dirs);
    printf("\x1b[4;36;44m  levels: %d \x1b[0m\n", levels);

}

int index_file(char* path, int level){
    DIR *dir;
    struct dirent *dirent;
    int i= 0;
    for(; i < level - 1; i++)
            printf("│  ");
    if(level > 0)
        printf("├──\x1b[0;31m%s\x1b[0m\n", strrchr(path, '/')+1);
    else
        printf("%s\n", path);
    fputs(path, out);
    fputc('\n', out);
    if(is_dir(path)){
        dirs++;
        if((dir = opendir(path)) == NULL){
            printf("cannot open dir!\n");
            exit(EXIT_FAILURE);
        }
        while((dirent = readdir(dir)) != NULL){ // && !(strcmp(".", dirent->d_name) || strcmp("..", dirent->d_name))){
            //printf("%d %s\n", strcmp("..", dirent->d_name), dirent->d_name);
            if(strcmp(".", dirent->d_name) && strcmp("..", dirent->d_name))
            {
            char *tmp = malloc(sizeof(char)*1024);
            memset(tmp, '0', 1024);
            strcpy(tmp, path);
            if(strcmp(tmp, ".") && strcmp(tmp, ".."))
                {
                if(strcmp("/\0", rindex(tmp, '/')))
                    strcat(tmp, "/");
                }
            else
                strcat(tmp, "/");
            strcat(tmp, dirent->d_name);
            index_file(tmp, level + 1);
            free(tmp);
            levels = level + 1;
            }
        }
    } else {
        files++;
        return level;
    }
}

int is_dir(char* path){
    DIR *dir =  opendir(path);
    if(dir != NULL){
        closedir(dir);
        return 1;
    }
    if(errno == ENOTDIR){
        return 0;
    }
    return -1;
}

/*
char *_strcat(char *tmp, char *append){
    char *buff = strcpy(buff, tmp);
    buff =  strcat(buff, append);
    return buff;
}
*/
