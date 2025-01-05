server {
    listen {{ .interface }}:{{ .port }} default_server;

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;

    location / {
        allow   172.30.32.2;
        deny    all;

        proxy_redirect '/' $http_x_ingress_path/;
        sub_filter 'href="/' 'href="$http_x_ingress_path/';
        sub_filter '<script src="/' '<script src="$http_x_ingress_path/';
        sub_filter "top.location.href='" "top.location.href='$http_x_ingress_path";

        sub_filter '"/api' '\"$http_x_ingress_path/api';
        sub_filter '"/assets' '\"$http_x_ingress_path/assets';
        sub_filter '"/socket.io"' '"$http_x_ingress_path/socket.io"';

        sub_filter_once off;
        sub_filter_types *;

        proxy_pass {{ .protocol }}://backend;
    }

}