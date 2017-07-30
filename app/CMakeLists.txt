##libnative-lib.so
set(Project F:/workspace/SoundDemo)
cmake_minimum_required(VERSION 3.4.1)

#F:\workspace\SoundDemo\app\src\main\jni\native-lib.cpp
add_library(native-lib  SHARED   ${Project}/app/src/main/jni/native-lib.cpp )

add_library(fmod SHARED  IMPORTED)
set_target_properties(fmod PROPERTIES IMPORTED_LOCATION
                      ${Project}/app/libs/${ANDROID_ABI}/libfmod.so)

add_library(fmodL SHARED  IMPORTED)
set_target_properties(fmodL PROPERTIES IMPORTED_LOCATION
                      ${Project}/app/libs/${ANDROID_ABI}/libfmodL.so)


include_directories( ${Project}/app/src/main/jni/inc)
find_library(log-lib  log )
target_link_libraries(native-lib   fmod  fmodL   ${log-lib} )