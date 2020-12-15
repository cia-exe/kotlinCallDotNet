#pragma once

#ifdef NATIVELIB_EXPORTS
#define DLL_API __declspec(dllexport)
#else
#define DLL_API __declspec(dllimport)
#endif

#ifdef  __cplusplus
extern "C" {
#endif

    DLL_API void Test();

#ifdef  __cplusplus
extern };
#endif

