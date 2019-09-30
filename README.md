# correlation

## An open source project to integrate correlation id into your springboot application.

Add dependency to your project

```
<dependency>
  <groupId>org.commonsources</groupId>
  <artifactId>correlation</artifactId>
  <version>1.0.7.RELEASE</version>
</dependency>
```

Steps to incorporate correlation id into your project.

Add ```@ComponentScan("com.correlation.*")```

Add logback.xml into your resource folder and paste the following pattern 
or if you already have the logback.xml change pattern for your loggings

<configuration>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <!-- encoders are assigned the type
             ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>%d{HH:mm:ss.SSS} %X{correlationId} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <root level="debug">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>

This project also has the configuration to append correlation id for rest template.

RestTemplate can be used via Dependency injection.

```
@Inject
RestTemplate restTemplate
```

## License
correlation is Open Source software released under the Apache 2.0 license.

