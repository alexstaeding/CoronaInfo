
from elasticsearch import Elasticsearch
from coronainfo.config import ELASTIC_SEARCH_HOST, ELASTIC_SEARCH_PORT, ELASTIC_SEARCH_AUTH


def post(body):
    """Create New Data Entry Into the Elastic Search Index.

    Parameters
    ----------
    body : dict
        Body of the POST request.

    Returns
    -------
    payload : dict
        Payload formatted according to OpenAPI specifications
    http_status : int
        RFC 7231 HTTP status code
    """
    es = Elasticsearch([ELASTIC_SEARCH_HOST], http_auth=ELASTIC_SEARCH_AUTH, scheme="https", port=ELASTIC_SEARCH_PORT)

    # Create Index If not present on host
    if not es.indices.exists('newdata'):
        es.indices.create('newdata')

    # Create Document in index
    entry = es.index(index='newdata', doc_type=body["data"]["type"], body=body["data"]["attributes"])
    response = dict(data=dict(id=entry["_id"], type=entry["_type"], attributes=dict(index=entry["_index"])))
    return response, 201
