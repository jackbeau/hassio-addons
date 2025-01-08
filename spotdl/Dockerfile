FROM spotdl/spotify-downloader:latest

# Create a volume for the output directory
VOLUME /music

WORKDIR /

VOLUME /config

COPY run.sh /

RUN chmod +x /run.sh

# START COMMAND
ENTRYPOINT [ "" ]

CMD [ "/run.sh" ]