plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "br.com.dio"
version = "0.0.1-SNAPSHOT"

val mapstructVersion = "1.5.5.Final"
val lombokVersion = "1.18.30"
val lombokMapstructBinding = "0.2.0" 

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	implementation("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
	
	compileOnly("org.projectlombok:lombok:$lombokVersion")
	
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")	
	annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}
