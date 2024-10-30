FROM homebridge/homebridge:latest

# Relocate homebridge working directory so it can be persisted
RUN find /etc/s6-overlay/ -type f | xargs sed -i -E 's:([ "])/homebridge:\1/config:g'

ARG BUILD_ARCH=amd64
ARG TEMPIO_VERSION="2021.09.0"

# add bashio
ADD https://github.com/hassio-addons/bashio/archive/v0.16.0.tar.gz /tmp/bashio.tar.gz
RUN apt-get update \
    && apt-get install --no-install-recommends -y curl jq nginx\
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/* \
    && mkdir /tmp/bashio \
    && tar zxvf \
        /tmp/bashio.tar.gz \
        --strip 1 -C /tmp/bashio \
    \
    && mv /tmp/bashio/lib /usr/lib/bashio \
    && ln -s /usr/lib/bashio/bashio /usr/bin/bashio \
    \
    && curl -L -s -o /usr/bin/tempio \
        "https://github.com/home-assistant/tempio/releases/download/${TEMPIO_VERSION}/tempio_${BUILD_ARCH}" \
    && chmod a+x /usr/bin/tempio \
    \
    && rm -fr \
    /etc/nginx \
    /tmp/*

# Copy root filesystem
COPY rootfs /

# Add the nice banner
RUN chmod +x /etc/s6-overlay/s6-rc.d/banner/script && \
    sed -i '1 s/^.*$/#!\/command\/with-contenv bashio/' /etc/s6-overlay/s6-rc.d/banner/script
    