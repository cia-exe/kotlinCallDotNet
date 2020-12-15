
kotlin native call--> NativeLib.dll(c++) call--> NetFrameworkLibrary.dll(C# .net framework)

NativeLib.dll and NetFrameworkLibrary.dll are built by .\visualStudio\CppConsoleApp

native lib compiler/link path is absolute and defined in *.def

libcurl.a -> -lcurl
NativeLib.lib-> -lNativeLib

	info from stackoverflow:
	
	mingw also accepts libraries with a .lib extension.For instance, a library named libsample.lib must be linked as

	-llibsample

	Reference: http://www.mingw.org/wiki/Specify_the_libraries_for_the_linker_to_use

	New mingw versions support linking lib files. But I faced issues where .lib is with prefix libxxxx.lib.
	It ommits the preffix lib in linking. So make it like lib<name>.lib
	Also there are ways to convert a .lib to .a ex: lib2a You can use that as well.

	To fully specify a library name use : prefix. For example -l:libxxxx.lib
	On the contrary, when linking .lib files you would need to remove the lib prefix, e.g. -lssl would make the linker look for ssl.lib

//------------------





Toturial: https://kotlinlang.org/docs/tutorials/native/curl.html




kotlin code base is from:
https://github.com/JetBrains/kotlin-native/tree/master/samples/libcurl

# Curl interop library

This example shows how to build and publish an interop library to communicate with the libcurl,
HTTP/HTTPS/FTP/etc client library.

Install libcurl development files. For Mac - `brew install curl`. For Debian-like Linux - use `apt-get install libcurl4-openssl-dev` or `apt-get install libcurl4-gnutls-dev`.
For Windows - `pacman -S mingw-w64-x86_64-curl` in MinGW64 console, if you do
not have MSYS2-MinGW64 installed - install it first as described in http://www.msys2.org

To build use `../gradlew assemble`.

To publish the library into a local repo use `../gradlew publish`.

