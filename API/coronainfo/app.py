"""Coronainfo REST-API Interface."""

import logging
import connexion
from connexion.resolver import RestyResolver

logging.basicConfig(level=logging.INFO)

if __name__ == '__main__':
    app = connexion.App(__name__)
    app.add_api('openapi.yaml', resolver=RestyResolver('api'), strict_validation=True)
    app.run(port=8080)
