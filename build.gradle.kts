plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.openapi.generator") version "7.2.0"
}

group = "com.pyur"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2024.0.0"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-vault-config")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	implementation("io.swagger.core.v3:swagger-annotations:2.2.19")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("com.oracle.database.jdbc:ojdbc8:19.8.0.0")
	runtimeOnly("com.h2database:h2")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

openApiGenerate {
	generatorName.set("spring")
	inputSpec.set("$projectDir/docs/openapi.yaml")
	outputDir.set(layout.buildDirectory.dir("generated").get().asFile.absolutePath)
	apiPackage.set("com.pyur.fiber.optic.network.api")
	modelPackage.set("com.pyur.fiber.optic.network.model")
	configOptions.set(
		mapOf(
			"useSpringBoot3" to "true",
			"useSpringfox" to "false",
			"interfaceOnly" to "true",
			"dateLibrary" to "java8"
		)
	)
}

sourceSets {
	main {
		java {
			srcDir(layout.buildDirectory.dir("generated/src/main/java").get().asFile.absolutePath)
		}
	}
}

tasks.withType<JavaCompile> {
	dependsOn("openApiGenerate")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
