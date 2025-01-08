FROM spotdl/spotify-downloader:latest

# Create a volume for the output directory
VOLUME /music

VOLUME /config

COPY run.sh /

RUN chmod +x /run.sh

WORKDIR /music

# START COMMAND
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["/run.sh"]