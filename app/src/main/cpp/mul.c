//
// Created by 32174224 on 2018-09-17.
//
#include <jni.h>
#include <stdlib.h>
#include<string.h>

char* inBuff( int length,const char *a){
    char temp[2];
    for (int i = 0; i < length; i++) {
        temp[i] = a[i];
    }
    return *temp;
}

JNIEXPORT void JNICALL
        Java_com_example_a32174224_multi_MainActivity_save(JNIEnv *env, jclass type,
                                                           jstring str){
    const char *buff = (*env)->GetStringUTFChars(env, str,NULL);
    int length =(*env)->GetStringLength(env,str);
    inBuff(length,buff);
}