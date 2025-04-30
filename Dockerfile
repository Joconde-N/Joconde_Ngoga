# Use an official OpenJDK runtime as a parent image
FROM openjdk:11

# Set your student ID as an environment variable
ENV STUDENT_ID=26441

# Set the working directory
WORKDIR /app

# Copy your project files
COPY . /app/

# Compile all Java files
RUN find . -name "*.java" -exec javac {} \;

# Create a shell script to run the different programs
RUN echo '#!/bin/sh\ncase "$1" in\n  "construction") java Assignment_one.Question1.ConstructionMain ;;\n  "hotel") java Assignment_one.Question2.HotelMain ;;\n  "traffic") java Assignment_one.Question3.TrafficMain ;;\n  *) echo "Please specify which program to run: construction, hotel, or traffic" ;;\nesac' > /app/run.sh
RUN chmod +x /app/run.sh

# Set the default program to run
ENTRYPOINT ["/bin/sh", "/app/run.sh"]
CMD ["construction"]