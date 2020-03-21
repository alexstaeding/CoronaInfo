FROM python:3.7-slim-buster

# ############################################################################ #
#                    COPY APPLICATION TO CONTAINER                             #
# ############################################################################ #
COPY . /coronainfo
WORKDIR /coronainfo

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

CMD ["python coronainfo/app.py"]
