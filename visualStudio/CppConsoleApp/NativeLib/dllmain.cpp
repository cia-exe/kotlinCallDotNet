// dllmain.cpp : Defines the entry point for the DLL application.


#include "pch.h"
//#include "dllmain.h"
#include "nativeLib.h"
#include <iostream>

//#using <NetFrameworkLibrary>
using namespace NetFrameworkLibrary;


BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
                     )
{
    switch (ul_reason_for_call)
    {
    case DLL_PROCESS_ATTACH:
    case DLL_THREAD_ATTACH:
    case DLL_THREAD_DETACH:
    case DLL_PROCESS_DETACH:
        break;
    }
    return TRUE;    
}

void Test()
{
    std::cout << "NativeLib Test++\n";
    Class1^ pInstance = gcnew Class1();
    pInstance->go();
    std::cout << "NativeLib Test--\n";
}
