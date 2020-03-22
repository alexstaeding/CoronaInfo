FROM python:3.7-slim-buster

# ############################################################################ #
#                    COPY APPLICATION TO CONTAINER                             #
# ############################################################################ #
COPY . /coronainfo
WORKDIR /coronainfo
RUN chmod 777 /coronainfo/docker_entrypoint.sh

# ############################################################################ #
#                    Install Application and Dependencies                      #
# ############################################################################ #
RUN apt-get update \
    && pip install --upgrade pip==19.3.1 \
    && python setup.py install \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# ############################################################################ #
#                           RUN COMMAND LINE                                   #
# ############################################################################ #
EXPOSE 8080
ENTRYPOINT ["/coronainfo/docker_entrypoint.sh"]
