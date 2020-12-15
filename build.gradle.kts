plugins {
    kotlin("multiplatform") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
    gradlePluginPortal()
    google()
}

kotlin {
    mingwX64("libcurl") {
        val main by compilations.getting
        val libcurl by main.cinterops.creating{

            //val mingwPath = File(System.getenv("MINGW64_DIR") ?: "C:/msys64/mingw64")
            val mingwPath = File("C:/msys64/mingw64")
            includeDirs.headerFilterOnly(mingwPath.resolve("include"))

            //linkerOpts("-L$mingwPath/lib")
        }
        val NativeLib by main.cinterops.creating{

            //val mingwPath = File(System.getenv("MINGW64_DIR") ?: "C:/msys64/mingw64")
            val mingwPath = File("C:/msys64/mingw64")
            //includeDirs.headerFilterOnly(mingwPath.resolve("include"))

            //linkerOpts("-L$mingwPath/lib")
        }

        binaries {
                executable {
                    entryPoint = "main"
                }
        }
    }



//    sourceSets {
//        val ktorVersion = "1.4.3"
//
//        val libcurlMain by getting {
//            dependencies {
//                implementation("io.ktor:ktor-client-curl:$ktorVersion")
//            }
//        }
//    }

    // Enable experimental stdlib API used by the sample.
//    sourceSets.all {
//        languageSettings.useExperimentalAnnotation("kotlin.ExperimentalStdlibApi")
//    }
}

tasks.wrapper {
    gradleVersion = "6.7.1"
    distributionType = Wrapper.DistributionType.ALL
}


//kotlin {
//
//    // Determine host preset.
//    val hostOs = System.getProperty("os.name")
//
//    // Create target for the host platform.
//    val hostTarget = when {
//        hostOs == "Mac OS X" -> macosX64("libcurl")
//        hostOs == "Linux" -> linuxX64("libcurl")
//        hostOs.startsWith("Windows") -> mingwX64("libcurl")
//        else -> throw GradleException("Host OS '$hostOs' is not supported in Kotlin/Native $project.")
//    }
//
//    hostTarget.apply {
//
//        compilations["main"].cinterops {
//            val libcurl by creating {
//
//                when (preset) {
//                    presets["macosX64"] -> includeDirs.headerFilterOnly("/opt/local/include", "/usr/local/include")
//                    presets["linuxX64"] -> includeDirs.headerFilterOnly("/usr/include", "/usr/include/x86_64-linux-gnu")
//                    presets["mingwX64"] -> {
//                        val mingwPath = File(System.getenv("MINGW64_DIR") ?: "C:/msys64/mingw64")
//                        includeDirs.headerFilterOnly(mingwPath.resolve("include"))
//                    }
//                }
//            }
//
//            binaries {
//                executable {
//                    entryPoint = "main"
//                }
//            }
//        }
//
////        mavenPublication {
////            pom {
////                 withXml {
////                     val root = asNode()
////                     root.appendNode("name", "libcurl interop library")
////                     root.appendNode("description", "A library providing interoperability with host libcurl")
////                 }
////            }
////        }
//    }
//
//    // Enable experimental stdlib API used by the sample.
//    sourceSets.all {
//        languageSettings.useExperimentalAnnotation("kotlin.ExperimentalStdlibApi")
//    }
//}
//
//tasks.wrapper {
//    gradleVersion = "6.7.1"
//    distributionType = Wrapper.DistributionType.ALL
//}
