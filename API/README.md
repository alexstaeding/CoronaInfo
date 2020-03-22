# CoronaInfo REST-API Interface

## Usage
 
### Docker

The REST-API can be used as a Docker container, allowing for easy deploy and development. The required parameters to
access the ES instance can be specified as enviromental parameters. The following table shows the accordind parameters
and default values

| ENV | Description | Default |
| --- | ----------- | ------- |
| ELASTIC_SEARCH_HOST | URL or IP of ES Instance | localhost |
| ELASTIC_SEARCH_PORT | PORT to contact the ES instance | 9243 |
| ELASTIC_SEARCH_USER | Username to access the instance | elastic |
| ELASTIC_SEARCH_PASS | Password to access the instance | elastic |


### Development Purposes

For development purposes you can use flasks integrated wsgi server. Don't do this in production mode! Running the API
just requires a working python 3.7 interpreter. Run the following commands on your terminal (e.g. bash) to install the
required packages and use the API.

````bash
cd ../coronainfo/API

# Install package and missing dependencies into your python environemnt
python setup.py install

# Run the development server
python coronainfo/app.py
````

You can access the included swagger-ui by typing the following url in your browser <http://localhost:8080/api/v1/ui>

### Maintainers

- [ag1989](https://github.com/ag1989)
