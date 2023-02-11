import org.jetbrains.intellij.tasks.RunIdeTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "se.clau.ironclad"
version = "2023.2.SNAPSHOT"
val psiViewerPlugin = "PsiViewer:${prop("psiViewerPluginVersion")}"
val ideaVersion = prop("ideaVersion")

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.intellij") version "1.12.0"
//    id("org.jetbrains.grammarkit") version "2022.3"
}

allprojects {
    apply(plugin = "idea")
    apply(plugin = "kotlin")
//    apply(plugin = "org.jetbrains.grammarkit")
    apply(plugin = "org.jetbrains.intellij")

    repositories {
        mavenCentral()
        maven("https://cache-redirector.jetbrains.com/repo.maven.apache.org/maven2")
        maven("https://cache-redirector.jetbrains.com/intellij-dependencies")
    }

    idea {
        module {
            generatedSourceDirs.add(file("src/main/gen"))
        }
    }

    // Configure Gradle IntelliJ Plugin
    // Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
    intellij {
        version.set(ideaVersion)
        updateSinceUntilBuild.set(true)

        plugins.set(listOf(/* Plugin Dependencies */))
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    tasks {
        // Set the JVM compatibility versions
        withType<JavaCompile> {
            sourceCompatibility = "17"
            targetCompatibility = "17"
        }
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
                languageVersion = "1.8"
                // see https://plugins.jetbrains.com/docs/intellij/using-kotlin.html#kotlin-standard-library
                apiVersion = "1.7"
                freeCompilerArgs = listOf("-Xjvm-default=all")
            }
        }
    } // end tasks
    sourceSets {
        main {
            java {
                srcDirs("src/main/java", "src/main/gen")
            }
            kotlin {
                srcDirs("src/main/kotlin")
//                resources { srcDirs("src/main/resources") }
            }
        }
    }
    kotlin {
        sourceSets {
            main {
                kotlin.srcDirs("src/main/kotlin")
            }
        }
    }
}

val copyrightPlugin = "com.intellij.copyright"
val javaPlugin = "com.intellij.java"

// Special module with run, build and publish tasks
project(":") {
    intellij {
        pluginName.set("intellij-ironclad")
        val pluginList = mutableListOf(
            psiViewerPlugin,
            copyrightPlugin,
            javaPlugin
        )
        plugins.set(pluginList)
    }

    tasks {
        buildPlugin {
            // Set proper name for final plugin zip. Otherwise, base name is the same as gradle module name
            archiveBaseName.set("intellij-ironclad")
        }
        runIde { enabled = true }
        withType<RunIdeTask> {
            jvmArgs("-Xmx1536m")
            // Don't show "Tip of the Day" at startup
            jvmArgs("-Dide.show.tips.on.startup.default.value=false")
            // Uncomment to enable localization testing mode
            // jvmArgs("-Didea.l10n=true")
        }
    }
}

fun prop(name: String): String =
    extra.properties[name] as? String
        ?: error("Property `$name` is not defined in gradle.properties")
