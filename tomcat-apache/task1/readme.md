# How to deploy this app

1. Get this app from repository
2. Download the latest version of **mod_jk.so** and copy it to **$APACHE_HOME/modules/**
3. Copy **mod_jk.conf** and **workers.properties** from **config** folder to **$APACHE_HOME/conf/extra/**
4. Add to **httpd.conf** the following:

    LoadModule jk_module modules/mod_jk.so
    Include conf/extra/mod_jk.conf

5. Build the app and deploy it to Tomcat
6. Go to http://localhost/dvproject