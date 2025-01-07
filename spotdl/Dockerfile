FROM spotdl:latest

# Create a volume for the output directory
VOLUME /music

# Change CWD to /music
WORKDIR /music

# Entrypoint command
ENTRYPOINT ["spotdl", "web", "--host", "0.0.0.0", "--web-use-output-dir", "--output", "{artist}/{album}/{track-number} - {title}.{output-ext}"]
