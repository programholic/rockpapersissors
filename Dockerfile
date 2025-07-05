# Use official OpenJDK base image
FROM openjdk:17

# Set working directory inside container
WORKDIR /app

# Copy the java file
COPY Game.java .

# Compile the Java file
RUN javac Game.java

# Run the compiled Java program
CMD ["java", "Game"]
